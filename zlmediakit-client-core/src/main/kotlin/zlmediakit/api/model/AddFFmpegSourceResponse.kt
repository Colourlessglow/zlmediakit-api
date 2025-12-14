package zlmediakit.api.model

import kotlinx.serialization.Serializable


/**
 * 添加FFmpeg拉流代理(addFFmpegSource)-响应
 */
@Serializable
data class AddFFmpegSourceResponse(
    var data: Data? = null,
    override var code: Int? = null,
    override var msg: String? = null
) : IZLMediaResponse {

    @Serializable
    data class Data(
        var key: String? = null
    )
}