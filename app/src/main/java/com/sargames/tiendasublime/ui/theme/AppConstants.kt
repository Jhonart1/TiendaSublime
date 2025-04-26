package com.sargames.tiendasublime.ui.theme

object AppConstants {
    // Configuración general de la aplicación
    object AppConfig {
        const val APP_NAME = "Tienda"
        const val APP_NAME2 = "Sublime"
        const val APP_VERSION = "1.0.0"
        const val APP_LOGO = "ic_logo_s"
    }

    // Constantes para SplashActivity
    object Splash {
        const val SPLASH_LOGO = "splash_logo"
        const val SPLASH_BACKGROUND = "splash"
        const val SPLASH_DELAY = 3000L // 2 segundos
        const val WELCOME_MESSAGE = "Sublima tus ideas"
        const val LOADING_MESSAGE = "Calentando las Maquinas..."
    }

    // Constantes General
    object Home {
        const val HOME_TITLE = "Inicio"
        const val SEARCH_HINT = "Buscar productos..."
        const val OFFERS_TITLE = "Ofertas"
        const val SPECIAL_DAYS_TITLE = "Días Especiales"
        const val CART_TITLE = "Carrito"
        const val PROFILE_TITLE = "Perfil"
        const val FILTERS_TITLE = "Filtros"
        const val CATEGORY_TITLE = "Categoría"
        const val CATEGORIES_TITLE = "Categorías"
        const val PRICE_RANGE_TITLE = "Rango de Precios"
        const val SORT_BY_TITLE = "Ordenar por"
    }

    // Constantes para Productos ejemplos
    object Products {
        const val PRODUCTS_TITLE = "Productos"
        const val ADD_TO_CART = "Agregar al carrito"
        const val VIEW_DETAILS = "Ver detalles"
        const val PRICE_FORMAT = "$%.2f"
    }

    // Constantes para Carrito ejemplos 
    object Cart {
        const val CART_EMPTY = "Tu carrito está vacío"
        const val CHECKOUT = "Proceder al pago"
        const val REMOVE_ITEM = "Eliminar"
        const val UPDATE_QUANTITY = "Actualizar cantidad"
    }

    // Constantes para Perfil ejemplos
    object Profile {
        const val EDIT_PROFILE = "Editar perfil"
        const val MY_ORDERS = "Mis pedidos"
        const val SETTINGS = "Configuración"
        const val LOGOUT = "Cerrar sesión"
    }

    // Constantes para Autenticación ejemplos
    object Auth {
        const val LOGIN = "Iniciar sesión"
        const val REGISTER = "Registrarse"
        const val FORGOT_PASSWORD = "¿Olvidaste tu contraseña?"
        const val EMAIL_HINT = "Correo electrónico"
        const val PASSWORD_HINT = "Contraseña"
    }

    // Constantes para Mensajes ejemplos
    object Messages {
        const val SUCCESS = "Operación exitosa"
        const val ERROR = "Ha ocurrido un error"
        const val LOADING = "Cargando..."
        const val NO_INTERNET = "No hay conexión a internet"
    }
} 