package com.sargames.tiendasublime.data.models

//Funcionales futuras 
/**
 * Modelo de datos para representar un producto en la tienda
 * @property id Identificador único del producto
 * @property name Nombre del producto
 * @property price Precio del producto
 * @property description Descripción detallada del producto
 * @property imageUrl URL de la imagen del producto
 * @property category Categoría del producto
 * @property stock Cantidad disponible en inventario
 * @property isFavorite Indica si el producto está en favoritos
 */

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val imageUrl: String,
    val category: String = "",
    val stock: Int = 0,
    val isFavorite: Boolean = false
)

//enlace para pruebas productos
val imageUrl = "https://acortar.link/GBepD7"

/**
 * Lista de ejemplo de productos para pruebas
 */
val sampleProducts = listOf(
    Product(
        id = 1,
        name = "Producto 1",
        price = 29.99,
        description = "Descripción del producto 1",
        imageUrl = imageUrl,
        category = "Categoría 1",
        stock = 10
    ),
    Product(
        id = 2,
        name = "Producto 2",
        price = 39.99,
        description = "Descripción del producto 2",
        imageUrl = imageUrl,
        category = "Categoría 1",
        stock = 15
    ),
    Product(
        id = 3,
        name = "Producto 3",
        price = 49.99,
        description = "Descripción del producto 3",
        imageUrl = imageUrl,
        category = "Categoría 2",
        stock = 5
    ),
    Product(
        id = 4,
        name = "Producto 4",
        price = 59.99,
        description = "Descripción del producto 4",
        imageUrl = imageUrl,
        category = "Categoría 2",
        stock = 20
    ),
    Product(
        id = 5,
        name = "Producto 5",
        price = 69.99,
        description = "Descripción del producto 5",
        imageUrl = imageUrl,
        category = "Categoría 3",
        stock = 8
    ),
    Product(
        id = 6,
        name = "Producto 6",
        price = 79.99,
        description = "Descripción del producto 6",
        imageUrl = imageUrl,
        category = "Categoría 3",
        stock = 12
    )
) 