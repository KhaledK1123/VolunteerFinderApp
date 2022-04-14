package com.ex.volunteerfinder.view.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.model.data.User

/**
 * Checks database for an existing profile picture, and displays the pfp if it exists. If the
 * K/V pair returns null, displays default profile picture. Can display in full size or thumbnail.
 */
@Composable
fun ProfileImage (user: User, thumbnail: Boolean = false) {
    /*
    TODO replace "R.drawable.blankpfp" with a check in the database, where !null returns
    their image resource index, and null returns the image resource index for blankpfp
     */

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