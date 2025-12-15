package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 添加拉流代理请求参数
 */
@Serializable
data class AddStreamProxyRequest(
    /**
     * 添加的流的虚拟主机，例如__defaultVhost__
     */
    override var vhost: String? = null,
    /**
     * 添加的流的应用名，例如 live
     */
    override var app: String? = null,
    /**
     * 添加的流的 id 名，例如 test
     */
    override var stream: String? = null,
    /**
     * 拉流地址，例如 rtmp://live.hkstv.hk.lxdns.com/live/hks2
     */
    var url: String = "",
    /**
     * 拉流重试次数，默认为-1 无限重试
     */
    @SerialName("retry_count")
    var retryCount: Int? = null,
    /**
     * rtsp 拉流时，拉流方式，0：tcp，1：udp，2：组播
     */
    @SerialName("rtp_type")
    var rtpType: Int? = null,
    /**
     * 拉流超时时间，单位秒，float 类型
     */
    @SerialName("timeout_sec")
    var timeoutSec: Double? = null,
    /**
     * 是否转换成 hls-mpegts 协议
     */
    @SerialName("enable_hls")
    var enableHls: Boolean? = null,
    /**
     * 是否转换成 hls-fmp4 协议
     */
    @SerialName("enable_hls_fmp4")
    var enableHlsFmp4: Boolean? = null,
    /**
     * 是否允许 mp4 录制
     */
    @SerialName("enable_mp4")
    var enableMp4: Boolean? = null,
    /**
     * 是否转 rtsp 协议
     */
    @SerialName("enable_rtsp")
    var enableRtsp: Boolean? = null,
    /**
     * 是否转 rtmp/flv 协议
     */
    @SerialName("enable_rtmp")
    var enableRtmp: Boolean? = null,
    /**
     * 是否转 http-ts/ws-ts 协议
     */
    @SerialName("enable_ts")
    var enableTs: Boolean? = null,
    /**
     * 是否转 http-fmp4/ws-fmp4 协议
     */
    @SerialName("enable_fmp4")
    var enableFmp4: Boolean? = null,
    /**
     * 转协议是否开启音频
     */
    @SerialName("enable_audio")
    var enableAudio: Boolean? = null,
    /**
     * 转协议无音频时，是否添加静音aac音频
     */
    @SerialName("add_mute_audio")
    var addMuteAudio: Boolean? = null,
    /**
     * mp4录制保存根目录，置空使用默认目录
     */
    @SerialName("mp4_save_path")
    var mp4SavePath: String? = null,
    /**
     * mp4录制切片大小，单位秒
     */
    @SerialName("mp4_max_second")
    var mp4MaxSecond: Int? = null,

    /**
     * hls保存根目录，置空使用默认目录
     */
    @SerialName("hls_save_path")
    var hlsSavePath: String? = null,

    /**
     * 无人观看时，是否直接关闭(而不是通过on_none_reader hook返回close)
     */
    @SerialName("auto_close")
    var autoClose: Boolean? = null,
) : CommonStreamInfo