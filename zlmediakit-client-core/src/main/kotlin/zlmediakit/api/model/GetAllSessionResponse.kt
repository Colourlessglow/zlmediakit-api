package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取Session列表(getAllSession)请求参数
 */
@Serializable
data class GetAllSessionResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    var data: List<Data> = arrayListOf()
) : IZLMediaResponse {

    @Serializable
    data class Data(
        // TCP连接唯一ID
        var id: String,
        // 本机网卡IP
        @SerialName("local_ip")
        var localIp: String,
        // 本机端口号
        @SerialName("local_port")
        var localPort: Int,
        // 客户端IP
        @SerialName("peer_ip")
        var peerIp: String,
        // 客户端端口号
        @SerialName("peer_port")
        var peerPort: Int,
        // 客户端TCPSession类型标识
        @SerialName("typeid")
        var typeId: String
    )
}
