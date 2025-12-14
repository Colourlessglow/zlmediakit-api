package zlmediakit.api.model

import kotlinx.serialization.Serializable


/**
 * 添加拉流代理-响应
 */
@Serializable
data class AddStreamProxyResponse(
    var data: Data? = null,
    override var code: Int? = null,
    override var msg: String? = null
) : IZLMediaResponse {
    @Serializable
    data class Data(var key: String? = null)
}