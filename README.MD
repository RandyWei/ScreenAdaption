### Jetpack Compose 屏幕适配方案

## 配置

[![](https://jitpack.io/v/RandyWei/ScreenAdaption.svg)](https://jitpack.io/#RandyWei/ScreenAdaption)

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
```groovy
dependencies {
	        implementation 'com.github.RandyWei:ScreenAdaption:Tag'
	}
```

## 用法

```kotlin
//在主入口处使用 ScreenAdaption 组件，配置设计图尺寸，以及 sizeType确保全程使用的尺寸统一
ScreenAdaption(
    designSize = Size(750.0F, 1334.0F),
    sizeType = SizeType.DP
) {
    ...
}

```

尺寸用法如下

```kotlin
Text(
    text = "这是一段文字",
    fontSize = 14.saSp, //设置字段大小使用.saSp
    modifier = Modifier
        .width(75.saDp) //设置宽高使用.saDp
        .height(75.saDp)
)
```