package com.sargames.tiendasublime.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.graphics.vector.ImageVector
import com.sargames.tiendasublime.ui.navigation.NavigationRoutes

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)

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