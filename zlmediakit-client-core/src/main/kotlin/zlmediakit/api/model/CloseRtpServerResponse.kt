package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 关闭RTP服务器(closeRtpServer)响应参数
 */
@Serializable
data class CloseRtpServerResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    /**
     * 是否找到记录并关闭
     */
    var hit: Int = 0,
): IZLMediaResponse