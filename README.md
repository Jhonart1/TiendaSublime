# Tienda Sublime

Aplicación de comercio electrónico desarrollada en Kotlin con Jetpack Compose, enfocada en la venta de diseños y productos personalizados de Mugs o Tazas.

## 🚀 Características Implementadas

### Pantallas
- **Splash Screen**: Pantalla de carga inicial con animación
- **Home Screen**: Pantalla principal con múltiples secciones
  - Barra de búsqueda
  - Carruseles de productos
  - Navegación inferior
- **Cart**: Pantalla de  con múltiples secciones
  - Barra de búsqueda
  - Carruseles de productos
  - Navegación inferior

### Componentes
- **Tarjetas de Productos**: Muestra información detallada de productos
- **Tarjetas de Catálogo**: Muestra diseños y categorías
- **Tarjetas de Ofertas**: Muestra productos en oferta con descuentos
- **Barra de Navegación**: Navegación principal de la app

## 🏗️ Estructura del Proyecto

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/sargames/tiendasublime/
│   │   │   ├── data/
│   │   │   │   └── models/
│   │   │   │       ├── Product.kt
│   │   │   │       └── CardModels.kt
│   │   │   ├── ui/
│   │   │   │   ├── Activities/
│   │   │   │   │   ├── SplashActivity.kt
│   │   │   │   │   └── HomeActivity.kt
│   │   │   │   ├── components/
│   │   │   │   │   └── CardComponents.kt
│   │   │   │   └── theme/
│   │   │   │       ├── Color.kt
│   │   │   │       ├── Theme.kt
│   │   │   │       └── AppConstants.kt
|   |   |   |       └── Dimensions.kt
│   │   │   └── MainActivity.kt
│   │   └── res/
│   │       └── ...
```

## 🎨 Diseño y Estilo

### Paleta de Colores
```kotlin
object AppColors {
    val AmarilloCalido = Color(0xFFF9D576)
    val Naranja = Color(0xFFF9BA76)
    val CoralSuave = Color(0xFFF97376)
    val Gris = Color(0xFF333333)
}
```

### Control de Dimensiones
La aplicación implementa un sistema de dimensiones adaptativas para diferentes tamaños de pantalla:

```kotlin
object Dimensions {
    // Espaciado
    val spacingSmall = 8.dp
    val spacingMedium = 16.dp
    val spacingLarge = 24.dp
    val spacingXLarge = 32.dp

    // Tamaños de texto
    val textSizeSmall = 12.sp
    val textSizeMedium = 14.sp
    val textSizeLarge = 16.sp
    val textSizeXLarge = 20.sp
    val textSizeXXLarge = 24.sp

    // Márgenes
    val marginSmall = 8.dp
    val marginMedium = 16.dp
    val marginLarge = 24.dp

    // Tamaños de componentes
    val cardWidth = 200.dp
    val cardHeight = 120.dp
    val searchBarHeight = 56.dp
    val navigationBarHeight = 80.dp
}
```

#### Adaptación a Tamaños de Pantalla
```kotlin
enum class WindowSizeClass {
    Compact,    // Teléfonos
    Medium,     // Tablets
    Expanded    // Pantallas grandes
}

fun getAdaptiveDimensions(windowSizeClass: WindowSizeClass): Dimensions {
    return when (windowSizeClass) {
        WindowSizeClass.Compact -> {
            // Dimensiones para teléfonos
            Dimensions(
                cardWidth = 160.dp,
                textSize = 14.sp
            )
        }
        WindowSizeClass.Medium -> {
            // Dimensiones para tablets
            Dimensions(
                cardWidth = 200.dp,
                textSize = 16.sp
            )
        }
        WindowSizeClass.Expanded -> {
            // Dimensiones para pantallas grandes
            Dimensions(
                cardWidth = 240.dp,
                textSize = 18.sp
            )
        }
    }
}
```

### Fuente Personalizada
- **Alegreya SC**: Fuente principal de la aplicación
- Implementada en `Type.kt` para toda la aplicación
- Estilos de texto adaptables según el tamaño de pantalla

### Constantes Centralizadas
Todas las cadenas de texto y valores constantes están centralizados en `AppConstants.kt`:

```kotlin
object AppConstants {
    // Configuración general
    object AppConfig {
        const val APP_NAME = "Tienda"
        const val APP_NAME2 = "Sublime"
    }

    // Splash Screen
    object Splash {
        const val WELCOME_MESSAGE = "Sublima tus ideas"
        const val LOADING_MESSAGE = "Calentando las Maquinas..."
    }

    // Home Screen
    object Home {
        const val HOME_TITLE = "Inicio"
        const val SEARCH_HINT = "Buscar productos..."
        const val OFFERS_TITLE = "Ofertas"
        const val SPECIAL_DAYS_TITLE = "Días Especiales"
    }

    // Productos
    object Products {
        const val PRODUCTS_TITLE = "Productos"
        const val ADD_TO_CART = "Agregar al carrito"
        const val PRICE_FORMAT = "$%.2f"
    }
}
```

## 📦 Modelos de Datos

//Se usaran a Futuro para llamar desde API
### Product
```kotlin
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
```

### CardItem (Interfaz Base)
```kotlin
interface CardItem {
    val id: Int
    val title: String
    val imageUrl: String
}
```

### CatalogCard
```kotlin
data class CatalogCard(
    override val id: Int,
    override val title: String,
    override val imageUrl: String,
    val description: String,
    val category: String,
    val isSpecial: Boolean = false
) : CardItem
```

### OfferCard
```kotlin
data class OfferCard(
    override val id: Int,
    override val title: String,
    override val imageUrl: String,
    val originalPrice: Double,
    val discountPrice: Double,
    val discountPercentage: Int,
    val validUntil: String
) : CardItem
```

## 🎨 Componentes UI

### CatalogCardItem
- Muestra diseños y categorías
- Color especial para días especiales
- Imagen, título, descripción y categoría

### OfferCardItem
- Muestra ofertas y descuentos
- Precio original y con descuento
- Porcentaje de descuento
- Fecha de validez

## 🛠️ Tecnologías Utilizadas

- **Kotlin**: Lenguaje principal
- **Jetpack Compose**: UI moderna y declarativa
- **Coil**: Carga eficiente de imágenes
- **Material Design 3**: Sistema de diseño
- **Lottie**: Animaciones  //Nada implementado aun

## 📱 Pantallas Implementadas

### SplashActivity
- Pantalla de carga inicial
- Redirección automática al Home

### HomeActivity
- Barra de búsqueda fija
- Carruseles horizontales:
  - Ofertas
  - Diseños
  - Días Especiales
- Barra de navegación inferior

## 🚀 Próximos Pasos


## 📦 Dependencias Principales

```gradle
dependencies {
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation("com.airbnb.android:lottie-compose:6.3.0")
}
```

## 🔧 Configuración

1. Clonar el repositorio
2. Abrir en Android Studio
3. Sincronizar Gradle
4. Ejecutar la aplicación

## 📝 Notas de Desarrollo

- La aplicación sigue la arquitectura MVVM
- Los componentes están diseñados para ser reutilizables
- Se utiliza Coil para la carga eficiente de imágenes
- Los colores y temas están centralizados en `AppColors`
- Todas las cadenas de texto están en `AppConstants`
- La fuente Alegreya SC se aplica globalmente
- Diseño responsive con adaptación a diferentes tamaños de pantalla
- Sistema de dimensiones adaptativas para diferentes dispositivos
- Control de espaciado y márgenes consistente
- Tamaños de texto escalables según el dispositivo

## 📄 Licencia

