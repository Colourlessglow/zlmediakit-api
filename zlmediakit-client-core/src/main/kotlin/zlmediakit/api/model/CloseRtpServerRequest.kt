package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 关闭RTP服务器(closeRtpServer)请求参数
 */
@Serializable
data class CloseRtpServerRequest(
    /**
     * 应用名，例如 rtp
     */
    var app: String = "",

    /**
     * 该端口绑定的流id
     */
    @SerialName("stream_id")
    var streamID: String = "",

    /**
     * 虚拟主机，例如__defaultVhost__
     */
    var vhost: String? = null,
)