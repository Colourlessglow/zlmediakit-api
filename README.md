# ZlmediakitApi

zlmediakit api kotlin 封装请求客户端

## 实现的API 列表

> [ZLMediaKit API 参数参考](https://docs.zlmediakit.com/zh/guide/media_server/restful_api.html)

- /index/api/getApiList
- /index/api/getThreadsLoad
- /index/api/getWorkThreadsLoad
- /index/api/addStreamProxy
- /index/api/delStreamProxy
- /index/api/addFFmpegSource
- /index/api/delFFmpegSource
- /index/api/getAllSession
- /index/api/kick_session
- /index/api/kick_sessions
- /index/api/close_streams
- /index/api/getMediaList
- /index/api/restartServer
- /index/api/startRecord
- /index/api/stopRecord
- /index/api/isRecording
- /index/api/getSnap
- /index/api/getServerConfig
- /index/api/setServerConfig
- /index/api/deleteRecordDirectory
- /index/api/getRtpInfo
- /index/api/getMp4RecordFile
- /index/api/openRtpServer
- /index/api/closeRtpServer
- /index/api/listRtpServer
- /index/api/startSendRtp
- /index/api/startSendRtpPassive
- /index/api/stopSendRtp
- /index/api/getStatistic
- /index/api/addStreamPusherProxy
- /index/api/delStreamPusherProxy
- /index/api/version
- /index/api/getMediaPlayerList


## 初始化客户端

```kotlin
val client = ZLMediaKitClient(
    baseUrl = "http://127.0.0.1:8000",
    secret = "xxxx"
)

val response = client.getApiList()
println(response)
val apiList = response.data
println(apiList)
```

## 自定义网络请求工具

```kotlin
class OkhttpAdapter: ZLMediaKitHttpAdapter {
    val client: OkHttpClient

    init {
        client = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    fun okhttpGet(baseUrl: String, url: String, params: Map<String, String>): Response {
        val urlBuilder = URI(baseUrl+url).normalize().toHttpUrlOrNull()!!.newBuilder()
        for ((name, value) in params) {
            urlBuilder.addQueryParameter(name = name, value = value)
        }
        val request = Request.Builder()
            .url(urlBuilder.build())
            .get()
            .build()
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
}
```