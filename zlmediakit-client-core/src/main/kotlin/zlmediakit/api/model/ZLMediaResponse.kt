package zlmediakit.api.model

import kotlinx.serialization.Serializable

@Serializable
data class ZLMediaResponse(
    /**
     * 响应码
     * @see ZLMediaCode
     */
    override var code: Int? = null,
    /**
     * 响应信息
     */
    override var msg: String? = null
) : IZLMediaResponse