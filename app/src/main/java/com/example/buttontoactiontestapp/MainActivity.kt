package com.example.buttontoactiontestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.buttontoactiontestapp.ui.button.ButtonScreen
import com.example.buttontoactiontestapp.ui.theme.Blue700
import com.example.buttontoactiontestapp.ui.theme.ButtonToActionTestAppTheme

private const val NAV_ROUTE_BUTTON_SCREEN = "ButtonScreen"

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonToActionTestAppTheme {
                navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                val topBarTitle = rememberSaveable { mutableStateOf(resources.getString(R.string.app_name)) }

                Scaffold(
                    scaffoldState = scaffoldState,
                    backgroundColor = Blue700,
                    topBar = {

                    },
                    snackbarHost = {
                        //TODO: implement snackbar to inform user regarding occurred errors
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(
                            bottom = innerPadding.calculateBottomPadding(),
                            top = innerPadding.calculateTopPadding()
                        )
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = NAV_ROUTE_BUTTON_SCREEN
                        ) {
                            composable(NAV_ROUTE_BUTTON_SCREEN) {
                                ButtonScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ButtonToActionTestAppTheme {
        Greeting("Android")
    }
}