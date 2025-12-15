package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import zlmediakit.api.config.ZLMediaConstant

/**
 * 开始录制(startRecord)请求参数
 */
@Serializable
data class StartRecordRequest(
    override var vhost: String? = null,
    override var app: String? = null,
    override var stream: String? = null,
    /**
     * 0 为 hls，1 为 mp4
     */
    var type: Int = ZLMediaConstant.DEFAULT_RECORD_TYPE,
     /**
      * 录像文件保存自定义根目录，为空则采用配置文件设置
      */
    @SerialName("customized_path")
    var customizedPath: String? = null,
     /**
      * MP4录制的切片时间大小，单位秒
      */
    @SerialName("max_second")
    var maxSecond: Int? = null,
): CommonStreamInfo