package com.example.playgroundexperiment.di

import com.example.playgroundexperiment.data.RepositoryImpl
import com.example.playgroundexperiment.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesRepository(repositoryImpl: RepositoryImpl): Repository

}