package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取rtp推流信息(getRtpInfo)请求参数
 */
@Serializable
data class GetRtpInfoResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    /**
     * 是否存在
     */
    var exist: Boolean = false,
    /**
     * 推流客户端ip
     */
    @SerialName("peer_ip")
    var peerIP: String? = null,
    /**
     * 客户端端口号
     */
    @SerialName("peer_port")
    var peerPort: Int? = null,
    /**
     * 本地监听的网卡ip
     */
    @SerialName("local_ip")
    var localIP: String? = null,
    /**
     * 本地监听的网卡端口号
     */
    @SerialName("local_port")
    var localPort: Int? = null,
) : IZLMediaResponse
