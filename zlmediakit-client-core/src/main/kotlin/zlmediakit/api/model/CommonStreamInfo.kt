package zlmediakit.api.model

interface CommonStreamInfo {
    /**
     * 添加的流的虚拟主机，例如__defaultVhost__
     */
    var vhost: String?

    /**
     * 添加的流的应用名，例如 live
     */
    val app: String?

    /**
     * 添加的流的 id 名，例如 test
     */
    val stream: String?
}