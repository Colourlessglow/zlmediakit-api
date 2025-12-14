package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 是否正在录制(isRecording)请求响应
 */
@Serializable
data class IsRecordingResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    /**
     * false:未录制,true:正在录制
     */
    var status: Boolean = false,
) : IZLMediaResponse