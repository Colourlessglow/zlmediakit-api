package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 获取服务器api列表
 */
@Serializable
data class GetApiListResponse(
    /**
     * api列表
     */
    var data: List<String> = arrayListOf(),
    override var code: Int? = null,
    override var msg: String? = null
) : IZLMediaResponse
