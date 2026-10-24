package com.example.appcappucare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.appcappucare.data.local.AppDatabase
import com.example.appcappucare.repository.ProductoRepository
import com.example.appcappucare.ui.AppNavigation
import com.example.appcappucare.ui.theme.AppCappucareTheme
import com.example.appcappucare.viewmodel.ProductoViewModel
import com.example.appcappucare.viewmodel.ProductoViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar Room y Repositorio
        val database = AppDatabase.getDatabase(applicationContext)
        val repository = ProductoRepository(database.productoDao())
        val factory: ProductoViewModelFactory = ProductoViewModelFactory(repository)
        val viewModel: ProductoViewModel by viewModels { factory }

        setContent {
            AppCappucareTheme {
                AppNavigation(viewModel = viewModel)
            }
        }
    }
}