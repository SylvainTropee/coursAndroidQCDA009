package com.example.mod4tp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod4tp1.ui.theme.CoursAndroidQCDA009Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DiceScreen(
    modifier: Modifier = Modifier,
    diceViewModel: DiceViewModel = viewModel()
) {

    val totalLaunch by diceViewModel.totalRollNumber.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = diceViewModel.diceNumberId),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Text(totalLaunch.toString())
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Total = ${diceViewModel.leftScore} / ${diceViewModel.leftRollNumber} lancers")
                Button(
                    onClick = { diceViewModel.rollLeft() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "GAUCHE")
                }
            }
            Column(modifier = Modifier.weight(1f)) {

                Text(
                    "Total = ${diceViewModel.rightScore} / ${diceViewModel.rightRollNumber} lancers",
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = { diceViewModel.rollRight() },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "DROITE")
                }
            }
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Recommencer")
        }
    }
}

@Composable
@Preview
fun Preview() {
    DiceScreen()
}

















