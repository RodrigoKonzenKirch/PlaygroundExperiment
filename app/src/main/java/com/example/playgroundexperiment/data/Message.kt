package com.example.playgroundexperiment.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val content: String,
)
