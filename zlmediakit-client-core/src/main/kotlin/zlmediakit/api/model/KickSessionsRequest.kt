package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 批量断开tcp连接(kick_sessions)请求参数
 */
@Serializable
data class KickSessionsRequest(
    /**
     * 筛选本机端口，例如筛选rtsp链接：554
     */
    @SerialName("local_port")
    var localPort: Int? = null,

    /**
     * 筛选客户端ip
     */
    @SerialName("peer_ip")
    var peerIP: String? = null,
)
