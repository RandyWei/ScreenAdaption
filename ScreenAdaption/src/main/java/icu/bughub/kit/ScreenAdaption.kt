package icu.bughub.kit

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import icu.bughub.kit.util.ScreenUtil
import icu.bughub.kit.SizeType

@Composable
fun ScreenAdaption(
    designSize: Size = Size(750.0F, 1334.0F),
    sizeType: SizeType = SizeType.PX,
    content: @Composable () -> Unit
) {

    var screenWith: Float
    var screenHeight: Float
    var density1: Float? = null

    with(LocalConfiguration.current) {
        screenWith = screenWidthDp.toFloat()
        screenHeight = screenHeightDp.toFloat()
        with(LocalDensity.current) {
            Log.i("ScreenAdaption", "$fontScale")
            if (sizeType == SizeType.PX) {
                screenWith = screenWidthDp.dp.toPx()
                screenHeight = screenHeightDp.dp.toPx()
                density1 = density
            }
        }
    }

    Log.i("ScreenAdaption", "$screenWith")
    Log.i("ScreenAdaption", "$screenHeight")

    ScreenUtil.init(
        designSize = designSize,
        sizeType = sizeType,
        screenSize = Size(screenWith, screenHeight),
        density = density1
    )

    content()
}