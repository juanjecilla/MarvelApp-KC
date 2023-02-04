package com.keepcoding.marvelapp.di

import android.content.Context
import androidx.room.Room
import com.keepcoding.marvelapp.data.repository.local.MarvelAppDatabase
import com.keepcoding.marvelapp.data.repository.local.MarvelDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MarvelAppDatabase {
        return Room.databaseBuilder(
            context,
            MarvelAppDatabase::class.java, "marvelapp-db"
        ).build()
    }

    @Provides
    fun provideDao(database: MarvelAppDatabase): MarvelDAO {
        return database.getDAO()
    }
}
