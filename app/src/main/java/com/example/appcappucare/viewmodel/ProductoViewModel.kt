package com.example.appcappucare.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcappucare.model.ProductoEntity
import com.example.appcappucare.repository.ProductoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProductoViewModel(private val repository: ProductoRepository) : ViewModel() {

    val todosLosProductos: StateFlow<List<ProductoEntity>> = repository.todosLosProductos
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun agregarProducto(codigo: String, nombre: String, categoria: String, cantidad: Int, minimo: Int) {
        val nuevoProducto = ProductoEntity(
            codigo = codigo,
            nombre = nombre,
            descripcion = "",
            categoria = categoria,
            cantidadDisponible = cantidad,
            unidadMedida = "Unidad",
            nivelMinimo = minimo,
            ubicacion = "Almacén Principal",
            estado = "Activo"
        )
        viewModelScope.launch {
            repository.insertarProducto(nuevoProducto)
        }
    }
}