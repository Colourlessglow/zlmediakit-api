package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 获取媒体流播放器列表(getMediaPlayerList)请求参数
 */
@Serializable
data class GetMediaPlayerListRequest(
    /**
     * 协议，例如 rtsp或rtmp
     */
    var schema: String = "",
    override var vhost: String? = null,
    override var app: String? = null,
    override var stream: String? = null,
): CommonStreamInfo
