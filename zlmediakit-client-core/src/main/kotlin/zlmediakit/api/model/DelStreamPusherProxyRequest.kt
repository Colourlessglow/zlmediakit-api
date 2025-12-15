package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 关闭推流(delStreamPusherProxy)请求参数
 */
@Serializable
data class DelStreamPusherProxyRequest(
    /**
     * addStreamPusherProxy 接口返回的 key
     */
    var key: String = "",
)
