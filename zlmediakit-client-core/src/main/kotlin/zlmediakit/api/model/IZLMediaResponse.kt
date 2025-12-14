package zlmediakit.api.model

interface IZLMediaResponse {
    /**
     * 响应码
     * @see ZLMediaCode
     */
    var code: Int?

    /**
     * 响应信息
     */
    var msg: String?
}