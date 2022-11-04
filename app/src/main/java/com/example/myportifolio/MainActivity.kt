package com.example.myportifolio

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myportifolio.ui.theme.MyPortifolioTheme
import com.example.myportifolio.ui.theme.rust300
import com.example.myportifolio.ui.theme.rust600
import com.example.myportifolio.ui.theme.taupe800
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPortifolioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    myPortifolioApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun myPortifolioApp(){

    var navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
       
        scaffoldState= scaffoldState,
        content = {padding ->
            Box(modifier = Modifier.padding(padding)){
                NavigationGraph(navController = navController)
            }
        },
        bottomBar = { BottomBar(navController)}
    )

}

@Composable
fun BottomBar(navController: NavController,){
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Education,
        NavigationItem.Skills,

    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp,
        contentColor = MaterialTheme.colors.onPrimary,

    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon= {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,

                    )
                },
                label= {
                    Text(
                        text =item.title
                    )
                },
                //selected = true,
                selectedContentColor= MaterialTheme.colors.onBackground,
                alwaysShowLabel = true,
                unselectedContentColor= MaterialTheme.colors.secondary,
                selected = currentRoute == item.route,
                onClick = {  navController.navigate(item.route){
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route){
                            saveState =true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }

                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Education.route) {
            EducationScreen()
        }

        composable(NavigationItem.Skills.route) {
            SkillsScreen()
        }

    }
}
