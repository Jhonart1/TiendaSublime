package com.sargames.tiendasublime.data.models

/**
 * Interfaz base para todas las tarjetas
 */
interface CardItem {
    val id: Int
    val title: String
    val imageUrl: String
}

/**
 * Modelo para tarjetas de catálogo
 */
data class CatalogCard(
    override val id: Int,
    override val title: String,
    override val imageUrl: String,
    val description: String,
    val category: String,
    val isSpecial: Boolean = false
) : CardItem

/**
 * Modelo para tarjetas de ofertas
 */
data class OfferCard(
    override val id: Int,
    override val title: String,
    override val imageUrl: String,
    val originalPrice: Double,
    val discountPrice: Double,
    val discountPercentage: Int,
    val validUntil: String
) : CardItem

/**
 * Modelo para tarjetas de productos
 */
data class ProductCard(
    override val id: Int,
    override val title: String,
    override val imageUrl: String,
) : CardItem

/**
 * Lista de ejemplo de tarjetas de catálogo
 */
val sampleCatalogCards = listOf(
    CatalogCard(
        id = 1,
        title = "Diseño de Boda",
        imageUrl = "https://acortar.link/GBepD7",
        description = "Colección especial para bodas",
        category = "Bodas",
        isSpecial = true
    ),
    CatalogCard(
        id = 2,
        title = "Diseño de Cumpleaños",
        imageUrl = "https://acortar.link/GBepD7",
        description = "Celebración de cumpleaños",
        category = "Cumpleaños"
    ),
    CatalogCard(
        id = 3,
        title = "Diseño de Graduación",
        imageUrl = "https://acortar.link/GBepD7",
        description = "Celebración de graduación",
        category = "Graduación",
        isSpecial = true
    )
)

/**
 * Lista de ejemplo de tarjetas de ofertas
 */
val sampleOfferCards = listOf(
    OfferCard(
        id = 1,
        title = "Oferta Especial",
        imageUrl = "https://acortar.link/GBepD7",
        originalPrice = 10000.0,
        discountPrice = 5000.0,
        discountPercentage = 50,
        validUntil = "2024-12-31"
    ),
    OfferCard(
        id = 2,
        title = "Descuento Flash",
        imageUrl = "https://acortar.link/GBepD7",
        originalPrice = 10000.0,
        discountPrice = 5000.0,
        discountPercentage = 50,
        validUntil = "2024-12-31"
    ),
    OfferCard(
        id = 3,
        title = "Oferta del Día",
        imageUrl = "https://acortar.link/GBepD7",
        originalPrice = 15000.0,
        discountPrice = 10000.0,
        discountPercentage = 33,
        validUntil = "2024-12-31"
    )
)

/**
 * Lista de ejemplo de tarjetas de productos
 */

val sampleProductCards = listOf(

    ProductCard(
        id = 1,
        title = "Tipo1",
        imageUrl = "https://acortar.link/GBepD7",
    ),
    ProductCard(
        id = 2,
        title = "Tipo2",
        imageUrl = "https://acortar.link/GBepD7",
    ),
    ProductCard(
        id = 3,
        title = "Tipo3",
        imageUrl = "https://acortar.link/GBepD7",
    ),
)