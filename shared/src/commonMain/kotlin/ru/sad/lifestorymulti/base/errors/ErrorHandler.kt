package ru.sad.lifestorymulti.base.errors

internal class ErrorHandler : ErrorHandlerImpl {
    companion object {
        private const val ERROR_TAG = "LIFESTORY-EXCEPTION"
    }

    override fun getError(throwable: Throwable): String = when (throwable) {
        is NullPointerException -> {
            ""
        }

        is IllegalStateException -> {
            ""
        }

        is LifestoryException -> {
            throwable.message
        }

        else -> {
            ""
        }
    }
}