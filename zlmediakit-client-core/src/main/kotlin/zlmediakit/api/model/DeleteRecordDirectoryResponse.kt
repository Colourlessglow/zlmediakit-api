package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 删除录像文件夹响应参数
 */
@Serializable
data class DeleteRecordDirectoryResponse(
    override var code: Int?,
    override var msg: String?,
    /**
     * 删除的录像文件目录
     */
    var path : String? = null
) : IZLMediaResponse
