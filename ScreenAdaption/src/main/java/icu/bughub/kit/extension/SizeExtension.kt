package icu.bughub.kit.extension

import androidx.compose.ui.unit.*
import icu.bughub.kit.util.ScreenUtil

val Int.saSp: TextUnit get() = ScreenUtil.convert(this).sp

val Float.saSp: TextUnit get() = ScreenUtil.convert(this).sp

val Double.saSp: TextUnit get() = ScreenUtil.convert(this).sp

val Int.saDp: Dp get() = Dp(value = ScreenUtil.convert(this))

val Float.saDp: Dp get() = Dp(value = ScreenUtil.convert(this))

val Double.saDp: Dp get() = Dp(value = ScreenUtil.convert(this))
