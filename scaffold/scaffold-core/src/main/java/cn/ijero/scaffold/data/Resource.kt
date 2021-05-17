package cn.ijero.scaffold.data

sealed class Resource(open val msg: String? = null)

data class Success<T>(
    val data: T? = null,
    override val msg: String? = null
) : Resource(msg)

data class Error(
    val error: Throwable?,
    override val msg: String? = null,
    val errorCode: Int = DEF_ERROR_CODE,
) : Resource(msg){
    companion object{
        const val DEF_ERROR_CODE = 1000
    }
}