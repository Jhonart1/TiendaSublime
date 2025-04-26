package com.sargames.tiendasublime.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sargames.tiendasublime.data.models.CatalogCard
import com.sargames.tiendasublime.data.models.OfferCard
import com.sargames.tiendasublime.ui.theme.AppColors

@Composable
fun CatalogCardItem(card: CatalogCard) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (card.isSpecial) AppColors.AmarilloCalido else AppColors.AmarilloCalido
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Imagen del catálogo
            AsyncImage(
                model = card.imageUrl,
                contentDescription = card.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = card.title,
                style = MaterialTheme.typography.titleMedium,
                color = AppColors.Gris
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = card.description,
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.Gris,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = card.category,
                style = MaterialTheme.typography.labelMedium,
                color = AppColors.CoralSuave
            )
        }
    }
}

@Composable
fun OfferCardItem(card: OfferCard) {
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
            // Imagen de la oferta
            AsyncImage(
                model = card.imageUrl,
                contentDescription = card.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = card.title,
                style = MaterialTheme.typography.titleMedium,
                color = AppColors.Gris
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            // Precios
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$${card.discountPrice}",
                    style = MaterialTheme.typography.titleLarge,
                    color = AppColors.CoralSuave
                )
                
                Text(
                    text = "-${card.discountPercentage}%",
                    style = MaterialTheme.typography.labelLarge,
                    color = AppColors.CoralSuave
                )
            }
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = "Antes: $${card.originalPrice}",
                style = MaterialTheme.typography.bodySmall,
                color = AppColors.Gris
            )
            
            Text(
                text = "Válido hasta: ${card.validUntil}",
                style = MaterialTheme.typography.bodySmall,
                color = AppColors.Gris
            )
        }
    }
} 