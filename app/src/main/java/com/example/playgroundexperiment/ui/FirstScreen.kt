package com.example.playgroundexperiment.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.playgroundexperiment.data.Message

@Composable
fun AppScreen(modifier: Modifier = Modifier) {

    val viewModel = hiltViewModel<FirstScreenViewModel>()
    val tempMessageList = emptyList<Message>()

    val messageListState = viewModel.getAllMessages().collectAsState(initial = emptyList())
    Column {
        SaveOrDeleteMessages(
            messageListState = messageListState,
            onSaveMessage = {
                viewModel.saveMessage(it)
            },
            onDeleteMessage = {
                viewModel.deleteMessage(it)
            }
        )
        MessageList(tempMessageList)

    }
}

@Composable
fun MessageList(messageList: List<Message>) {
    LazyColumn{
        items(messageList) {message ->
            Column {
                Text(
                    text = message.title,
                    Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
                Text(
                    text = message.content,
                    Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaveOrDeleteMessages(
    messageListState: State<List<Message>>,
    onSaveMessage: (message: Message) -> Unit,
    onDeleteMessage: (message: Message) -> Unit,
) {
    var titleText by remember {
        mutableStateOf("")
    }
    var contentText by remember {
        mutableStateOf("")
    }

    Column(Modifier.padding(8.dp)) {
        TextField(
            value = titleText,
            onValueChange = { titleText = it },
            label = { Text(text = "Title") },
            singleLine = true,
        )
        TextField(
            value = contentText,
            onValueChange = { contentText = it },
            label = { Text(text = "Content") },
        )
        Row(Modifier.padding(8.dp)) {
            Button(
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Save")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Delete")
            }
        }
    }
}