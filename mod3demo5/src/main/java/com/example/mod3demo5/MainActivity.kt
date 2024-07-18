package com.example.mod3demo5

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mod3demo5.ui.theme.CoursAndroidQCDA009Theme

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                ListExample()
            }
        }
    }
}

@Composable
fun ListExample(modifier: Modifier = Modifier) {

    val articles = List(50) { "Article $it" }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(articles) { article ->
            ArticleItem(text = article)
        }
    }
}

@Composable
fun ArticleItem(
    text: String,
    modifier: Modifier = Modifier
) {

    //MaterialTheme.colorScheme.primary -> accès au couleur du thème de l'application
    Surface(
        border = BorderStroke(2.dp, Color.Blue),
        shape = CircleShape,
        color = Color.Red,
        contentColor = Color.White,
        shadowElevation = 10.dp
    ) {

        //remember permet de conserver l'état d'une variable dans un composant
        //rememberSaveable le fait même en cas de changement de configuration
        var isChecked by rememberSaveable {
            mutableStateOf(false)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = text)
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    Log.i(TAG, "$text : " + it)
                    isChecked = !isChecked
                }
            )
        }
    }

}


@Composable
@Preview
fun Preview() {
    ListExample()
}

















