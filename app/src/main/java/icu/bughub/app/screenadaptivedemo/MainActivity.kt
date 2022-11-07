package icu.bughub.app.screenadaptivedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import icu.bughub.app.screenadaptivedemo.ui.theme.ScreenAdaptiveDemoTheme
import icu.bughub.kit.ScreenAdaption
import icu.bughub.kit.SizeType
import icu.bughub.kit.extension.saDp
import icu.bughub.kit.extension.saSp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenAdaptiveDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenAdaption(
                        designSize = Size(750.0F, 1334.0F),
                        sizeType = SizeType.DP
                    ) {
                        Greeting("Android")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "未适配", fontSize = 26.saSp)
        Divider()
        LazyRow {
            items(10) {
                Text(
                    text = "$it",
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(75.dp)
                        .height(75.dp)
                        .clip(CircleShape)
                        .background(Color(0, 255 - it, it * 25))
                )
            }
        }
        Divider()
        Text(text = "已适配", fontSize = 26.saSp)
        Divider()
        LazyRow {
            items(10) {
                Text(
                    text = "$it",
                    color = Color.Red,
                    fontSize = 14.saSp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(75.saDp)
                        .height(75.saDp)
                        .clip(CircleShape)
                        .background(Color(0, 255 - it, it * 25))
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScreenAdaptiveDemoTheme {
        Greeting("Android")
    }
}