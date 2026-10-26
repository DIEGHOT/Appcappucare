package com.example.appcappucare.repository

import com.example.appcappucare.data.local.ProductoDao
import com.example.appcappucare.model.ProductoEntity
import kotlinx.coroutines.flow.Flow

class ProductoRepository(private val productoDao: ProductoDao) {

    // Llama exactamente a la función obtenerTodos() del DAO
    val todosLosProductos: Flow<List<ProductoEntity>> = productoDao.obtenerTodos()

    // Llama exactamente a la función insertar() del DAO
    suspend fun insertarProducto(producto: ProductoEntity) {
        productoDao.insertar(producto)
    }

    // Llama exactamente a la función eliminar() del DAO
    suspend fun eliminarProducto(producto: ProductoEntity) {
        productoDao.eliminar(producto)
    }
}