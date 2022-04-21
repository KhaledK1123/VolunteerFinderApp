package com.ex.volunteerfinder.view.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ex.volunteerfinder.ImageWithText
import com.ex.volunteerfinder.MainActivity
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.SignUp
import com.ex.volunteerfinder.view.MainScreen
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme

/* Richard's idea: 'Composables' in THIS file, going forward; when calling 'ProfileImage()', here,
have "Boolean=true" */
class VolunteerProfile : ComponentActivity() {
    // @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()

        }
            /* Starting below, & for following, 5 lines: replaced ('MainScreen()')
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) */
            }
}

@Composable
fun ProfileDescription(
    displayName: String,
    username: String,
    email: String,
    address: String,
    volunteeredEventsCount: Int,
    volunteeredNumberOfTimesCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Name: $displayName",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Username: $username",
            style = MaterialTheme.typography.body1,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Email: $email",
            style = MaterialTheme.typography.body1,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Address: $address",
            style = MaterialTheme.typography.body1,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = buildAnnotatedString {
                append("Volunteered $volunteeredEventsCount times!")
            },
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

    }
}

@Composable
fun ProfileImage (thumbnail: Boolean = true) {

    Image(painter = painterResource(R.drawable.blankpfp),
        contentDescription = "Profile Picture",
        modifier = Modifier
            .absolutePadding(left = 8.dp, top = 64.dp)
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

//-------------------------------------------------------------------------------------------------
/*@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}

@Preview
@Composable
// @OptIn(ExperimentalFoundationApi::class)
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
    }

    ProfileImage()

    /* Copied & adapted; 4/21/22: Commented out, since it's duplicating another, up-program
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
            volunteeredNumberOfTimesCount= 3
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
*/
 */

fun TextButton(onClick: () -> Unit) {

}

@Preview
@Composable
fun SubmitButton2() {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {
        var volunteeredNumberOfTimes by rememberSaveable { mutableStateOf("") }

        TextField(
            value = volunteeredNumberOfTimes,
            onValueChange = { volunteeredNumberOfTimes = it },
            label = { Text("Number of Volunteered Events") },
            modifier = Modifier
                .padding(top = 35.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        var status by rememberSaveable {
            mutableStateOf("")

        }

        val backgroundColor = Color.Black
        Button2(shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            onClick = {
                status =
                    VolunteeredNumberOfTimes(volunteeredNumberOfTimes);
                context.startActivity(Intent(context, MainActivity::class.java)
                )
            }
        )
    }
}

fun Row(verticalAlignment: Alignment.Vertical, modifier: Modifier) {

}

fun Column(modifier: Modifier, verticalArrangement: Arrangement.Vertical,
           horizontalAlignment: Alignment.Horizontal) {

}

fun VolunteeredNumberOfTimes(volunteeredNumberOfTimes: String): String = Unit.toString()

fun Button2(shape: RoundedCornerShape, colors: ButtonColors, modifier: Modifier,
            onClick: () -> Unit) {

}

/* Second line below, through the end: POSSIBLY re-use/adapt (Extra bar, RE: # of volunteered
events); otherwise, reference only
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


@Composable
fun ProfileScreen() {
    VolunteerFinderAppTheme() {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.white))
                .wrapContentSize(Alignment.TopCenter)
        ) {
            //SimpleText2("Donate Item")

            //SubmitButton2()

            ProfileSection()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    VolunteerProfile()
}

@Composable
fun ProfileSection(){
    Scaffold(
        topBar = {

            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = {Text("Profile")})
        }
    )
    {
        Column(Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                RoundImage(
                    image = painterResource(id = R.drawable.img2),
                    modifier = Modifier
                        .size(100.dp)
                        .weight(3f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                StatSection(modifier = Modifier.weight(7f))
            }
            Spacer(modifier = Modifier.height(10.dp))
            ProfileDescription(
                displayName = "John Adams",
                username = "AdamsApple74",
                email = "JohnnyBoy74@gmail.com",
                address = "47129 Cabron Ave, Winchester, CA, 92596",
                donationCount = 18
            )
            Column(

                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 75.dp),
                Arrangement.Top,
                Alignment.CenterHorizontally
            ) {
                belowProfile()
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                Arrangement.Bottom,
                Alignment.Start

            ) {
                val context = LocalContext.current
                TextButton(
                    onClick = {
                        //context.startActivity(Intent(context, EditProfileView::class.java))
                    },
                ) {
                    Text(
                        "Edit Profile",
                        style = MaterialTheme.typography.button,
                        color = Color(0xFF673AB7)
                    )
                }
            }
        }
    }
}
@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}
@Composable
fun StatSection(modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "18", text = "Donations")
        ProfileStat(numberText = "16", text = "Items Received")
        ProfileStat(numberText = "523", text = "Flair")
    }
}
@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            style = MaterialTheme.typography.body1,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    username: String,
    email: String,
    address: String,
    donationCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Name: $displayName",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Username: $username",
            style = MaterialTheme.typography.body1,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Email: $email",
            style = MaterialTheme.typography.body1,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Address: $address",
            style = MaterialTheme.typography.body1,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = buildAnnotatedString {
                append("Donated $donationCount times!")
            },
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun belowProfile()
{
    var selectedTabIntex by remember {
        mutableStateOf(0)
    }
    PostTabView(
        imageWithText = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.ic_grid),
                text = "Posts"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.ic_reels),
                text = "Reels"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.ic_igtv),
                text = "IGTV"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.ic_profile),
                text = "Profile"
            ),
        )
    ){
        selectedTabIntex = it
    }
    when(selectedTabIntex){
        0 -> PostSection(
            posts = listOf(
                painterResource(id = R.drawable.iphone),
                painterResource(id = R.drawable.mercedes)

            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}
@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}
