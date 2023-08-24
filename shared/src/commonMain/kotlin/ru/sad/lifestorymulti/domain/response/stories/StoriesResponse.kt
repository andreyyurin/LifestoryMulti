package ru.sad.lifestorymulti.domain.response.stories

import kotlinx.serialization.Serializable
import ru.sad.lifestorymulti.domain.response.user.UserResponse

@Serializable
data class StoriesResponse(
    val author: UserResponse,
    val imageUrl: String,
    val date: String
)