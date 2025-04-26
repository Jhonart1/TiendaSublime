package com.sargames.tiendasublime.ui.Activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sargames.tiendasublime.data.models.sampleProducts
import com.sargames.tiendasublime.ui.components.BottomNavigationBar
import com.sargames.tiendasublime.ui.components.ProductCardHorizontal
import com.sargames.tiendasublime.ui.navigation.NavigationRoutes
import com.sargames.tiendasublime.ui.navigation.navigationItems
import com.sargames.tiendasublime.ui.theme.TiendaSublimeTheme
import java.text.NumberFormat
import java.util.*

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaSublimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CartScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {
    var selectedTab by remember { mutableStateOf(2) }
    val context = LocalContext.current
    
    // Simulación de productos en el carrito (tomando los primeros 3 productos como ejemplo)
    val cartItems = remember { sampleProducts.take(3) }
    val total = remember { cartItems.sumOf { it.price } }
    
    // Formateador de números para pesos colombianos
    val numberFormat = remember {
        NumberFormat.getCurrencyInstance(Locale("es", "CO")).apply {
            maximumFractionDigits = 0
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Barra superior
            TopAppBar(
                title = { Text("Mi Carrito") }
            )
            
            // Resumen del pedido
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Resumen del Pedido",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Subtotal")
                        Text(numberFormat.format(total))
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Envío")
                        Text("Gratis")
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Total", fontWeight = FontWeight.Bold)
                        Text(numberFormat.format(total), fontWeight = FontWeight.Bold)
                    }
                }
            }
            
            // Lista de productos en el carrito
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 120.dp)
            ) {
                items(cartItems) { product ->
                    ProductCardHorizontal(product = product)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
        
        // Botón de checkout
        Button(
            onClick = { /* Acción para proceder al pago */ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Proceder al Pago")
        }
        
        // Barra de navegación inferior
        BottomNavigationBar(
            selectedTab = selectedTab,
            onTabSelected = { newTab -> 
                selectedTab = newTab
                when (navigationItems[newTab].route) {
                    NavigationRoutes.HOME -> {
                        context.startActivity(Intent(context, HomeActivity::class.java))
                    }
                    NavigationRoutes.SEARCH -> {
                        context.startActivity(Intent(context, SearchActivity::class.java))
                    }
                    NavigationRoutes.PROFILE -> {
                        context.startActivity(Intent(context, ProfileActivity::class.java))
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
} 