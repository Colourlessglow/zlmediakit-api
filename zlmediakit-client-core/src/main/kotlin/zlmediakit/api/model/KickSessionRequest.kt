package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 断开tcp连接(kick_session)请求参数
 */
@Serializable
data class KickSessionRequest(
    /**
     * 客户端唯一 id，可以通过 getAllSession 接口获取
     */
    var id: String = "",
)
