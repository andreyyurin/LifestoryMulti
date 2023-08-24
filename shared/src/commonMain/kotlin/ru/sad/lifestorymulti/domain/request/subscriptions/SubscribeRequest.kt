package ru.sad.lifestorymulti.domain.request.subscriptions

import kotlinx.serialization.Serializable

@Serializable
data class SubscribeRequest(val userId: Int)