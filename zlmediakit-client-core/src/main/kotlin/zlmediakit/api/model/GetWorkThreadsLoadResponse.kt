package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 获取后台线程负载(getWorkThreadsLoad)响应
 */
@Serializable
data class GetWorkThreadsLoadResponse(
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