package ru.sad.lifestorymulti.data.api

@MustBeDocumented
@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class Query(
    /** The query parameter name.  */
    val value: String,
    /**
     * Specifies whether the parameter [name][.value] and value are already URL encoded.
     */
    val encoded: Boolean = false
)