package ru.sad.lifestorymulti.data.api

import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.encodedPath
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer
import ru.sad.lifestorymulti.domain.request.auth.AuthRequest
import ru.sad.lifestorymulti.domain.response.user.UserResponse
import ru.sad.lifestorymulti.extensions.BaseModelSingle
import kotlin.reflect.KClass

class LifestoryApi : LifestoryApiImpl {

    override suspend fun auth(authRequest: AuthRequest): BaseModelSingle<UserResponse> =
        post("auth", authRequest)

//    private suspend fun ddas(@Query("dsads") userId: String): BaseModelSingle<UserResponse> {
//        return get(path = "auth", userId)
//    }

    private suspend inline fun <T : Any, R> post(path: String, request: T): BaseModelSingle<R> {
        return client.post {
            url {
                encodedPath = path
            }
            setBody(request::class)
        }.body()
    }

//    @OptIn(InternalSerializationApi::class)
//    private suspend inline fun <T : Any, R> get(
//        path: String,
//        vararg parameter: KClass<String>
//    ): BaseModelSingle<R> {
//        return client.get {
//            url {
//                encodedPath = path
//                parameter.forEach {
//                    parameters.append()
//                }
//            }
//        }.body()
//    }
}