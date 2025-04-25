package com.sargames.tiendasublime.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

interface IDimensions {
    val spacingTiny: Dp
    val spacingSmall: Dp
    val spacingMedium: Dp
    val spacingLarge: Dp
    val spacingXLarge: Dp

    val textSizeSmall: TextUnit
    val textSizeMedium: TextUnit
    val textSizeLarge: TextUnit
    val textSizeXLarge: TextUnit
    val textSizeXXLarge: TextUnit

    val buttonHeight: Dp
    val inputHeight: Dp
    val toolbarHeight: Dp

    val marginSmall: Dp
    val marginMedium: Dp
    val marginLarge: Dp

    val cornerRadiusSmall: Dp
    val cornerRadiusMedium: Dp
    val cornerRadiusLarge: Dp
}

object Dimensions : IDimensions {
    // Dimensiones generales
    override val spacingTiny = 4.dp
    override val spacingSmall = 8.dp
    override val spacingMedium = 16.dp
    override val spacingLarge = 24.dp
    override val spacingXLarge = 32.dp

    // Tamaños de texto
    override val textSizeSmall = 12.sp
    override val textSizeMedium = 16.sp
    override val textSizeLarge = 18.sp
    override val textSizeXLarge = 20.sp
    override val textSizeXXLarge = 24.sp

    // Alturas de componentes
    override val buttonHeight = 48.dp
    override val inputHeight = 56.dp
    override val toolbarHeight = 56.dp

    // Márgenes y padding
    override val marginSmall = 8.dp
    override val marginMedium = 16.dp
    override val marginLarge = 24.dp

    // Radios de bordes
    override val cornerRadiusSmall = 4.dp
    override val cornerRadiusMedium = 8.dp
    override val cornerRadiusLarge = 12.dp
}

@Composable
fun getAdaptiveDimensions(): IDimensions {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    return when {
        screenWidth >= 600 -> TabletDimensions
        else -> Dimensions
    }
}

object TabletDimensions : IDimensions {
    // Dimensiones generales para tablets
    override val spacingTiny = 8.dp
    override val spacingSmall = 16.dp
    override val spacingMedium = 24.dp
    override val spacingLarge = 32.dp
    override val spacingXLarge = 48.dp

    // Tamaños de texto para tablets
    override val textSizeSmall = 12.sp
    override val textSizeMedium = 14.sp
    override val textSizeLarge = 16.sp
    override val textSizeXLarge = 22.sp
    override val textSizeXXLarge = 28.sp

    // Alturas de componentes para tablets
    override val buttonHeight = 56.dp
    override val inputHeight = 64.dp
    override val toolbarHeight = 64.dp

    // Márgenes y padding para tablets
    override val marginSmall = 16.dp
    override val marginMedium = 24.dp
    override val marginLarge = 32.dp

    // Radios de bordes para tablets
    override val cornerRadiusSmall = 8.dp
    override val cornerRadiusMedium = 12.dp
    override val cornerRadiusLarge = 16.dp
} 