package ru.sad.lifestorymulti.data.repositories.auth

import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.module.Module
import ru.sad.lifestorymulti.data.api.LifestoryApiImpl
import ru.sad.lifestorymulti.domain.request.auth.AuthRequest
import ru.sad.lifestorymulti.domain.response.user.UserResponse
import ru.sad.lifestorymulti.extensions.withContextSingle

open class AuthRepository(private val api: LifestoryApiImpl) : AuthRepositoryImpl {
    override suspend fun auth(nickname: String): UserResponse = withContextSingle {
        api.auth(AuthRequest(nickname))
    }
}