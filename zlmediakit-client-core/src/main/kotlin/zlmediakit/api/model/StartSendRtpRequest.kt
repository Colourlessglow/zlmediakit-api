package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 开始active模式发送rtp(startSendRtp)请求参数
 */
@Serializable
data class StartSendRtpRequest(
    override var vhost: String? = null,
    override var app: String? = null,
    override var stream: String? = null,
    /**
     * 目标端口
     */
    @SerialName("dst_port")
    var dstPort: Int = 0,

    /**
     * 目标ip或域名
     */
    @SerialName("dst_url")
    var dstURL: String = "",


    /**
     * 转发rtp(tcp模式)时，如果发送不出去，是否限制源端收流速度，此参数在多倍速rtp转发时作用较大
     */
    @SerialName("enable_origin_recv_limit")
    var enableOriginRecvLimit: String? = null,

    /**
     * 是否推送本地MP4录像，该参数非必选参数
     */
    @SerialName("from_mp4")
    var fromMp4: Int? = null,

    /**
     * 1:udp active模式, 0:tcp active模式
     */
    @SerialName("is_udp")
    var isUDP: Boolean = false,

    /**
     * rtp es方式打包时，是否只打包音频，该参数非必选参数
     */
    @SerialName("only_audio")
    var onlyAudio: Boolean? = null,

    /**
     * rtp payload type，默认96，该参数非必选参数
     */
    var pt: Int? = null,

    /**
     * 发送rtp同时接收，一般用于双向语言对讲, 如果不为空，说明开启接收，值为接收流的id
     */
    @SerialName("recv_stream_id")
    var recvStreamID: String? = null,

    /**
     * 指定tcp/udp客户端使用的本地端口，0时为随机端口，该参数非必选参数，不传时为随机端口。
     */
    @SerialName("src_port")
    var srcPort: Int? = null,

    /**
     * rtp推流的ssrc
     */
    var ssrc: String = "",

    /**
     * 是否支持同ssrc推流到多个上级服务器,该参数非必选参数 默认false
     */
    @SerialName("ssrc_multi_send")
    var ssrcMultiSend: Boolean? = null,

    /**
     * rtp打包模式，0:es, 1: ps, 2: ts
     */
    var type: Int? = null,

    /**
     * udp方式推流时，是否开启rtcp发送和rtcp接收超时判断，开启后(默认关闭)，如果接收rr rtcp超时，将导致主动停止rtp发送
     */
    @SerialName("udp_rtcp_timeout")
    var udpRtcpTimeout: String? = null,
) : CommonStreamInfo