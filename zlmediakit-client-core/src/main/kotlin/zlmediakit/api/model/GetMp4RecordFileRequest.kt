package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取mp4录像文件(getMp4RecordFile)请求参数
 */
@Serializable
data class GetMp4RecordFileRequest(
    override var vhost: String? = null,
    override var app: String? = null,
    override var stream: String? = null,
    /**
     * 录像文件路径
     */
    @SerialName("customized_path")
    var customizedPath: String? = null,
    /**
     * 流的录像日期，格式为 2020-02-01,如果不是完整的日期，那么是搜索录像文件夹列表，否则搜索对应日期下的 mp4 文件列表
     */
    var period: String = "",
): CommonStreamInfo
