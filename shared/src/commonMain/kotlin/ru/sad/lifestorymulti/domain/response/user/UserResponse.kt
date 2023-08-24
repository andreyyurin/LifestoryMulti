package ru.sad.lifestorymulti.domain.response.user

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(val token: String? = "", val photoUrl: String? = "", val id: Int? = -1, val username: String? = "")