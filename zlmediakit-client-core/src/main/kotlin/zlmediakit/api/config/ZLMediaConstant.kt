package zlmediakit.api.config

object ZLMediaConstant {
    /** 默认vhost */
    const val DEFAULT_VHOST: String = "__defaultVhost__"

    /** 0-hls 1-mp4 */
    const val DEFAULT_RECORD_TYPE: Int = 1

    /** 获取服务器api列表 */
    const val GET_API_LIST: String = "/index/api/getApiList"

    /** 获取网络线程负载 */
    const val GET_THREADS_LOAD: String = "/index/api/getThreadsLoad"

    /** 获取后台线程负载 */
    const val GET_WORK_THREADS_LOAD: String = "/index/api/getWorkThreadsLoad"

    /** 拉流代理 */
    const val ADD_STREAM_PROXY: String = "/index/api/addStreamProxy"

    /** 关闭拉流代理 */
    const val DEL_STREAM_PROXY: String = "/index/api/delStreamProxy"

    /** 添加FFmpeg拉流代理 */
    const val ADD_FFMPEG_SOURCE: String = "/index/api/addFFmpegSource"

    /** 关闭FFmpeg拉流代理 */
    const val DEL_FFMPEG_SOURCE: String = "/index/api/delFFmpegSource"

    /** 获取所有会话 */
    const val GET_ALL_SESSION: String = "/index/api/getAllSession"

    /** 断开tcp连接 */
    const val KICK_SESSION: String = "/index/api/kick_session"

    /** 批量断开tcp连接 */
    const val KICK_SESSIONS: String = "/index/api/kick_sessions"

    /** 关闭流 */
    const val CLOSE_STREAMS: String = "/index/api/close_streams"

    /** 获取流列表 */
    const val GET_MEDIA_LIST: String = "/index/api/getMediaList"

    /** 重启服务器 */
    const val RESTART_SERVER: String = "/index/api/restartServer"

    /**开始录制 */
    const val START_RECORD: String = "/index/api/startRecord"

    /** 停止录制 */
    const val STOP_RECORD: String = "/index/api/stopRecord"

    /** 流录制状态 */
    const val IS_RECORDING: String = "/index/api/isRecording"

    /** 获取截图 */
    const val GET_SNAP: String = "/index/api/getSnap"

    /** 获取服务器配置 */
    const val GET_SERVER_CONFIG: String = "/index/api/getServerConfig"

    /** 设置服务器配置 */
    const val SET_SERVER_CONFIG: String = "/index/api/setServerConfig"

    /** 删除录像文件 */
    const val DELETE_RECORD_DIRECTORY: String = "/index/api/deleteRecordDirectory"

    /** 获取rtp推流信息 */
    const val GET_RTP_INFO: String = "/index/api/getRtpInfo"

    /** 获取流信息 */
    const val GET_MP4_RECORD_FILE: String = "/index/api/getMp4RecordFile"

    /** 创建RTP服务器 */
    const val OPEN_RTP_SERVER: String = "/index/api/openRtpServer"

    /** 关闭RTP服务器 */
    const val CLOSE_RTP_SERVER: String = "/index/api/closeRtpServer"

    /** 获取RTP服务器列表 */
    const val LIST_RTP_SERVER: String = "/index/api/listRtpServer"

    /** 开始active模式发送rtp */
    const val START_SEND_RTP: String = "/index/api/startSendRtp"

    /** 开始passive模式发送rtp */
    const val START_SEND_RTP_PASSIVE: String = "/index/api/startSendRtpPassive"

    /** 停止 发送rtp */
    const val STOP_SEND_RTP: String = "/index/api/stopSendRtp"

    /** 获取主要对象个数 */
    const val GET_STATISTIC: String = "/index/api/getStatistic"

    /** 添加rtsp/rtmp/srt推流 */
    const val ADD_STREAM_PUSHER_PROXY: String = "/index/api/addStreamPusherProxy"

    /** 关闭推流 */
    const val DEL_STREAM_PUSHER_PROXY: String = "/index/api/delStreamPusherProxy"

    /** 获取版本信息(version) */
    const val GET_VERSION: String = "/index/api/version"

    /** 获取媒体流播放器列表 */
    const val GET_MEDIA_PLAYER_LIST: String = "/index/api/getMediaPlayerList"
}