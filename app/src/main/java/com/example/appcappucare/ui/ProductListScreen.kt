package com.example.appcappucare.ui

    import androidx.compose.foundation.lazy.items
    import androidx.compose.runtime.collectAsState
    import androidx.compose.runtime.getValue
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.Add
    import androidx.compose.material3.*
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.unit.dp
    import com.example.appcappucare.viewmodel.ProductoViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ProductListScreen(viewModel: ProductoViewModel, onNavigateToAdd: () -> Unit) {
        // Recolectamos el estado del flujo de datos
        val productos by viewModel.todosLosProductos.collectAsState()

        Scaffold(
            topBar = { TopAppBar(title = { Text("Inventario Cappucare") }) },
            floatingActionButton = {
                FloatingActionButton(onClick = onNavigateToAdd) {
                    Icon(Icons.Filled.Add, contentDescription = "Agregar Insumo")
                }
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(productos) { producto ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = producto.nombre, style = MaterialTheme.typography.titleMedium)
                            Text(text = "Código: ${producto.codigo} | Categoría: ${producto.categoria}")
                            Text(text = "Stock: ${producto.cantidadDisponible} | Mínimo: ${producto.nivelMinimo}")
                        }
                    }
                }
            }
        }
    }
