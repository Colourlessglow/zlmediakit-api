package zlmediakit.api.exception

class ZLMediaKitHttpException : RuntimeException {

    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}