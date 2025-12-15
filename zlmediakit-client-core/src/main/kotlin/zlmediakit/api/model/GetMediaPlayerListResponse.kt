package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取媒体流播放器列表(getMediaPlayerList)响应参数
 */
@Serializable
data class GetMediaPlayerListResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    var data: List<Data> = arrayListOf(),
) : IZLMediaResponse{
    /**
     * 媒体流播放器信息
     */
    @Serializable
    data class Data(
        var identifier: String? = null,
        @SerialName("local_ip")
        var localIp: String? = null,
        @SerialName("local_port")
        var localPort: Int? = null,
        @SerialName("peer_ip")
        var peerIp: String? = null,
        @SerialName("peer_port")
        var peerPort: Int? = null,
        @SerialName("typeid")
        var typeId: String? = null,
    )
}
