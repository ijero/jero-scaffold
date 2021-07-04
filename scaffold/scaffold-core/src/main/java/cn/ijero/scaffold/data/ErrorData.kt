package cn.ijero.scaffold.data

data class ErrorData(
    val error: Throwable?,
    val msg: String? = null,
    val errorCode: Int = DEF_ERROR_CODE,
) {
    companion object {
        const val DEF_ERROR_CODE = 1000
    }
}