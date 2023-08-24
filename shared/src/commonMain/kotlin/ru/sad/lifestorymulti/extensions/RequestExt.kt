package ru.sad.lifestorymulti.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.serialization.Serializable
import ru.sad.lifestorymulti.base.errors.LifestoryException


suspend fun <T> withContextSingle(
    block: suspend CoroutineScope.() -> BaseModelSingle<T>
): T {
    val result = kotlinx.coroutines.withContext(Dispatchers.IO, block)

    if ((result as? BaseModelSingle<*>)?.success != true || result.data == null) {
        throw LifestoryException(
            "Не удалось получить данные"
        )
    }

    return result.data
}

suspend fun <T> withContext(
    block: suspend CoroutineScope.() -> BaseModel<T>
): List<T> {
    val result = kotlinx.coroutines.withContext(Dispatchers.IO, block)

    if ((result as? BaseModel<*>)?.success != true) throw LifestoryException("Не удалось получить данные")

    return result.data
}

@Serializable
data class BaseModel<T>(val data: List<T>, val success: Boolean)

@Serializable
data class BaseModelSingle<T>(val data: T?, val success: Boolean)