package com.example.playgroundexperiment.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Message::class],
    version = 1
)
abstract class MessageDatabase: RoomDatabase() {
    abstract fun messageDao(): MessagesDao
}