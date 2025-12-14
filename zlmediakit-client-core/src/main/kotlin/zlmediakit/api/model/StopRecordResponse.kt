package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 停止录制(stopRecord)请求响应
 */
@Serializable
data class StopRecordResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    /**
     * 是否成功
     */
    var result: Boolean = false,
) : IZLMediaResponse