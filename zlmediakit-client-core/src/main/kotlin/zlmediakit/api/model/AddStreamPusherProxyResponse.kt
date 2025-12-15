package zlmediakit.api.model

import kotlinx.serialization.Serializable


/**
 * 添加rtsp/rtmp/srt推流(addStreamPusherProxy)响应参数
 */
@Serializable
data class AddStreamPusherProxyResponse(
var data: Data? = null,
override var code: Int? = null,
override var msg: String? = null
) : IZLMediaResponse {

    @Serializable
    data class Data(
        var key: String? = null
    )
}
