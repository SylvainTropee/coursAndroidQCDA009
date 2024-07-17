package com.example.mod3demo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mod3demo3.ui.theme.CoursAndroidQCDA009Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                RowAndColumnExample()
            }
        }
    }
}

@Composable
fun RowAndColumnExample(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Exemple d'utilisation de Row et column")
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Item 1")
            Text(text = "Item 2")
            Text(text = "Item 3")
        }
        Column() {
            Text(text = "Item A")
            Text(text = "Item B")
            Text(text = "Item C")
        }
        BoxExample()
    }
}

@Composable
fun BoxExample(modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.BottomEnd,
    ) {
        Image(
            painter = painterResource(id = R.drawable.hero),
            contentDescription = "Logo")
        Icon(
            modifier = Modifier.padding(horizontal = 16.dp),
            imageVector = Icons.Default.Face,
            contentDescription = null,
            tint = Color.Red
        )
    }

}


@Preview
@Composable
fun Preview() {
    RowAndColumnExample()
}














