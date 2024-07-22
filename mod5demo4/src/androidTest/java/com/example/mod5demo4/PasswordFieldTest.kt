package com.example.mod5demo4

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class PasswordFieldTest {

    //récupérer l'objet qui permet les tests
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun textFieldPasswordIsWorking(){
        //passage du composant à tester à notre règle
        composeTestRule.setContent {
            PasswordTextField()
        }

        //préparation du scénario
        composeTestRule
            .onNodeWithTag(TEXT_TAG_TEXFIELD_PWD)
            .performTextInput("Pa\$\$w0rd")
        composeTestRule
            .onNodeWithContentDescription("Montrer mot de passe")
            .performClick()

        //test de la présence des éléments attendus
        composeTestRule
            .onNodeWithContentDescription("Cacher mot de passe")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag(TEXT_TAG_TEXFIELD_PWD)
            .assert(hasText("Pa\$\$w0rd"))
    }

}