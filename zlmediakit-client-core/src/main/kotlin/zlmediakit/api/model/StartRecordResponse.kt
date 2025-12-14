package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 开始录制(startRecord)请求响应
 */
@Serializable
data class StartRecordResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    /**
     * 是否成功
     */
    var result: Boolean = false,
) : IZLMediaResponse