package zlmediakit.api.model

import kotlinx.serialization.Serializable

/**
 * 设置服务器配置(setServerConfig)响应参数
 */
@Serializable
data class SetServerConfigResponse(
    override var code: Int?,
    override var msg: String?,
    /**
     * 配置项变更个数
     */
    var changed: Int = 0,
) : IZLMediaResponse
