package zlmediakit.api.model

interface CommonStreamInfo {
    /**
     * 添加的流的虚拟主机，例如__defaultVhost__
     */
    var vhost: String?

    /**
     * 添加的流的应用名，例如 live
     */
    var app: String?

    /**
     * 添加的流的 id 名，例如 test
     */
    var stream: String?
}