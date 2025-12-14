package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 批量断开tcp连接(kick_sessions)响应参数
 */
@Serializable
data class KickSessionsResponse(
    override var code: Int?,
    override var msg: String?,
    /**
     * 筛选命中的会话个数
     */
    @SerialName("count_hit")
    var countHit: Int = 0,
): IZLMediaResponse
