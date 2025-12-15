package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 获取网络线程负载(getThreadsLoad)响应
 */
@Serializable
data class GetThreadsLoadResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    var data: List<Data> = arrayListOf(),
) : IZLMediaResponse {
    @Serializable
    data class Data(
        /**
         * 该线程延时
         */
        var delay: Int,
        /**
         * 该线程负载，0 ~ 100
         */
        var load: Int
    )
}