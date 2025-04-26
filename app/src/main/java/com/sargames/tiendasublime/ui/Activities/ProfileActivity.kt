package com.sargames.tiendasublime.ui.Activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sargames.tiendasublime.ui.components.BottomNavigationBar
import com.sargames.tiendasublime.ui.navigation.NavigationRoutes
import com.sargames.tiendasublime.ui.navigation.navigationItems
import com.sargames.tiendasublime.ui.theme.AppColors
import com.sargames.tiendasublime.ui.theme.TiendaSublimeTheme
import androidx.compose.material3.ExperimentalMaterial3Api

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaSublimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    var selectedTab by remember { mutableStateOf(3) }
    val context = LocalContext.current
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Blanco)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Barra superior con gradiente
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(AppColors.AmarilloCalido)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    // Avatar con borde
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape)
                            .background(AppColors.Blanco)
                            .padding(4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                                .background(AppColors.CoralSuave)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Avatar",
                                modifier = Modifier
                                    .size(50.dp)
                                    .align(Alignment.Center),
                                tint = AppColors.Blanco
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(30.dp))
                    
                    // Nombre de usuario
                    Text(
                        text = "Usuario Ejemplo",
                        style = MaterialTheme.typography.headlineSmall,
                        color = AppColors.Gris,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Text(
                        text = "usuario@ejemplo.com",
                        style = MaterialTheme.typography.bodySmall,
                        color = AppColors.Gris
                    )
                }
            }
            
            // Opciones del perfil
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                
                Text(
                    text = "Mi Cuenta",
                    style = MaterialTheme.typography.titleLarge,
                    color = AppColors.Gris,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                ProfileOption(
                    icon = Icons.Default.ShoppingCart,
                    text = "Mis Pedidos",
                    color = AppColors.AmarilloCalido
                )
                
                ProfileOption(
                    icon = Icons.Default.Favorite,
                    text = "Favoritos",
                    color = AppColors.Naranja
                )
                
                ProfileOption(
                    icon = Icons.Default.Settings,
                    text = "Configuración",
                    color = AppColors.CoralSuave
                )
                
                Spacer(modifier = Modifier.weight(1f))
                
                // Botón de cerrar sesión
                Button(
                    onClick = { /* TODO: aqui se implementa cierre de sesión */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.Gris
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Cerrar sesión",
                            tint = AppColors.Blanco
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Cerrar Sesión",
                            color = AppColors.Blanco
                        )
                    }
                }
            }
        }
        
        // Barra de navegación inferior
        BottomNavigationBar(
            selectedTab = selectedTab,
            onTabSelected = { newTab -> 
                selectedTab = newTab
                val intent = when (navigationItems[newTab].route) {
                    NavigationRoutes.HOME -> Intent(context, HomeActivity::class.java)
                    NavigationRoutes.SEARCH -> Intent(context, SearchActivity::class.java)
                    NavigationRoutes.CART -> Intent(context, CartActivity::class.java)
                    NavigationRoutes.PROFILE -> Intent(context, ProfileActivity::class.java)
                    else -> null
                }
                intent?.let {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                    context.startActivity(it)
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@Composable
fun ProfileOption(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    color: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColors.Blanco
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = text,
                    tint = AppColors.Blanco
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                color = AppColors.Gris,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
} 