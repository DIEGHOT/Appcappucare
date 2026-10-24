package com.example.appcappucare.ui

import com.example.appcappucare.viewmodel.ProductoViewModel

class AppNavigation(viewModel: ProductoViewModel) {
    package com.example.appcappucare.ui
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import androidx.compose.runtime.Composable
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import com.example.appcappucare.viewmodel.ProductoViewModel

    @Composable
    fun AppNavigation(viewModel: ProductoViewModel) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "lista") {
            composable("lista") {
                ProductListScreen(
                    viewModel = viewModel,
                    onNavigateToAdd = { navController.navigate("formulario") }
                )
            }
            composable("formulario") {
                // Modificaremos levemente HomeScreen para que pueda volver atrás
                HomeScreen(
                    viewModel = viewModel,
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}