package com.keepcoding.marvelapp.di

import com.keepcoding.marvelapp.data.repository.RepositoryImpl
import com.keepcoding.marvelapp.data.repository.local.LocalDataSource
import com.keepcoding.marvelapp.data.repository.local.LocalDataSourceImpl
import com.keepcoding.marvelapp.data.repository.remote.RemoteDataSource
import com.keepcoding.marvelapp.data.repository.remote.RemoteDataSourceImpl
import com.keepcoding.marvelapp.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}
