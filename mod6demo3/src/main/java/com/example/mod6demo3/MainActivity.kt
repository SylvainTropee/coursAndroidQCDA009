package com.example.mod6demo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6demo3.ui.theme.CoursAndroidQCDA009Theme
import com.example.mod6demo3.vm.BeverageViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                BeverageScreen()
            }
        }
    }
}

@Composable
fun BeverageScreen(beverageViewModel: BeverageViewModel = viewModel(factory = BeverageViewModel.Factory)) {

    val beverages by beverageViewModel.beverages.collectAsState()

    LazyColumn {
        items(beverages) {
            Text(
                text = "${it.name} a une couleur ${it.color} au prix de ${it.price} €",
                fontSize = 20.sp
            )
        }
    }


}
