package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 创建RTP服务器(openRtpServer)请求参数
 */
@Serializable
data class OpenRtpServerRequest(
    /**
     * 接收端口，0 则为随机端口
     */
    var port: Int = 0,
    /**
     * 0 udp 模式，1 tcp 被动模式, 2 tcp 主动模式。 (兼容 enable_tcp 为 0/1)
     */
    @SerialName("tcp_mode")
    var tcpMode: Int = 0,
    /**
     * 该端口绑定的流 ID，该端口只能创建这一个流(而不是根据 ssrc 创建多个)
     */
    @SerialName("stream_id")
    var streamId: String = "",

    /**
     * 是否复用端口
     */
    @SerialName("re_use_port")
    var reUsePort: Boolean? = null,

    /**
     * 是否指定收流的rtp ssrc, 十进制数字，不指定或指定0时则不过滤rtp，非必选参数
     */
    @SerialName("ssrc")
    var ssrc: Int? = null,

    /**
     * 是否为单音频/单视频track，0：不设置，1：单音频，2：单视频
     */
    @SerialName("only_track")
    var onlyTrack: Int? = null,

    /**
     * 指定创建RTP的本地ip，ipv4可填”0.0.0.0“，ipv6可填”::“，一般保持默认
     */
    @SerialName("local_ip")
    var localIp: String? = null,
)