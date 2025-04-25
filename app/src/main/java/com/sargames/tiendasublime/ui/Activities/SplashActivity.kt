package com.sargames.tiendasublime.ui.Activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sargames.tiendasublime.R
import com.sargames.tiendasublime.ui.theme.AppColors
import com.sargames.tiendasublime.ui.theme.AppConstants
import com.sargames.tiendasublime.ui.theme.TiendaSublimeTheme
import com.sargames.tiendasublime.ui.theme.WindowSizeClass
import com.sargames.tiendasublime.ui.theme.rememberWindowSizeClass
import kotlinx.coroutines.delay
import com.sargames.tiendasublime.ui.theme.getAdaptiveDimensions
import com.sargames.tiendasublime.ui.theme.AlegreyaSc

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaSublimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen(
                        onSplashFinished = {
                            startActivity(Intent(this, HomeActivity::class.java))
                            finish()
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    val windowSizeClass = rememberWindowSizeClass()
    val dimensions = getAdaptiveDimensions()
    
    val titleSize = when (windowSizeClass) {
        WindowSizeClass.Compact -> dimensions.textSizeXXLarge * 1.5f
        WindowSizeClass.Medium -> dimensions.textSizeXXLarge * 3f
        WindowSizeClass.Expanded -> dimensions.textSizeXXLarge * 1.7f
        else -> dimensions.textSizeXXLarge
    }
    
    val subtitleSize = when (windowSizeClass) {
        WindowSizeClass.Compact -> dimensions.textSizeLarge
        WindowSizeClass.Medium -> dimensions.textSizeXXLarge
        WindowSizeClass.Expanded -> dimensions.textSizeXXLarge * 1.2f
        else -> dimensions.textSizeLarge
    }
    
    val animationSize = when (windowSizeClass) {
        WindowSizeClass.Compact -> 200.dp
        WindowSizeClass.Medium -> 300.dp
        WindowSizeClass.Expanded -> 400.dp
        else -> 200.dp
    }
    
    val spacing = when (windowSizeClass) {
        WindowSizeClass.Compact -> dimensions.spacingLarge
        WindowSizeClass.Medium -> dimensions.spacingXLarge
        WindowSizeClass.Expanded -> dimensions.spacingXLarge * 2
        else -> dimensions.spacingLarge
    }

    //Contenedor principal
    Box(
        modifier = Modifier.fillMaxSize()
        .background(AppColors.Naranja)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensions.marginMedium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Sección superior
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = AppConstants.Splash.WELCOME_MESSAGE,
                        style = MaterialTheme.typography.bodyLarge,
                        color = AppColors.Gris
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(

                        text = AppConstants.AppConfig.APP_NAME,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = 60.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = AppColors.Gris,
                        letterSpacing = 10.sp
                    )
                    Text(
                        text = AppConstants.AppConfig.APP_NAME2,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = 60.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                        color = AppColors.Gris,
                        letterSpacing = 10.sp
                    )
                }


            }

            Spacer(modifier = Modifier.height(spacing))

            // Sección inferior: Animación Lottie
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    
                    // Ejemplo de texto normal (bodyLarge)
                    Text(
                        text = AppConstants.Splash.LOADING_MESSAGE,
                        style = MaterialTheme.typography.bodyLarge,
                        color = AppColors.Gris
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Image(
                        painter = painterResource(id = R.drawable.splash),
                        contentDescription = "Splash Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                    )
                }
            }
        }
        //Delay y fin de la pantalla de splash
        LaunchedEffect(key1 = true) {
            delay(AppConstants.Splash.SPLASH_DELAY)
            onSplashFinished()
        }
    }
}

@Composable
fun SplashScreenPreview() {
    TiendaSublimeTheme {
        SplashScreen(onSplashFinished = {})
    }
} 