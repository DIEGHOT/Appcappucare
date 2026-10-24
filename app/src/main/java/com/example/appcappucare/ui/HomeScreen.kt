package com.example.appcappucare.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.appcappucare.viewmodel.ProductoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: ProductoViewModel, onNavigateBack: () -> Unit = {}) {
    var codigo by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }
    var nivelMinimo by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf("") }
    var mostrarEscaner by remember { mutableStateOf(false) }

    if (mostrarEscaner) {
        BarcodeScannerScreen(onBarcodeScanned = { valorEscaneado ->
            codigo = valorEscaneado
            mostrarEscaner = false
        })
    } else {
        Scaffold(
            topBar = { TopAppBar(title = { Text("Registrar Insumo - Cappucare") }) }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = codigo,
                        onValueChange = { codigo = it },
                        label = { Text("Código") },
                        modifier = Modifier.weight(1f)
                    )
                    Button(
                        onClick = { mostrarEscaner = true },
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text("Escanear")
                    }
                }

                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = categoria,
                    onValueChange = { categoria = it },
                    label = { Text("Categoría") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = cantidad,
                    onValueChange = { cantidad = it },
                    label = { Text("Cantidad") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = nivelMinimo,
                    onValueChange = { nivelMinimo = it },
                    label = { Text("Nivel Mínimo") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                if (mensajeError.isNotEmpty()) {
                    Text(text = mensajeError, color = MaterialTheme.colorScheme.error)
                }

                Button(
                    onClick = {
                        val cantInt = cantidad.toIntOrNull()
                        val minInt = nivelMinimo.toIntOrNull()

                        if (codigo.isBlank() || nombre.isBlank() || categoria.isBlank()) {
                            mensajeError = "Completa todos los campos de texto."
                        } else if (cantInt == null || cantInt <= 0) {
                            mensajeError = "Ingresa una cantidad válida mayor a 0."
                        } else if (minInt == null || minInt < 0) {
                            mensajeError = "Ingresa un nivel mínimo válido."
                        } else {
                            mensajeError = ""
                            viewModel.agregarProducto(codigo, nombre, categoria, cantInt, minInt)
                            codigo = ""; nombre = ""; categoria = ""; cantidad = ""; nivelMinimo = ""
                            onNavigateBack()
                        }
                    },
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
                ) {
                    Text("Guardar Insumo")
                }
            }
        }
    }
}