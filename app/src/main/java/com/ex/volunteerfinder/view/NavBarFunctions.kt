package com.ex.volunteerfinder.view

import android.content.Intent
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ex.volunteerfinder.*
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.model.data.Conversation
import com.ex.volunteerfinder.model.data.MessageDummy
import com.ex.volunteerfinder.model.data.UserDummy
import com.ex.volunteerfinder.view.BottomNavigationBar
import com.ex.volunteerfinder.view.ui.ProfileScreen
import com.ex.volunteerfinder.view.ui.composables.ChatCollectionComposable

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Profile.route) {
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Commons.route) {

            //val viewModel = ViewModelProvider()
//            val appObj1 = Application()
//            val eventViewModel = EventViewModel(appObj1)
            //EventListScreen(eventViewModel = eventViewModel)
            //EventListScreen()
            EventDetailedViewScreen()
        }
        composable(NavigationItem.MyEvents.route) {
            PreEventListScreen()

        }
        composable(NavigationItem.Map.route) {
            EventMap()
        }
        composable(NavigationItem.Messages.route) {
//            val previewList = listOf(MessageDummy.obj, MessageDummy.obj)
            val conversation = Conversation(users = listOf(UserDummy.obj, UserDummy.obj),
                messages = listOf(MessageDummy.obj, MessageDummy.obj)
            )
            ChatCollectionComposable(listOf(conversation))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    //BottomNavigationBar()
}

@Composable
fun TopBar() {

}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        //topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Profile,
        NavigationItem.Commons,
        NavigationItem.MyEvents,
        NavigationItem.Map,
        NavigationItem.Messages
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.gold_400),
        contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = {
                    Text(
                        modifier = Modifier
                            .width(100.dp),
                        text = item.title,
                        fontSize = 11.sp
                    ) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}
