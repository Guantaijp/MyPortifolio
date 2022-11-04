package com.example.myportifolio

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myportifolio.ui.theme.md_theme_light_primary

@OptIn(ExperimentalTextApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(){

    Scaffold(
        topBar = {
            ResumeTopAppBar()
        }
    ){

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
        Column (
         modifier = Modifier
             .padding()
             .fillMaxWidth()
             .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ){

            Text(
                text = "Hello, I'm Guantai John Paul",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold,
                fontSize = 35.sp,
                textAlign = TextAlign.Center

            )
            Box (){
                val infiniteTransition = rememberInfiniteTransition()
                val rotateAnimation = infiniteTransition.animateFloat(
                    initialValue = 0f,
                    targetValue = 360f,
                    animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing))
                )
                val borderWidth = 4.dp
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

                Image(
                    painter = painterResource(id = R.drawable.mee),
                    contentDescription ="",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(300.dp)
                        .drawBehind {
                            rotate(rotateAnimation.value) {
                                drawCircle(rainbowColorsBrush,)
                            }
                        }

                        .padding(borderWidth)
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Android Developer",
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(rainbowColorsBrush),
                fontWeight = FontWeight.Bold,
            )

            ProfileScreen()
        }

    }
}

@Composable
fun ResumeTopAppBar(modifier: Modifier = Modifier,) {

    Row(
        modifier = modifier
            .fillMaxWidth()

            .background(color = MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(64.dp)
                .padding(8.dp),

            painter = painterResource(R.drawable.ic_woof_logo),
            contentDescription = null
        )

    }
}
fun Context.dial(phone: String) {
    try {
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)
    } catch (t: Throwable) {

    }
}
fun Context.sendMail(to: String, subject: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "vnd.android.cursor.item/email" // or "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {

    } catch (t: Throwable) {

    }
}

