package com.example.mod5demo5

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination{
    val route : String
}

object HomeDestination : Destination{
    override val route: String
        get() = "home"
}

object SignInDestination : Destination{
    override val route: String
        get() = "signIn"
}

object ProfileDestination : Destination{
    override val route: String
        get() = "profil"

    val nameArg = "name"
    val arguments = listOf(
        navArgument(nameArg){ type = NavType.StringType }
    )

    val routeWithArgs = "$route/{$nameArg}"
}