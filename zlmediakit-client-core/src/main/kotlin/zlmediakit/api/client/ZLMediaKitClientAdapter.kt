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
    fun setServerConfig(request: Map<String, Any?>): SetServerConfigResponse =
        http.httpGetJson<Map<String, Any?>, SetServerConfigResponse>(
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
}