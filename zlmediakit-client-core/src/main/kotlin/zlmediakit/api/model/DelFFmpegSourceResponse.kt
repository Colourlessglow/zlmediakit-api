package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 关闭FFmpeg拉流代理(delFFmpegSource)响应参数
 */
@Serializable
data class DelFFmpegSourceResponse(
    override var code: Int?,
    override var msg: String?,
    var data: Data = Data()
) : IZLMediaResponse {

    @Serializable
    data class Data(
        /**
         * 成功与否
         */
        var flag: Boolean = false
    )
}
