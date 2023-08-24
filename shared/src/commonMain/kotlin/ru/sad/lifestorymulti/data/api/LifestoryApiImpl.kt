package ru.sad.lifestorymulti.data.api

import io.ktor.client.request.HttpRequestBuilder
import ru.sad.lifestorymulti.domain.request.auth.AuthRequest
import ru.sad.lifestorymulti.domain.response.user.UserResponse
import ru.sad.lifestorymulti.extensions.BaseModelSingle

interface LifestoryApiImpl {
    suspend fun auth(
        authRequest: AuthRequest
    ): BaseModelSingle<UserResponse>
}