package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 获取服务器配置(getServerConfig)响应参数
 */
@Serializable
data class GetServerConfigResponse(
    override var code: Int?,
    override var msg: String?,
    /**
     * 服务器配置
     */
    var data: List<Map<String, String>> = arrayListOf(),
): IZLMediaResponse
