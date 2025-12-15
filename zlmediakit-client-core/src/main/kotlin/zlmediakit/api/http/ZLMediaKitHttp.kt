package zlmediakit.api.http

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import zlmediakit.api.config.HttpConfig
import zlmediakit.api.exception.ZLMediaKitHttpException
import zlmediakit.api.exception.ZLMediaKitResponseException
import zlmediakit.api.model.IZLMediaResponse
import zlmediakit.api.model.ZLMediaCode
import java.io.InputStream

class ZLMediaKitHttp(
    val config: HttpConfig,
    val adapter: ZLMediaKitHttpAdapter
) {

    inline fun <reified T> requestToQueryParams(request: T?): Map<String, String?> {
        if (request == null) {
            return emptyMap()
        }
        val json = Json {
            encodeDefaults = true
        }
        return json.encodeToJsonElement<T>(request).jsonObject.mapValues {
            if (it.value.jsonPrimitive.content == "null") {
                return@mapValues null
            }
            if (it.value.jsonPrimitive.content == "true") {
                return@mapValues "1"
            } else if (it.value.jsonPrimitive.content == "false") {
                return@mapValues "0"
            }
            return@mapValues it.value.jsonPrimitive.content
        }
    }

    fun httpGetParams(params: Map<String, String?>?): LinkedHashMap<String, String> {
        val queryParams = linkedMapOf<String, String>()
        queryParams["secret"] = config.secret
        if (params == null) {
            return queryParams
        }
        for ((name, value) in params) {
            if (value == null) {
                continue
            }
            if (value.isNotBlank()) {
                queryParams[name] = value
            }
        }
        return queryParams
    }

    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    inline fun <reified Response : IZLMediaResponse> httpMapGetJson(
        url: String,
        request: Map<String, String?>? = null,
    ): Response {
        val body = adapter.httpGet(
            baseUrl = config.baseUrl,
            url = url,
            params = httpGetParams(request)
        )
        if (body.isEmpty()) {
            throw ZLMediaKitHttpException(message = "请求结果为空")
        }
        val data: Response
        try {
            val json = Json {
                ignoreUnknownKeys = true
                encodeDefaults = true
            }
            data = json.decodeFromString<Response>(body)
        } catch (e: Throwable) {
            throw ZLMediaKitHttpException(
                message = "请求结果解析失败",
                cause = e
            )
        }
        if (data.code != ZLMediaCode.Success.code) {
            throw ZLMediaKitResponseException(data)
        }
        return data
    }

    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    inline fun <reified Request, reified Response : IZLMediaResponse> httpGetJson(
        url: String,
        request: Request? = null,
    ): Response = httpMapGetJson<Response>(
        url = url,
        request = requestToQueryParams<Request>(request)
    )

    @Throws(
        ZLMediaKitHttpException::class,
    )
    inline fun <reified Request> httpGetStream(
        url: String,
        request: Request? = null,
    ): InputStream {
        val params = requestToQueryParams(request)
        return adapter.httpGetStream(
            baseUrl = config.baseUrl,
            url = url,
            params = httpGetParams(params)
        )
    }
}