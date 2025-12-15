package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 关闭FFmpeg拉流代理(delFFmpegSource)请求参数
 */
@Serializable
data class DelFFmpegSourceRequest(
    /**
     * addFFmpegSource 接口返回的 key
     */
    var key: String,
)
