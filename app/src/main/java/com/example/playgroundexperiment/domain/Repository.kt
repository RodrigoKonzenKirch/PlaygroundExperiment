package com.example.playgroundexperiment.domain

import com.example.playgroundexperiment.data.Message
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun insertMessage(message: Message)

    suspend fun deleteMessage(message: Message)

    fun getMessageById(id: Int): Message

    fun getAllMessages(): Flow<List<Message>>
}