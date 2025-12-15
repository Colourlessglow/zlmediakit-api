package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取Session列表(getAllSession)请求参数
 */
@Serializable
data class GetAllSessionRequest(
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
