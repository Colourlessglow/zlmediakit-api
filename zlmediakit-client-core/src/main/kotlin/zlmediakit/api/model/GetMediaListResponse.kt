package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取媒体列表(getMediaList)请求响应
 */
@Serializable
data class GetMediaListResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    var data: MutableList<Data> = arrayListOf()
) : IZLMediaResponse {
    @Serializable
    data class Data(
        /** 应用名 */
        var app: String? = null,
        /** 本协议观看人数 */
        var readerCount: Int? = null,
        /** 观看总人数（包含所有协议） */
        var totalReaderCount: Int? = null,
        /** 协议类型 */
        var schema: String? = null,
        /** 流ID */
        var stream: String? = null,
        /** 客户端和服务器网络信息（可为null） */
        var originSock: OriginSock? = null,
        /** 产生源类型（枚举值） */
        var originType: Int? = null,
        /** 产生源类型描述 */
        var originTypeStr: String? = null,
        /** 产生源URL */
        var originUrl: String? = null,
        /** 创建时间戳（GMT unix秒级） */
        var createStamp: Long? = null,
        /** 当前时间戳（GMT unix秒级） */
        var currentStamp: Long? = null,
        /** 存活时间（秒） */
        var aliveSecond: Int? = null,
        /** 数据产生速度（byte/s） */
        var bytesSpeed: Long? = null,
        /** 音视频轨道列表 */
        var tracks: List<Track>? = null,
        /** 虚拟主机名 */
        var vhost: String? = null
    )

    @Serializable
    data class OriginSock(
        var identifier: String? = null,
        @SerialName("local_ip")
        var localIp: String? = null,
        @SerialName("local_port")
        var localPort: Int? = null,
        @SerialName("peer_ip")
        var peerIp: String? = null,
        @SerialName("peer_port")
        var peerPort: Int? = null
    )

    /** 音视频轨道 */
    @Serializable
    data class Track(
        /** 音频通道数（仅音频轨道有值） */
        var channels: Int? = null,
        /** 编码ID（枚举值） */
        @SerialName("codec_id")
        var codecId: Int? = null,
        /** 编码类型名称 */
        @SerialName("codec_id_name")
        var codecIdName: String? = null,
        /** 轨道类型：0-视频 1-音频 */
        @SerialName("codec_type")
        var codecType: Int? = null,
        /** 轨道是否就绪 */
        var ready: Boolean? = null,
        /** 累计接收帧数 */
        var frames: Int? = null,
        /** 音频采样位数（仅音频轨道有值） */
        @SerialName("sample_bit")
        var sampleBit: Int? = null,
        /** 音频采样率（仅音频轨道有值） */
        @SerialName("sample_rate")
        var sampleRate: Int? = null,
        /** 视频FPS（仅视频轨道有值） */
        var fps: Double? = null,
        /** GOP间隔时间（毫秒，仅视频轨道有值） */
        @SerialName("gop_interval_ms")
        var gopIntervalMs: Int? = null,
        /** GOP大小（帧数，仅视频轨道有值） */
        @SerialName("gop_size")
        var gopSize: Int? = null,
        /** 累计关键帧数（仅视频轨道有值） */
        @SerialName("key_frames")
        var keyFrames: Int? = null,
        /** 视频宽度（仅视频轨道有值） */
        var width: Int? = null,
        /** 视频高度（仅视频轨道有值） */
        var height: Int? = null
    )
}