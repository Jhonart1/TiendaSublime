package com.sargames.tiendasublime.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sargames.tiendasublime.data.models.ProductCard
import com.sargames.tiendasublime.ui.theme.AppColors

@Composable
fun ProductCardItem(product: ProductCard) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColors.AmarilloCalido
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = product.title,
                style = MaterialTheme.typography.titleMedium,
                color = AppColors.Gris
            )
        }
    }
} 