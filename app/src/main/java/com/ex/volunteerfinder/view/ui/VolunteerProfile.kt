package com.ex.volunteerfinder.view.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme

/* From Richard: put Composables in THIS file, going forward; when calling 'ProfileImage()', here,
have "Boolean=true" */

/*  For Buttons indicating 'One', 'Two', 'Three', & 'Four' - look up code examples; also ask about
squiggly lines, representing text, on the UI - actual text, to code in?  */

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

                }

            }

        }

    }
}

@Composable
fun ProfileImage (thumbnail: Boolean = true) {

    Image(painter = painterResource(R.drawable.blankpfp),
        contentDescription = "Profile Picture",
        modifier = Modifier.size(
            if (thumbnail) {
                40.dp
            } else {
                128.dp
            }
        ).clip(CircleShape)
    )

}

@Preview
@Composable
fun PreviewProfileImage() {
    com.ex.volunteerfinder.view.ui.composables.ProfileImage(thumbnail = true)
}

// POSSIBLE Link, to main UI: code @bottom, IF NEEDED

/* Will use/find equivalency for Java's 'TableLayout' and/or 'TableRow', for #'s 'One' - 'Four'
(corresponding to # of times to "volunteered"/"posts"/"flair?"), when used as mid-bottom row */