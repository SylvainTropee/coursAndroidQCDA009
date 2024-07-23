package com.example.mod5demo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mod5demo5.ui.theme.CoursAndroidQCDA009Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                App()
            }
        }
    }
}

@Composable
fun App(){
    val navHostController = rememberNavController()
    AppNavHost(navHostController = navHostController)
}

@Composable
fun HomePage() {
    Text(
        text = "Bienvenue dans l'application !",
        modifier = Modifier.padding(top = 32.dp)
    )
}

@Composable
fun ProfilPage(name: String) {
    Text(
        text = "Bienvenue dans ton profil $name !",
        modifier = Modifier.padding(top = 32.dp)
    )
}

@Composable
fun SignInPage(onClickToHome : () -> Unit ) {

    var text by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                value = text,
                onValueChange = {
                    text = it
                })

            OutlinedButton(
                onClick = onClickToHome,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            ) {
                Text(text = "GO TO HOME")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            ) {
                Text("GO TO PROFILE")
            }
        }
    }
}

@Composable
fun AppNavHost(navHostController: NavHostController){

    NavHost(
        navController = navHostController,
        startDestination = "signIn"
    ){

        composable(route = "home"){
            HomePage()
        }
        composable(route = "signIn"){
            SignInPage(onClickToHome = {
                navHostController.navigate("home")
            })
        }
        composable(route = "profil"){
            ProfilPage(name = "")
        }

    }

}






