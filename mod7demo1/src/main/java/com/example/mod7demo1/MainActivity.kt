package com.example.mod7demo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod7demo1.ui.theme.CoursAndroidQCDA009Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                JokeScreen()
            }
        }
    }
}

@Composable
fun JokeScreen(
    jokeViewModel: JokeViewModel = viewModel(factory = JokeViewModel.Factory)
){
    val joke by jokeViewModel.joke.collectAsState()

    Column(modifier = Modifier.padding(top = 40.dp)) {
        Button(onClick = {
            jokeViewModel.getJoke()
        }) {
            Text("Give me a Chuck !")
        }
        Text(text= joke?.value ?: "")
    }

}




