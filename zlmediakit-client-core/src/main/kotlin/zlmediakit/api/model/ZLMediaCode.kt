package zlmediakit.api.model

enum class ZLMediaCode(val code: Int) {
    /**
     * 执行成功
     */
    Success(code = 0),

    /**
     * 业务代码执行失败
     */
    OtherFailed(code = -1),

    /**
     * 鉴权失败
     */
    AuthFailed(code = -100),

    /**
     * sql执行失败
     */
    SqlFailed(code = -200),

    /**
     * 参数不合法
     */
    InvalidArgs(code = -300),

    /*
     * 代码抛异常
     */
    Exception(code = -400);

    companion object {
        fun fromCode(code: Int?): ZLMediaCode? {
            if (code == null) return null
            return entries.firstOrNull { it.code == code }
        }
    }
}