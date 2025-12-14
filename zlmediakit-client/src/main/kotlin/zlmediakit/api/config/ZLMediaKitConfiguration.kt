package zlmediakit.api.config

import okhttp3.OkHttpClient
import java.util.function.Consumer

data class ZLMediaKitConfiguration(
    override val secret: String,
    override val baseUrl: String,
    val okhttpClient: Consumer<OkHttpClient.Builder>? = null
): HttpConfig