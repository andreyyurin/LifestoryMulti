package ru.sad.lifestorymulti.base.errors

interface ErrorHandlerImpl {
    fun getError(throwable: Throwable): String
}