package com.sargames.tiendasublime.ui.Activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sargames.tiendasublime.data.models.Product
import com.sargames.tiendasublime.data.models.sampleProducts
import com.sargames.tiendasublime.data.models.sampleCatalogCards
import com.sargames.tiendasublime.data.models.sampleOfferCards
import com.sargames.tiendasublime.ui.components.CatalogCardItem
import com.sargames.tiendasublime.ui.components.OfferCardItem
import com.sargames.tiendasublime.ui.theme.AppColors
import com.sargames.tiendasublime.ui.theme.TiendaSublimeTheme
import com.sargames.tiendasublime.ui.theme.AppConstants

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaSublimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Sección fija superior
            TopBar()
            SearchBar()
            
            // Contenido scrolleable
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp) // Espacio para la barra de navegación
            ) {
                item {
                    MainContent()
                }
            }
        }
        
        // Barra de navegación fija en la parte inferior
        BottomNavigation(
            selectedTab = selectedTab,
            onTabSelected = { newTab -> selectedTab = newTab },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@Composable
fun TopBar() {
    Spacer(modifier = Modifier.height(40.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        
        Text(
            text = AppConstants.Home.HOME_TITLE,
            style = MaterialTheme.typography.titleLarge,
            color = AppColors.CoralSuave
        )
    }
}

@Composable
fun SearchBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        color = Color.White,
        shadowElevation = 16.dp
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text("Buscar productos...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Configuración de búsqueda"
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AppColors.CoralSuave,
                unfocusedBorderColor = AppColors.Gris
            )
        )
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Sección de Ofertas
        Text(
            text = "Ofertas",
            style = MaterialTheme.typography.titleMedium,
            color = AppColors.CoralSuave
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sampleOfferCards) { offer ->
                OfferCardItem(offer)
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Sección de Catálogo
        Text(
            text = "Diseños",
            style = MaterialTheme.typography.titleMedium,
            color = AppColors.CoralSuave
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sampleCatalogCards) { catalog ->
                CatalogCardItem(catalog)
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Sección de Días Especiales
        Text(
            text = "Días Especiales",
            style = MaterialTheme.typography.titleMedium,
            color = AppColors.CoralSuave
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sampleCatalogCards.filter { it.isSpecial }) { special ->
                CatalogCardItem(special)
            }
        }
    }
}

@Composable
fun ProductCardHorizontal(product: Product) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColors.AmarilloCalido
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Imagen del producto
            //Usando coil para cargar la imagen
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium,
                color = AppColors.Gris
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = product.description,
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.Gris,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.titleLarge,
                color = AppColors.CoralSuave
            )
        }
    }
}

//barra de navegacion con sus iconos y texto
@Composable
fun BottomNavigation(
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
        NavigationBarItem(
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AppColors.CoralSuave,
                selectedTextColor = AppColors.CoralSuave,
                unselectedIconColor = AppColors.Gris,
                unselectedTextColor = AppColors.Gris
            )
        )
        NavigationBarItem(
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            icon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
            label = { Text("Buscar") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AppColors.CoralSuave,
                selectedTextColor = AppColors.CoralSuave,
                unselectedIconColor = AppColors.Gris,
                unselectedTextColor = AppColors.Gris
            )
        )
        NavigationBarItem(
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) },
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito") },
            label = { Text("Carrito") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AppColors.CoralSuave,
                selectedTextColor = AppColors.CoralSuave,
                unselectedIconColor = AppColors.Gris,
                unselectedTextColor = AppColors.Gris
            )
        )
        NavigationBarItem(
            selected = selectedTab == 3,
            onClick = { onTabSelected(3) },
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AppColors.CoralSuave,
                selectedTextColor = AppColors.CoralSuave,
                unselectedIconColor = AppColors.Gris,
                unselectedTextColor = AppColors.Gris
            )
        )
    }
} 