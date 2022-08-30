package com.example.buttontoactiontestapp.ui.button

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.buttontoactiontestapp.R
import com.example.buttontoactiontestapp.core.presentation.button.ButtonState
import com.example.buttontoactiontestapp.ui.LoadingIndicator
import com.example.buttontoactiontestapp.ui.theme.Blue800
import com.example.buttontoactiontestapp.ui.theme.Teal200

@Composable
fun ButtonScreen() {
    val viewModel = viewModel<ButtonViewModel>()
    val state by viewModel.state.collectAsState(initial = ButtonState())

    LaunchedEffect(viewModel) {
        viewModel.effect.collect { effect ->
            when (effect) {
                //TODO: implement effect handling
            }
        }
    }

    if (state.isLoading) {
        LoadingIndicator(Modifier.fillMaxSize())
        return
    }

    val resources = LocalContext.current.resources
    val descriptionText = resources.getString(R.string.description)
    val btnText = resources.getString(R.string.perform_action)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 14.dp, bottom = 100.dp, start = 36.dp, end = 36.dp),
                text = descriptionText,
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color.White, fontSize = 12.sp)
            )
            Button(
                modifier = Modifier
                    .width(150.dp)
                    .height(32.dp)
                    .padding(start = 36.dp, end = 36.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
                shape = RoundedCornerShape(7F, 7F, 7F, 7F),
                contentPadding = PaddingValues(bottom = 0.dp),
                onClick = {
                    //TODO: implement click action logic
                }
            ) {
                Text(
                    text = btnText,
                    style = TextStyle(
                        color = Blue800,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
    }
}