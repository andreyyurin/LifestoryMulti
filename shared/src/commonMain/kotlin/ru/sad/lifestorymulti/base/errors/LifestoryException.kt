package ru.sad.lifestorymulti.base.errors

class LifestoryException(private val messageForUser: String) : Exception() {
    override val message: String = messageForUser
}