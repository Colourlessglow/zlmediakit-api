package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 添加FFmpeg拉流代理(addFFmpegSource)请求参数
 */
@Serializable
data class AddFFmpegSourceRequest(
    /**
     * FFmpeg 拉流地址,支持任意协议或格式(只要 FFmpeg 支持即可)
     */
    @SerialName("src_url")
    val srcUrl: String,
    /**
     * FFmpeg rtmp 推流地址，一般都是推给自己，例如 rtmp://127.0.0.1/live/stream_form_ffmpeg
     */
    @SerialName("dst_url")
    val dstUrl: String,
    /**
     * FFmpeg推流成功超时时间,单位毫秒
     */
    @SerialName("timeout_ms")
    val timeoutMs: Double,
    /**
     * 是否转换成 hls-mpegts 协议
     */
    @SerialName("enable_hls")
    val enableHls: Boolean,
    /**
     * 是否允许 mp4 录制
     */
    @SerialName("enable_mp4")
    val enableMp4: Boolean,
    /**
     * FFmpeg 命令行参数
     */
    @SerialName("ffmpeg_cmd_key")
    val ffmpegCmdKey: String? = null,
)