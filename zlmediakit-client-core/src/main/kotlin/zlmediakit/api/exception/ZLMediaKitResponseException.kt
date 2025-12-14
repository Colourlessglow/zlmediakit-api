package zlmediakit.api.exception

import zlmediakit.api.model.IZLMediaResponse
import zlmediakit.api.model.ZLMediaCode
import zlmediakit.api.model.ZLMediaResponse


/**
 * zlmediakit 媒体服务响应异常
 */
class ZLMediaKitResponseException : Exception {
    val code: ZLMediaCode?
    val response: IZLMediaResponse?

    constructor(response: IZLMediaResponse) : super(response.msg) {
        code = ZLMediaCode.fromCode(response.code)
        this.response = ZLMediaResponse(
            code = response.code,
            msg = response.msg,
        )
    }
}