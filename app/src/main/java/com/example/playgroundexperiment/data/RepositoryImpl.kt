package com.example.playgroundexperiment.data

import com.example.playgroundexperiment.domain.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val messagesDao: MessagesDao
): Repository {
    override suspend fun insertMessage(message: Message) {
        messagesDao.insertMessage(message)
    }

    override suspend fun deleteMessage(message: Message) {
        messagesDao.deleteMessage(message)
    }

    override fun getMessageById(id: Int): Message {
        return messagesDao.getMessageById(id)
    }

    override fun getAllMessages(): Flow<List<Message>> {
        return messagesDao.getAllMessages()
    }
}