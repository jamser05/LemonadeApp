package com.example.lemonade

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
                // A surface container using the 'background' color from the theme
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonadeImage()
}


@Composable
fun LemonadeImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center))
{

    var displayImage by remember { mutableStateOf(1) }
    val imageResource = when(displayImage) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_restart
    }

    val textDisplay = when(displayImage) {
        1 -> R.string.step1
        2 -> R.string.step2
        3 -> R.string.step3
        4 -> R.string.step4
        else -> R.string.step4
    }

    Column(modifier = Modifier.
            background(Color.White)
        , horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(id = imageResource),
            contentDescription = "Click Me",
            modifier = Modifier.clickable() {
                displayImage++

                if(displayImage == 5) {
                    displayImage = 1
                }
            }.background(Color.Green)

        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = textDisplay),
            color = Color.Black,
            fontSize = 16.sp)
    }
}


