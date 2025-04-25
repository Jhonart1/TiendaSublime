package com.sargames.tiendasublime.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

enum class WindowSizeClass { Compact, Medium, Expanded }

//Funcion para obtener el tamaño de la pantalla en base a la pantalla del dispositivo

@Composable
fun rememberWindowSizeClass(): WindowSizeClass {
    //localConfiguration es una función que obtiene el ancho y alto de la pantalla del dispositivo
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp
    //se usa when para evaluar el ancho de la pantalla y devolver el tamaño de la pantalla 
    //en base a la pantalla del dispositivo
    return when { 
        screenWidthDp < 600.dp -> WindowSizeClass.Compact
        screenWidthDp < 840.dp -> WindowSizeClass.Medium
        else -> WindowSizeClass.Expanded
    }
} 