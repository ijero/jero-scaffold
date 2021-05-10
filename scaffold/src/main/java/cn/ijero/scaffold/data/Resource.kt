package cn.ijero.scaffold.data

sealed class Resource(open val msg: String? = null)

data class Success<T>(
    val data: T? = null, override val msg: String? = null
) : Resource(msg)

data class Error(
    val error: Throwable?,
    override val msg: String? = null,
    val errorCode: Int = 0,
) : Resource(msg)