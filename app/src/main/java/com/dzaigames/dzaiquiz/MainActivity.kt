package com.dzaigames.dzaiquiz

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.dzaigames.dzaiquiz.ui.mainMenu.MainMenuScreen
import com.dzaigames.dzaiquiz.ui.mainMenu.MainMenuViewModel
import com.dzaigames.dzaiquiz.ui.mainMenu.MainMenuViewModelFactory
import com.dzaigames.dzaiquiz.ui.theme.DzaiQuizTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() { //AppCompatActivity() {
    private lateinit var mainMenuViewModel: MainMenuViewModel

    @Inject
    lateinit var mainMenuViewModelFactory: MainMenuViewModelFactory // Dagger will provide the object to this variable through field injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as DzaiQuizApplication).applicationComponent.inject(this)
        // what the above code do is, It will check the file for any of the @Inject property and if there are any
        // it will inject the correct object to them. Here it is mainViewModelFactory

        mainMenuViewModel = ViewModelProvider(this, mainMenuViewModelFactory)[MainMenuViewModel::class.java]

        setContent {
            DzaiQuizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuizApp(
                        mainMenuViewModel = mainMenuViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun QuizApp(
    mainMenuViewModel: MainMenuViewModel
) {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = NavigationRoutes.MainMenuScreen.route) {
//        composable(route = NavigationRoutes.MainMenuScreen.route) {
//            Log.i(MainActivity::class.java.toString(), "Navigating to ${NavigationRoutes.MainMenuScreen.route}")

//            val viewModel: MainMenuViewModel = daggerViewModel {
//                val mainMenuComponent = MainMenuComponent.create()
//                DaggerMainMenuComponent.builder().build().getViewModel()
//            }

            MainMenuScreen(
//                navController = navController,
                viewModel = mainMenuViewModel
            )
//        }
//    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DzaiQuizTheme {
        Greeting("Android")
    }
}