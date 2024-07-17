package com.example.mod3demo2

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mod3demo2.ui.theme.CoursAndroidQCDA009Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                Hello()
            }
        }
    }
}

@Composable
fun Hello(modifier: Modifier = Modifier){
    Text(
        text = "Hello World !",
        fontStyle = FontStyle.Italic,
        color = Color.Red,
        modifier = Modifier
            .padding(8.dp)
            .size(40.dp)
    )
}

@Composable
@Preview
fun HelloPreview(){
    Hello()
}










