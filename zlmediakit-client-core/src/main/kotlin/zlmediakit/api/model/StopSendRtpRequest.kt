package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 停止 发送rtp(stopSendRtp)请求参数
 */
@Serializable
data class StopSendRtpRequest(
    override var vhost: String? = null,
    override var app: String? = null,
    override var stream: String? = null,
    /**
     * 根据ssrc关停某路rtp推流，不传时关闭所有推流
     */
    var ssrc: String? = null
) : CommonStreamInfo
