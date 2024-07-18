package com.example.mod4demo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod4demo3.ui.theme.CoursAndroidQCDA009Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                RatingScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatingScreen(ratingViewModel: RatingViewModel = viewModel()) {

    val rating by ratingViewModel.rating.collectAsState()
    val answer by ratingViewModel.userAnswer.collectAsState()

    Column {
        Spacer(modifier = Modifier.height(32.dp))
        Slider(
            value = rating,
            valueRange = 0f..10f,
            onValueChange = {
                ratingViewModel.updateRating(it)
            }
        )
        if (rating < 7) {
            Text("Que peut-on faire pour améliorer votre expérience ?")
            TextField(value = answer, onValueChange = {
                ratingViewModel.updateUserAnswer(it)
            })
            Button(onClick = { ratingViewModel.saveInDbb() }) {
                Text("Envoyer")
            }
        } else {
            Text("Nous sommes ravis que le séjour vous est plu !")
        }
    }
}

@Preview
@Composable
fun Preview() {
    RatingScreen()
}
















