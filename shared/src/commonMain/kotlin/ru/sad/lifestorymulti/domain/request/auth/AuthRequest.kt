package ru.sad.lifestorymulti.domain.request.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(val nickname: String, val photoUrl: String = "")