package com.example.myportifolio

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Verified
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SkillsScreen(modifier: Modifier = Modifier) {
    Column(
    ) {
        Text(

            text = "My Skills",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 8.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        SkillGrid()


    }
}


@Composable
fun SkillGrid(){
    val lazyListState = rememberLazyListState()

    Scaffold() {
            padding ->
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 32.dp),
            state = lazyListState,
            modifier = Modifier.padding(padding)
        ){
            items(EducationRepository.mores){ mor ->
                CardContentSkill(more = mor)
            }
        }
    }
}

@Composable
fun SkillsRowSpacer(visible: Boolean) {
    AnimatedVisibility(visible = visible) {
        Spacer(modifier = Modifier.height(8.dp))
    }
}


@Composable
fun CardContentSkill(more: More) {
    var expanded by remember { mutableStateOf(false) }
    SkillsRowSpacer(visible = expanded)
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 3.dp,

    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(start = 6.dp),
            horizontalArrangement = Arrangement.Start
        ){
            IconButton(
                onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = ""
                )
            }
        }

        Text(
            text = stringResource(id = more.mySkill),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth().padding(start = 50.dp, top = 10.dp)
        )
        if (expanded){

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = more.description),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 50.dp , bottom = 4.dp)
            )
        }
    }
}



