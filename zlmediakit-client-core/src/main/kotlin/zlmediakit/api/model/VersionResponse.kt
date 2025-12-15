package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取版本信息(version)响应参数
 */
@Serializable
data class VersionResponse(
    override var code: Int? = null,
    override var msg: String? = null,
    var data: Data? = null
) : IZLMediaResponse{

    @Serializable
    data class Data(
        /**
         * 版本号
         */
        @SerialName("branchName")
        var branchName: String,
        /**
         * 编译时间
         */
        @SerialName("buildTime")
        var buildTime: String,
        /**
         * 提交哈希
         */
        @SerialName("commitHash")
        var commitHash: String,
    )
}
