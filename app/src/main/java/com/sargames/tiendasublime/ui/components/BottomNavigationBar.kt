package com.sargames.tiendasublime.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.sargames.tiendasublime.ui.navigation.navigationItems
import com.sargames.tiendasublime.ui.navigation.NavigationRoutes
import com.sargames.tiendasublime.ui.theme.AppColors

/**
 * Modelo de datos para los items de la barra de navegación
 */
data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)

/**
 * Lista de items de navegación
 */
val navigationItems = listOf(
    NavigationItem(
        title = "Inicio",
        icon = Icons.Default.Home,
        route = NavigationRoutes.HOME
    ),
    NavigationItem(
        title = "Buscar",
        icon = Icons.Default.Search,
        route = NavigationRoutes.SEARCH
    ),
    NavigationItem(
        title = "Carrito",
        icon = Icons.Default.ShoppingCart,
        route = NavigationRoutes.CART
    ),
    NavigationItem(
        title = "Perfil",
        icon = Icons.Default.Person,
        route = NavigationRoutes.PROFILE
    )
)

/**
 * Componente de barra de navegación inferior reutilizable
 */
@Composable
fun BottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
            .background(Color.White)
            .height(80.dp),
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedTab == index,
                onClick = { onTabSelected(index) },
                icon = { 
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AppColors.CoralSuave,
                    selectedTextColor = AppColors.CoralSuave,
                    unselectedIconColor = AppColors.Gris,
                    unselectedTextColor = AppColors.Gris
                )
            )
        }
    }
} 