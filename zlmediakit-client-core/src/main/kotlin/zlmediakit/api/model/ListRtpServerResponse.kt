package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取RTP服务器列表(listRtpServer)响应参数
 */
@Serializable
data class ListRtpServerResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    var data: List<Data> = arrayListOf()
) : IZLMediaResponse {

    @Serializable
    data class Data(
        /**
         * 绑定的流ID
         */
        @SerialName("stream_id")
        var streamId: String = "",
        /**
         * 绑定的端口号
         */
        var port: Int = 0,
    )
}
