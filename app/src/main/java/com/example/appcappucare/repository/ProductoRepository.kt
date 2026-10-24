package com.example.appcappucare.repository

import com.example.appcappucare.data.local.dao.ProductoDao
import com.example.appcappucare.model.ProductoEntity
import kotlinx.coroutines.flow.Flow

class ProductoRepository(private val productoDao: ProductoDao) {

    val todosLosProductos: Flow<List<ProductoEntity>> = productoDao.obtenerTodosLosProductos()

    val productosStockBajo: Flow<List<ProductoEntity>> = productoDao.obtenerProductosConStockBajo()

    suspend fun insertarProducto(producto: ProductoEntity) {
        productoDao.insertarProducto(producto)
    }

    suspend fun actualizarProducto(producto: ProductoEntity) {
        productoDao.actualizarProducto(producto)
    }
}