package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 创建RTP服务器(openRtpServer)响应参数
 */
@Serializable
data class OpenRtpServerResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    /**
     * 接收端口，方便获取随机端口号
     */
    var port: Int = 0,
): IZLMediaResponse