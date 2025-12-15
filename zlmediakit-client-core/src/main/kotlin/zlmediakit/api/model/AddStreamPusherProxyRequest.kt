package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * 添加rtsp/rtmp/srt推流(addStreamPusherProxy)请求参数
 */
@Serializable
data class AddStreamPusherProxyRequest(
    override var vhost: String? = null,
    override var app: String? = null,
    override var stream: String? = null,
    /**
     * 推流地址，需要与schema字段协议一致
     */
    @SerialName("dst_url")
    var dstURL: String = "",

    /**
     * srt延时, 单位毫秒
     */
    var latency: Double? = null,

    /**
     * srt推流的密码
     */
    var passphrase: String? = null,

    /**
     * 推流重试次数,不传此参数或传值<=0时，则无限重试
     */
    @SerialName("retry_count")
    var retryCount: Int? = null,

    /**
     * rtsp推流时，推流方式，0：tcp，1：udp
     */
    @SerialName("rtp_type")
    var rtpType: Int? = null,

    /**
     * 推流协议，支持rtsp、rtmp，大小写敏感
     */
    var schema: String = "",

    /**
     * 推流超时时间，单位秒，float类型
     */
    @SerialName("timeout_sec")
    var timeoutSEC: Double? = null,
): CommonStreamInfo
