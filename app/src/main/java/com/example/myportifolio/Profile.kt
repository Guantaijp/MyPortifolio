package com.example.myportifolio

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity

@OptIn(ExperimentalTextApi::class)
@Composable
fun ProfileScreen() {



    val infiniteTransition = rememberInfiniteTransition()
    val rotateAnimation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing))
    )

    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    Column() {
        Text(
            text = "Analytical and detail oriented Android app developer professional with stellar communication skills who is based in Kenya. Adept at bringing all team members together to reach a common goal on time and under budget. Conceptualizing app solutions with the latest technology, design theory, and a large dose of creativity. Committed to viable and easily functional app solutions for clients.",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )

        Text(

            text = "Contact me through",
            style = TextStyle(rainbowColorsBrush),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 8.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

       Text(
           text = "(to see my projects click on the Github icon)" ,
           textAlign = TextAlign.Center,
           fontWeight = FontWeight.Thin,
           fontSize = 12.sp,
           modifier = Modifier.padding(start = 18.dp)
       )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            val context = LocalContext.current
            Column {
                Image(
                    painter = painterResource(id = R.drawable.myma),
                    contentDescription = "Localized description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable { context.sendMail(to = "jpguantai@gmail.com", subject = "") }
                )
                Text(
                    text = "Email", fontSize = 12.sp,
                )
            }
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.link),
                    contentDescription = "Localized description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable { linkToLinkedIn(context) }
                )
                Text(text = "LinkedIn", fontSize = 12.sp,)
            }

            Column() {
                Image(
                    painter = painterResource(id = R.drawable.twittericon),
                    contentDescription = "Localized description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable { linkToTwitter(context) }
                )
                Text(text = "Twitter", fontSize = 12.sp,)
            }
            Column() {
             Image(
                 painter = painterResource(id = R.drawable.githubicon),
                 contentDescription = "Localized description",
                 contentScale = ContentScale.Crop,
                 modifier = Modifier
                     .size(40.dp)
                     .clip(CircleShape)
                     .clickable { linkToGitHub(context) }
             )
                Text(text = "GitHub", fontSize = 12.sp,)
            }


        }
    }
}
fun linkToGitHub(context: Context) {
    val openURL = Intent(Intent.ACTION_VIEW)
    openURL.data = Uri.parse("https://github.com/Guantai001")
    startActivity(context, openURL, null)

}
fun linkToTwitter(context: Context) {
    val openURL = Intent(Intent.ACTION_VIEW)
    openURL.data = Uri.parse("https://twitter.com/giantily")
    startActivity(context, openURL, null)

}

fun linkToLinkedIn(context: Context) {
    val openURL = Intent(Intent.ACTION_VIEW)
    openURL.data = Uri.parse("https://www.linkedin.com/in/guantai-john-paul-a140311b1/")
    startActivity(context, openURL, null)

}

