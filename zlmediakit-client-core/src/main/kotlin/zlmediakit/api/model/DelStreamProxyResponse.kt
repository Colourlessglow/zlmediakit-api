package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 关闭拉流代理(delStreamProxy)响应参数
 */
@Serializable
data class DelStreamProxyResponse(
    override var code: Int?,
    override var msg: String?,
    var data: Data = Data()
) : IZLMediaResponse {

    @Serializable
    data class Data(
        /**
         * 成功与否
         */
        var flag: Boolean = false
    )
}
