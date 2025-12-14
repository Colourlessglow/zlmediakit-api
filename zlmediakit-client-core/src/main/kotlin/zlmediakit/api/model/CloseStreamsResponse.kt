package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 关闭流响应参数
 */
@Serializable
data class CloseStreamsResponse(
    /**
     * 筛选命中的流个数
     */
    @SerialName( "count_hit")
    var countHit: Int? = null,
    /**
     * 被关闭的流个数，可能小于count_hit
     */
    @SerialName( "count_closed")
    var countClosed: Int? = null,
    /**
     * 响应码
     * @see ZLMediaCode
     */
    override var code: Int? = null,
    /**
     * 响应信息
     */
    override var msg: String? = null,
) : IZLMediaResponse
