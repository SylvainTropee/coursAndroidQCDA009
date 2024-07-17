package com.example.mod3demo4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mod3demo4.ui.theme.CoursAndroidQCDA009Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                SpacerExample()
            }
        }
    }
}


@Composable
fun SpacerExample(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "La communauté de l'agneau")
        Row(modifier = modifier.height(IntrinsicSize.Min)) {
            Text(text = "Les deux tours")
            Spacer(modifier = modifier
                .fillMaxHeight()
                .width(2.dp)
                .background(Color.Red))
            Spacer(modifier = modifier
                .fillMaxHeight()
                .width(2.dp)
                .background(Color.Red))
        }

        Text(text = "Le retour d'Elvis")
    }
}

@Preview
@Composable
fun Preview() {
    SpacerExample(modifier = Modifier.padding(2.dp))
}











