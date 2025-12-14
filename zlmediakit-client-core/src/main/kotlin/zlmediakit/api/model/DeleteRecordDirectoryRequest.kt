package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 删除录像文件夹请求参数
 */
@Serializable
data class DeleteRecordDirectoryRequest(
    override var vhost: String? = null,
    override val app: String? = null,
    override val stream: String? = null,
    /**
     * 录像文件保存自定义根目录，为空则采用配置文件设置
     */
    @SerialName("customized_path")
    val customizedPath: String? = null,
    /**
     * 录像文件
     *  > [从源码中翻出来的参数，不保证 zlmediakit 是否会删除](https://github.com/ZLMediaKit/ZLMediaKit/blob/master/server/WebApi.cpp#L1875)
     */
    val name: String? = null,
) : CommonStreamInfo
