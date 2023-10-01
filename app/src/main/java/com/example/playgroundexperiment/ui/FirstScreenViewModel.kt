package com.example.playgroundexperiment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playgroundexperiment.data.Message
import com.example.playgroundexperiment.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    fun saveMessage(message: Message) {
        viewModelScope.launch {
            repository.insertMessage(message)
        }
    }

    fun deleteMessage(id: Message) {
        viewModelScope.launch {
            repository.deleteMessage(id)
        }
    }

    fun getAllMessages(): Flow<List<Message>> {
        return repository.getAllMessages()
    }
}