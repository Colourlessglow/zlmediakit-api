package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 获取流列表(getMediaList)请求参数
 */
@Serializable
data class GetMediaListRequest(
    override var vhost: String? = null,
    override val app: String? = null,
    override val stream: String? = null,
    /**
     * 协议，例如 rtsp或rtmp
     */
    val schema: String? = null
) : CommonStreamInfo