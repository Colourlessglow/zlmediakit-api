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
}