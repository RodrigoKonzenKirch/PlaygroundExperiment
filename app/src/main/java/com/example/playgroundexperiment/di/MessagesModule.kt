package com.example.playgroundexperiment.di

import android.content.Context
import androidx.room.Room
import com.example.playgroundexperiment.data.MessageDatabase
import com.example.playgroundexperiment.data.MessagesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val MESSAGE_DATABASE_NAME = "message_database"

@Module
@InstallIn(SingletonComponent::class)
object MessagesModule {

    @Provides
    @Singleton
    fun providesMessageDatabase(
        @ApplicationContext appContext: Context
    ): MessageDatabase{
        return Room.databaseBuilder(
            appContext,
            MessageDatabase::class.java,
            MESSAGE_DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesMessagesDao(messageDatabase: MessageDatabase):MessagesDao {
        return messageDatabase.messageDao()
    }

}