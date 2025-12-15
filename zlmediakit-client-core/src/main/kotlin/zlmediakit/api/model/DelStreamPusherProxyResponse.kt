package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 关闭推流(delStreamPusherProxy)响应参数
 */
@Serializable
data class DelStreamPusherProxyResponse(
    override var code: Int? = null,
    override var msg: String? = null,
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
