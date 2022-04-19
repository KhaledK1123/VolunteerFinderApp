package com.ex.volunteerfinder.view.ui

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.widget.TableRow
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.GenericFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ex.volunteerfinder.EventListScreen
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.SignUp
import com.ex.volunteerfinder.model.data.Conversation
import com.ex.volunteerfinder.model.data.Message
import com.ex.volunteerfinder.model.data.MessageDummy
import com.ex.volunteerfinder.model.data.UserDummy
import com.ex.volunteerfinder.view.EventDetailedViewScreen
import com.ex.volunteerfinder.view.NavigationItem
import com.ex.volunteerfinder.view.ui.composables.ChatCollectionComposable
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.EventViewModel
import org.intellij.lang.annotations.JdkConstants

/* From Richard: put 'Composables' in THIS file, going forward; when calling 'ProfileImage()', here,
have "Boolean=true" */
class VolunteerProfile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }

            }

        }

    }
}

@Composable
fun ProfileImage (thumbnail: Boolean = true) {

    Image(painter = painterResource(R.drawable.blankpfp),
        contentDescription = "Profile Picture",
        modifier = Modifier
            .absolutePadding(left = 8.dp, top=64.dp)
            .size(
                if (thumbnail) {
                    40.dp
                } else {
                    128.dp
                }
            )
            .clip(CircleShape)
    )

}

@Preview
@Composable
fun PreviewProfileImage() {
    com.ex.volunteerfinder.view.ui.composables.ProfileImage(thumbnail = true)

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
                        /* Avoid multiple copies of the same destination when
                        re-selecting the same item */
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                }
            )
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
//------------------------------------------------------------------------------------------------
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {

            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = {Text("Profile")})
        }
    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .wrapContentSize(Alignment.Center)
//        ) {
//            TableRow(text = "APP")
//        }
        Row() {
            Text(text = "Hello")
        }
    }

    ProfileImage()

    // Copied & adapted, from previous work: from line 202 - line 237
    Column(Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        ProfileDescription(
            displayName = "",
            username = "",
            email = "",
            address = "",
            volunteeredEventsCount = 3
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 75.dp),
            Arrangement.Top,
            Alignment.CenterHorizontally
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.Bottom,
            Alignment.Start

        ) {
            val context = LocalContext.current
            TextButton(
                onClick = {
                    context.startActivity(Intent(context, SignUp::class.java))
                })
        }
    }
}

fun TextButton(onClick: () -> Unit) {

}

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
            EventListScreen()
        }
        composable(NavigationItem.MyEvents.route) {
            EventDetailedViewScreen()

        }
        composable(NavigationItem.Map.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Messages.route) {
//            val previewList = listOf(MessageDummy.obj, MessageDummy.obj)
            val conversation = Conversation(users = listOf(UserDummy.obj, UserDummy.obj),
                messages = listOf(MessageDummy.obj,MessageDummy.obj)
                )
            ChatCollectionComposable(listOf(conversation))
        }
    }
}

/* 'TableRow', @ #282: ineffective, compared to online examples: either scrap, for something similar,
to past work (stressed by Mayur); OR, re-do */

/*  Lines 281-320, until come up w/new arrangement for bar, for # of volunteered events
@Composable
fun TableRow(text: String) {
    Text(
        text = "One",
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .absolutePadding(left = 8.dp)
            .paddingFromBaseline(top = 72.dp)
    );
    Text(
        text = "Two",
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 72.dp)
    );
    Text(
        text = "Three",
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 72.dp)
    );
    Text(
        text = "Four",
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 72.dp)
    )
} */

fun Row(verticalAlignment: Alignment.Vertical, modifier: Modifier) {

}

fun ProfileDescription(displayName: String, username: String, email: String, address: String, volunteeredEventsCount: Int) {

}

fun Column(modifier: Modifier, verticalArrangement: Arrangement.Vertical, horizontalAlignment: Alignment.Horizontal) {

}


