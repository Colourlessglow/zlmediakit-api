package zlmediakit.api.config

/**
 * zlmediakit 媒体服务配置
 */
interface HttpConfig{
    /**
     * 密钥
     */
    val secret: String
    /**
     * 服务基础地址
     */
    val baseUrl: String
}