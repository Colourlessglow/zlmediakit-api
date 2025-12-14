package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 关闭流(close_streams)请求
 */
@Serializable
data class CloseStreamsRequest(
    /**
     * 应用名，例如 live
     */
    val app: String = "",
    /**
     * 是否强制关闭(有人在观看是否还关闭)
     */
    val force: Boolean? = null,

    /**
     * 协议，例如 rtsp或rtmp
     */
    val schema: String? = null,

    /**
     * 流id，例如 test
     */
    val stream: String = "",

    /**
     * 虚拟主机，例如__defaultVhost__
     */
    var vhost: String? = null
)
