package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 获取mp4录像文件(getMp4RecordFile)响应参数
 */
@Serializable
data class GetMp4RecordFileResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    var data: Data = Data()
) : IZLMediaResponse {

    @Serializable
    data class Data(
        var paths: List<String> = arrayListOf(),
        var rootPath: String = ""
    )
}
