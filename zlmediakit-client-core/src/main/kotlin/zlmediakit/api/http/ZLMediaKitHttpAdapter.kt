package zlmediakit.api.http

import java.io.InputStream

interface ZLMediaKitHttpAdapter {
    fun httpGet(baseUrl: String, url: String, params: Map<String, String>): String
    fun httpGetStream(baseUrl: String, url: String, params: Map<String, String>): InputStream
}