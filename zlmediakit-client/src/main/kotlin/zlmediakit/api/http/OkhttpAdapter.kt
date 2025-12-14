package zlmediakit.api.http

import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import zlmediakit.api.config.ZLMediaKitConfiguration
import zlmediakit.api.exception.ZLMediaKitHttpException
import java.io.InputStream
import java.net.URI
import java.util.concurrent.TimeUnit

class OkhttpAdapter(val config: ZLMediaKitConfiguration): ZLMediaKitHttpAdapter {
    internal val client: OkHttpClient

    init {
        val builder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
        config.okhttpClient?.accept(builder)
        client = builder.build()
    }

    internal fun okhttpGet(baseUrl: String, url: String, params: Map<String, String>): Response {
        val urlBuilder = URI(baseUrl+url).normalize().toHttpUrlOrNull()!!.newBuilder()
        for ((name, value) in params) {
            urlBuilder.addQueryParameter(name = name, value = value)
        }
        val requestBuilder = Request.Builder()
            .url(urlBuilder.build())
        for ((name, value) in BASIC_HEADERS) {
            requestBuilder.header(name, value)
        }
        val request = requestBuilder.get().build()
        val response = client.newCall(request).execute()
        if (!response.isSuccessful) {
            throw ZLMediaKitHttpException("请求失败")
        }
        return response
    }

    override fun httpGet(baseUrl: String, url: String, params: Map<String, String>): String {
        val response = okhttpGet(baseUrl, url, params)
        val body = response.body.string()
        if (body.isEmpty()) {
            throw ZLMediaKitHttpException("请求结果为空")
        }
        return body
    }

    override fun httpGetStream(baseUrl: String, url: String, params: Map<String, String>): InputStream {
        val response = okhttpGet(baseUrl, url, params)
        if (!response.isSuccessful) {
            throw ZLMediaKitHttpException("请求失败")
        }
        return response.body.byteStream()
    }

    private companion object {
        val BASIC_HEADERS = mapOf(
            "User-Agent" to "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36"
        )
    }
}