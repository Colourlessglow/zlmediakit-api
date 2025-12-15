package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 开始passive模式发送rtp(startSendRtpPassive)响应参数
 */
@Serializable
data class StartSendRtpPassiveResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    /**
     * 使用的本地端口号
     */
    @SerialName("local_port")
    var localPort: Int? = null
) : IZLMediaResponse