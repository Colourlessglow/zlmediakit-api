package zlmediakit.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取截图(getSnap)请求参数
 */
@Serializable
data class GetSnapRequest(
    /**
     * 是否采用zlm内置播放器、解码器api异步截图，开启后截图速度提升但兼容性降低
     */
    val async: Boolean? = null,

    /**
     * 截图的过期时间，该时间内产生的截图都会作为缓存返回
     */
    @SerialName("expire_sec")
    val expireSEC: Int,

    /**
     * 截图失败超时时间，防止FFmpeg一直等待截图
     */
    @SerialName("timeout_sec")
    val timeoutSEC: Int,

    /**
     * 需要截图的url，可以是本机的，也可以是远程主机的
     */
    val url: String
)
