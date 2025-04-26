package com.sargames.tiendasublime.ui.Activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.unit.dp
import com.sargames.tiendasublime.data.models.sampleProducts
import com.sargames.tiendasublime.data.models.Product
import com.sargames.tiendasublime.ui.components.BottomNavigationBar
import com.sargames.tiendasublime.ui.components.ProductCardSquare
import com.sargames.tiendasublime.ui.navigation.NavigationRoutes
import com.sargames.tiendasublime.ui.navigation.navigationItems
import com.sargames.tiendasublime.ui.theme.TiendaSublimeTheme
import com.sargames.tiendasublime.ui.theme.AppConstants

class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaSublimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SearchScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedTab by remember { mutableStateOf(1) }
    var showFilters by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf(Product.CATEGORIES[0]) }
    var selectedPriceRange by remember { mutableStateOf(Product.PRICE_RANGES[0]) }
    var selectedSortOption by remember { mutableStateOf(Product.SORT_OPTIONS[0]) }
    val context = LocalContext.current
    
    val categories = listOf("Todos", "Camisetas", "Pantalones", "Accesorios", "Zapatos")
    val priceRanges = listOf("Todos", "$0 - $50", "$50 - $100", "$100 - $200", "$200+")
    val sortOptions = listOf("Relevancia", "Precio: Menor a Mayor", "Precio: Mayor a Menor", "Más Nuevos")
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(AppConstants.Home.SEARCH_HINT) }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = { newTab -> 
                    selectedTab = newTab
                    when (navigationItems[newTab].route) {
                        NavigationRoutes.HOME -> {
                            context.startActivity(Intent(context, HomeActivity::class.java))
                        }
                        NavigationRoutes.CART -> {
                            context.startActivity(Intent(context, CartActivity::class.java))
                        }
                        NavigationRoutes.PROFILE -> {
                            context.startActivity(Intent(context, ProfileActivity::class.java))
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            // Barra de búsqueda y filtros
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Barra de búsqueda
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(AppConstants.Home.SEARCH_HINT) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = AppConstants.Home.SEARCH_HINT
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { showFilters = !showFilters }) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Filtros"
                            )
                        }
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline
                    )
                )
                
                // Panel de filtros
                if (showFilters) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = AppConstants.Home.FILTERS_TITLE,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                            
                            // Categoría
                            Text(
                                text = AppConstants.Home.CATEGORY_TITLE,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            FilterChips(
                                title = AppConstants.Home.CATEGORIES_TITLE,
                                options = Product.CATEGORIES,
                                selectedOption = selectedCategory,
                                onOptionSelected = { selectedCategory = it }
                            )
                            
                            Spacer(modifier = Modifier.height(16.dp))
                            
                            // Rango de precios
                            Text(
                                text = AppConstants.Home.PRICE_RANGE_TITLE,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            FilterChips(
                                title = AppConstants.Home.PRICE_RANGE_TITLE,
                                options = Product.PRICE_RANGES,
                                selectedOption = selectedPriceRange,
                                onOptionSelected = { selectedPriceRange = it }
                            )
                            
                            Spacer(modifier = Modifier.height(16.dp))
                            
                            // Ordenar por
                            Text(
                                text = AppConstants.Home.SORT_BY_TITLE,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            FilterChips(
                                title = AppConstants.Home.SORT_BY_TITLE,
                                options = Product.SORT_OPTIONS,
                                selectedOption = selectedSortOption,
                                onOptionSelected = { selectedSortOption = it }
                            )
                        }
                    }
                }
            }
            
            // Lista de productos en cuadrícula
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 160.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(sampleProducts) { product ->
                    ProductCardSquare(product = product)
                }
            }
        }
    }
}

@Composable
fun FilterChips(
    title: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(end = 8.dp)
        )
        options.forEach { option ->
            FilterChip(
                selected = option == selectedOption,
                onClick = { onOptionSelected(option) },
                label = { Text(option) },
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
} 