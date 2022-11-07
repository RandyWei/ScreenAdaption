package icu.bughub.kit.util

import androidx.compose.ui.geometry.Size
import icu.bughub.kit.SizeType

internal object ScreenUtil {

    private var designSize: Size? = null
    private var sizeType: SizeType = SizeType.PX
    private var screenSize: Size? = null
    private var density: Float? = null

    private var scaleRatioForWidth: Float = 1f
    private var scaleRatioForHeight: Float = 1f

    fun init(designSize: Size, sizeType: SizeType, screenSize: Size, density: Float?) {
        ScreenUtil.designSize = designSize
        ScreenUtil.sizeType = sizeType
        ScreenUtil.screenSize = screenSize
        ScreenUtil.density = density

        scaleRatioForWidth = screenSize.width / designSize.width
        scaleRatioForHeight = screenSize.height / designSize.height
    }

    fun convert(num: Int): Float {
        return convert(num.toFloat())
    }

    fun convert(num: Float): Float {
        if (sizeType == SizeType.PX && density != null) {
            return num * scaleRatioForWidth / density!!
        }
        return num * scaleRatioForWidth
    }

    fun convert(num: Double): Float {
        return convert(num.toFloat())
    }

}