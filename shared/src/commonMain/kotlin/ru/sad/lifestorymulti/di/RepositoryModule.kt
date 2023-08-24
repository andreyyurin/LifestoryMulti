package ru.sad.lifestorymulti.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.sad.lifestorymulti.data.api.LifestoryApi
import ru.sad.lifestorymulti.data.repositories.auth.AuthRepository
import ru.sad.lifestorymulti.data.api.LifestoryApiImpl
import ru.sad.lifestorymulti.data.repositories.auth.AuthRepositoryImpl

inline fun getRepositoryModule(): Module = module {
    this.singleOf(::LifestoryApi) { bind<LifestoryApiImpl>() }
    this.singleOf(::AuthRepository) { bind<AuthRepositoryImpl>() }
}