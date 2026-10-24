package com.example.appcappucare.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
data class ProductoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val codigo: String,
    val nombre: String,
    val descripcion: String,
    val categoria: String,
    val cantidadDisponible: Int,
    val unidadMedida: String,
    val nivelMinimo: Int,
    val ubicacion: String,
    val estado: String
)