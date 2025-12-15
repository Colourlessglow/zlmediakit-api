package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 关闭拉流代理(delStreamProxy)请求参数
 */
@Serializable
data class DelStreamProxyRequest(
    /**
     * addStreamProxy 接口返回的 key
     */
    var key: String = "",
)
