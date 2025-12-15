package zlmediakit.api.model

import kotlinx.serialization.Serializable
import zlmediakit.api.config.ZLMediaConstant

/**
 * 停止录制(stopRecord)请求参数
 */
@Serializable
data class StopRecordRequest(
    override var vhost: String? = null,
    override var app: String? = null,
    override var stream: String? = null,
    /**
     * 0 为 hls，1 为 mp4
     */
    var type: Int = ZLMediaConstant.DEFAULT_RECORD_TYPE,
): CommonStreamInfo