package com.example.playgroundexperiment.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MessagesDao {

    @Insert
    suspend fun insertMessage(message: Message)

    @Delete
    suspend fun deleteMessage(message: Message)

    @Query("SELECT * FROM messages WHERE id = :id")
    fun getMessageById(id: Int): Message

    @Query("SELECT * FROM messages")
    fun getAllMessages(): Flow<List<Message>>

}