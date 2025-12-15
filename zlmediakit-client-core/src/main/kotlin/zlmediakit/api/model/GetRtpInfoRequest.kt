package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取rtp推流信息(getRtpInfo)请求参数
 */
@Serializable
data class GetRtpInfoRequest(
    /**
     * 应用名，例如 rtp
     */
    var app: String = "",

    /**
     * 流id
     */
    @SerialName("stream_id")
    var streamID: String = "",

    /**
     * 虚拟主机，例如__defaultVhost__
     */
    var vhost: String? = null
)
