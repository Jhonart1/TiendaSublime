package com.sargames.tiendasublime.data.models

//Funcionales futuras se debe implementar la base de datos
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
) {
    companion object {
        // Categorías disponibles
        val CATEGORIES = listOf(
            "1",
            "2",
            "3",
            "4",
            "5"
        )

        // Rangos de precios
        val PRICE_RANGES = listOf(
            "Todos",
            "$0 - $5000",
            "$5000 - $10000",
            "$10000 - $20000",
            "$20000+"
        )

        // Opciones de ordenamiento
        val SORT_OPTIONS = listOf(
            "Relevancia",
            "Precio: Menor a Mayor",
            "Precio: Mayor a Menor",
            "Más Nuevos"
        )

        // Función para obtener el rango de precios de un producto
        fun getPriceRange(price: Double): String {
            return when {
                price <= 50 -> PRICE_RANGES[1]
                price <= 100 -> PRICE_RANGES[2]
                price <= 200 -> PRICE_RANGES[3]
                else -> PRICE_RANGES[4]
            }
        }
    }
}

//Enlace para pruebas productos
val imageUrl = "https://acortar.link/GBepD7"

/**
 * Lista de ejemplo de productos para pruebas 
 */
val sampleProducts = listOf(
    Product(
        id = 1,
        name = "Producto 1",
        price = 5000.0,
        description = "Descripción del producto 1",
        imageUrl = imageUrl,
        category = "1",
        stock = 10
    ),
    Product(
        id = 2,
        name = "Producto 2",
        price = 10000.0,
        description = "Descripción del producto 2",
        imageUrl = imageUrl,
        category = "2",
        stock = 15
    ),
    Product(
        id = 3,
        name = "Producto 3",
        price = 15000.0,
        description = "Descripción del producto 3",
        imageUrl = imageUrl,
        category = "3",
        stock = 5
    ),
    Product(
        id = 4,
        name = "Producto 4",
        price = 20000.0,
        description = "Descripción del producto 4",
        imageUrl = imageUrl,
        category = "4",
        stock = 20
    ),
    Product(
        id = 5,
        name = "Producto 5",
        price = 25000.0,
        description = "Descripción del producto 5",
        imageUrl = imageUrl,
        category = "Accesorios",
        stock = 8
    ),
    Product(
        id = 6,
        name = "Producto 6",
        price = 30000.0,
        description = "Descripción del producto 6",
        imageUrl = imageUrl,
        category = "5",
        stock = 12
    )
) 