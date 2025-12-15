package zlmediakit.api.client

import zlmediakit.api.config.HttpConfig
import zlmediakit.api.config.ZLMediaConstant
import zlmediakit.api.exception.ZLMediaKitHttpException
import zlmediakit.api.exception.ZLMediaKitResponseException
import zlmediakit.api.http.ZLMediaKitHttp
import zlmediakit.api.http.ZLMediaKitHttpAdapter
import zlmediakit.api.model.*
import java.io.InputStream

/**
 * zlmediakit 媒体服务客户端适配器
 */
open class ZLMediaKitClientAdapter(
    val adapter: ZLMediaKitHttpAdapter,
    val configuration: HttpConfig
) {
    internal val http = ZLMediaKitHttp(
        adapter = adapter,
        config = configuration
    )

    /**
     * 获取服务器api列表
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun getApiList(): GetApiListResponse =
        http.httpGetJson<Any, GetApiListResponse>(
            url = ZLMediaConstant.GET_API_LIST
        )

    /**
     * 获取网络线程负载(getThreadsLoad)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun getThreadsLoad(): GetThreadsLoadResponse =
        http.httpGetJson<Any, GetThreadsLoadResponse>(
            url = ZLMediaConstant.GET_THREADS_LOAD
        )

    /**
     * 获取后台线程负载(getWorkThreadsLoad)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun getWorkThreadsLoad(): GetWorkThreadsLoadResponse =
        http.httpGetJson<Any, GetWorkThreadsLoadResponse>(
            url = ZLMediaConstant.GET_WORK_THREADS_LOAD
        )

    /**
     * 获取服务器配置(getServerConfig)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun getServerConfig(): GetServerConfigResponse =
        http.httpGetJson<Any, GetServerConfigResponse>(
            url = ZLMediaConstant.GET_SERVER_CONFIG
        )

    /**
     * 设置服务器配置(setServerConfig)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun setServerConfig(request: Map<String, String>): SetServerConfigResponse =
        http.httpMapGetJson<SetServerConfigResponse>(
            url = ZLMediaConstant.SET_SERVER_CONFIG,
            request = request
        )

    /**
     * 重启服务器(restartServer)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun restartServer(): ZLMediaResponse =
        http.httpGetJson<Any, ZLMediaResponse>(
            url = ZLMediaConstant.RESTART_SERVER
        )

    /**
     * 获取Session列表(getAllSession)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun getAllSession(request: GetAllSessionRequest): GetAllSessionResponse =
        http.httpGetJson<GetAllSessionRequest, GetAllSessionResponse>(
            url = ZLMediaConstant.GET_ALL_SESSION,
            request = request
        )

    /**
     * 断开tcp连接(kick_session)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun kickSession(request: KickSessionRequest): KickSessionsResponse =
        http.httpGetJson<KickSessionRequest, KickSessionsResponse>(
            url = ZLMediaConstant.KICK_SESSION,
            request = request
        )

    /**
     * 批量断开tcp连接(kick_sessions)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun kickSessions(request: KickSessionsRequest): KickSessionsResponse =
        http.httpGetJson<KickSessionsRequest, KickSessionsResponse>(
            url = ZLMediaConstant.KICK_SESSIONS,
            request = request
        )

    /**
     * 获取流列表(getMediaList)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun getMediaList(request: GetMediaListRequest): GetMediaListResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<GetMediaListRequest, GetMediaListResponse>(
            url = ZLMediaConstant.GET_MEDIA_LIST,
            request = request
        )
    }

    /**
     * 关闭流(close_streams)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun closeStreams(request: CloseStreamsRequest): CloseStreamsResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<CloseStreamsRequest, CloseStreamsResponse>(
            url = ZLMediaConstant.CLOSE_STREAMS,
            request = request
        )
    }

    /**
     * 添加拉流代理(addStreamProxy)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun addStreamProxy(request: AddStreamProxyRequest): AddStreamProxyResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<AddStreamProxyRequest, AddStreamProxyResponse>(
            url = ZLMediaConstant.ADD_STREAM_PROXY,
            request = request
        )
    }

    /**
     * 关闭拉流代理(delStreamProxy)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun delStreamProxy(request: DelStreamProxyRequest): DelStreamProxyResponse =
        http.httpGetJson<DelStreamProxyRequest, DelStreamProxyResponse>(
            url = ZLMediaConstant.DEL_STREAM_PROXY,
            request = request
        )

    /**
     * 添加FFmpeg拉流代理(addFFmpegSource)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun addFFmpegSource(request: AddFFmpegSourceRequest): AddFFmpegSourceResponse =
        http.httpGetJson<AddFFmpegSourceRequest, AddFFmpegSourceResponse>(
            url = ZLMediaConstant.ADD_FFMPEG_SOURCE,
            request = request
        )

    /**
     * 关闭FFmpeg拉流代理(delFFmpegSource)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun delFFmpegSource(request: DelFFmpegSourceRequest): DelFFmpegSourceResponse =
        http.httpGetJson<DelFFmpegSourceRequest, DelFFmpegSourceResponse>(
            url = ZLMediaConstant.DEL_FFMPEG_SOURCE,
            request = request
        )

    /**
     * 是否正在录制(isRecording)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun isRecording(request: IsRecordingRequest): IsRecordingResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<IsRecordingRequest, IsRecordingResponse>(
            url = ZLMediaConstant.IS_RECORDING,
            request = request
        )
    }

    /**
     * 开始录制(startRecord)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun startRecord(request: StartRecordRequest): StartRecordResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<StartRecordRequest, StartRecordResponse>(
            url = ZLMediaConstant.START_RECORD,
            request = request
        )
    }

    /**
     * 停止录制(stopRecord)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun stopRecord(request: StopRecordRequest): StopRecordResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<StopRecordRequest, StopRecordResponse>(
            url = ZLMediaConstant.STOP_RECORD,
            request = request
        )
    }

    /**
     * 获取截图(getSnap)
     */
    @Throws(
        ZLMediaKitHttpException::class,
    )
    fun getSnap(request: GetSnapRequest): InputStream =
        http.httpGetStream<GetSnapRequest>(
            url = ZLMediaConstant.GET_SNAP,
            request = request
        )

    /**
     * 删除录像文件夹(deleteRecordDirectory)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun deleteRecordDirectory(request: DeleteRecordDirectoryRequest): DeleteRecordDirectoryResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<DeleteRecordDirectoryRequest, DeleteRecordDirectoryResponse>(
            url = ZLMediaConstant.DELETE_RECORD_DIRECTORY,
            request = request
        )
    }

    /**
     * 获取rtp推流信息(getRtpInfo)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun getRtpInfo(request: GetRtpInfoRequest): GetRtpInfoResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<GetRtpInfoRequest, GetRtpInfoResponse>(
            url = ZLMediaConstant.GET_RTP_INFO,
            request = request
        )
    }

    /**
     * 获取mp4录像文件(getMp4RecordFile)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun getMp4RecordFile(request: GetMp4RecordFileRequest): GetMp4RecordFileResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<GetMp4RecordFileRequest, GetMp4RecordFileResponse>(
            url = ZLMediaConstant.GET_MP4_RECORD_FILE,
            request = request
        )
    }

    /**
     * 创建RTP服务器(openRtpServer)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun openRtpServer(request: OpenRtpServerRequest): OpenRtpServerResponse =
        http.httpGetJson<OpenRtpServerRequest, OpenRtpServerResponse>(
            url = ZLMediaConstant.OPEN_RTP_SERVER,
            request = request
        )

    /**
     * 关闭RTP服务器(closeRtpServer)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun closeRtpServer(request: CloseRtpServerRequest): CloseRtpServerResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<CloseRtpServerRequest, CloseRtpServerResponse>(
            url = ZLMediaConstant.CLOSE_RTP_SERVER,
            request = request
        )
    }

    /**
     * 获取RTP服务器列表(listRtpServer)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun listRtpServer(): ListRtpServerResponse =
        http.httpGetJson<Any, ListRtpServerResponse>(
        url = ZLMediaConstant.LIST_RTP_SERVER,
    )

     /**
     * 开始active模式发送rtp(startSendRtp)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun startSendRtp(request: StartSendRtpRequest): StartSendRtpResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<StartSendRtpRequest, StartSendRtpResponse>(
            url = ZLMediaConstant.START_SEND_RTP,
            request = request
        )
    }

    /**
     * 开始passive模式发送rtp(startSendRtpPassive)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun startSendRtpPassive(request: StartSendRtpPassiveRequest): StartSendRtpPassiveResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<StartSendRtpPassiveRequest, StartSendRtpPassiveResponse>(
            url = ZLMediaConstant.START_SEND_RTP_PASSIVE,
            request = request
        )
    }

    /**
     * 停止发送rtp(stopSendRtp)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun stopSendRtp(request: StopSendRtpRequest): ZLMediaResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<StopSendRtpRequest, ZLMediaResponse>(
            url = ZLMediaConstant.STOP_SEND_RTP,
            request = request
        )
    }

     /**
     * 获取主要对象个数(getStatistic)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun getStatistic(): GetStatisticResponse =
        http.httpGetJson<Any, GetStatisticResponse>(
        url = ZLMediaConstant.GET_STATISTIC,
    )

     /**
     * 添加rtsp/rtmp/srt推流(addStreamPusherProxy)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun addStreamPusherProxy(request: AddStreamPusherProxyRequest): AddStreamPusherProxyResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<AddStreamPusherProxyRequest, AddStreamPusherProxyResponse>(
            url = ZLMediaConstant.ADD_STREAM_PUSHER_PROXY,
            request = request
        )
    }

    /**
     * 关闭推流(delStreamPusherProxy)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun delStreamPusherProxy(request: DelStreamPusherProxyRequest): DelStreamPusherProxyResponse =
        http.httpGetJson<DelStreamPusherProxyRequest, DelStreamPusherProxyResponse>(
        url = ZLMediaConstant.DEL_STREAM_PUSHER_PROXY,
        request = request
    )

    /**
     * 获取版本信息(version)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun version(): VersionResponse =
        http.httpGetJson<Any, VersionResponse>(
        url = ZLMediaConstant.GET_VERSION,
    )

    /**
     * 获取媒体流播放器列表(getMediaPlayerList)
     */
    @Throws(
        ZLMediaKitHttpException::class,
        ZLMediaKitResponseException::class
    )
    fun getMediaPlayerList(request: GetMediaPlayerListRequest): GetMediaPlayerListResponse {
        if (request.vhost.isNullOrEmpty()) {
            request.vhost = ZLMediaConstant.DEFAULT_VHOST
        }
        return http.httpGetJson<GetMediaPlayerListRequest, GetMediaPlayerListResponse>(
            url = ZLMediaConstant.GET_MEDIA_PLAYER_LIST,
            request = request
        )
    }
}