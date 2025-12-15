package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 删除录像文件夹请求参数
 */
@Serializable
data class DeleteRecordDirectoryRequest(
    override var vhost: String? = null,
    override var app: String? = null,
    override var stream: String? = null,
    /**
     * 流的录像日期，格式为2020-01-01,如果不是完整的日期，那么会删除失败
     */
    var period: String? = null,
    /**
     * 录像文件保存自定义根目录，为空则采用配置文件设置
     */
    @SerialName("customized_path")
    var customizedPath: String? = null,
    /**
     * 录像文件
     *  > [从源码中翻出来的参数，不保证 zlmediakit 是否会删除](https://github.com/ZLMediaKit/ZLMediaKit/blob/master/server/WebApi.cpp#L1875)
     */
    var name: String? = null,
) : CommonStreamInfo
