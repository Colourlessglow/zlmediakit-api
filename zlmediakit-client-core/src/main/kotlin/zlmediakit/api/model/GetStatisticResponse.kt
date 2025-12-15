package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取主要对象个数(getStatistic)响应参数
 */
@Serializable
data class GetStatisticResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    var data: Data = Data()
) : IZLMediaResponse {

    @Serializable
    data class Data(
        @SerialName("Buffer")
        var buffer: Int = 0,
        @SerialName("BufferLikeString")
        var bufferLikeString: Int = 0,
        @SerialName("BufferList")
        var bufferList: Int = 0,
        @SerialName("BufferRaw")
        var bufferRaw: Int = 0,
        @SerialName("Frame")
        var frame: Int = 0,
        @SerialName("FrameImp")
        var frameImp: Int = 0,
        @SerialName("MediaSource")
        var mediaSource: Int = 0,
        @SerialName("MultiMediaSourceMuxer")
        var multiMediaSourceMuxer: Int = 0,
        @SerialName("RtmpPacket")
        var rtmpPacket: Int = 0,
        @SerialName("RtpPacket")
        var rtpPacket: Int = 0,
        @SerialName("Socket")
        var socket: Int = 0,
        @SerialName("TcpClient")
        var tcpClient: Int = 0,
        @SerialName("TcpServer")
        var tcpServer: Int = 0,
        @SerialName("TcpSession")
        var tcpSession: Int = 0,
        @SerialName("UdpServer")
        var udpServer: Int = 0,
        @SerialName("UdpSession")
        var udpSession: Int = 0
    )
}
