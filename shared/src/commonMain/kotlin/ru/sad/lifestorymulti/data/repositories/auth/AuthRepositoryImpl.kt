package ru.sad.lifestorymulti.data.repositories.auth

import kotlinx.coroutines.flow.Flow
import ru.sad.lifestorymulti.domain.response.user.UserResponse

interface AuthRepositoryImpl {
    suspend fun auth(nickname: String): UserResponse
}