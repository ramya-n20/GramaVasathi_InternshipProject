package com.gramavasathi.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AIAssistantScreen() {

    var userInput by remember { mutableStateOf("") }

    val messages = remember {
        mutableStateListOf(
            "AI: Welcome to GramaVasathi Assistant 🌾"
        )
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(messages) { message ->
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {

            TextField(
                value = userInput,
                onValueChange = { userInput = it },
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text("Ask something...")
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {

                    messages.add("You: $userInput")

                    val reply = when {
                        userInput.contains("booking", true) ->
                            "AI: You can book farm stays from the booking screen."

                        userInput.contains("culture", true) ->
                            "AI: Village culture includes farming, festivals and local food."

                        userInput.contains("activities", true) ->
                            "AI: Activities include fishing, cooking and bird watching."

                        else ->
                            "AI: Thank you for asking! Rural tourism improves village economy."
                    }

                    messages.add(reply)

                    userInput = ""
                }
            ) {
                Text("Send")
            }
        }
    }
}

