Descripción del Proyecto
Define a Cappucare como una aplicación móvil de gestión de inventarios que permite registrar, visualizar y administrar productos de forma eficiente y persistente.

Características Principales
Destaca el escaneo de códigos de barras en tiempo real, la validación de formularios (como evitar cantidades negativas o campos vacíos), la navegación con animaciones de transición y la actualización automática de la lista de productos.

Stack Tecnológico y Arquitectura
Menciona que la app está desarrollada en Kotlin utilizando Jetpack Compose para la interfaz gráfica. Subraya la implementación del patrón MVVM para proteger la lógica del diseño visual, Room Database para guardar los datos localmente, y la integración de CameraX junto a ML Kit para acceder al hardware del teléfono.

Instrucciones de Ejecución
Aclara que para probar todas las funcionalidades correctamente (especialmente el escáner de la cámara), el proyecto debe clonarse, abrirse en Android Studio y compilarse exclusivamente en un dispositivo Android físico con la depuración por USB activada.

# Cappucare 📦

Cappucare es una aplicación móvil nativa de gestión de inventarios para Android. Permite a los usuarios registrar, visualizar y administrar productos de forma eficiente, asegurando la persistencia de datos y utilizando hardware del dispositivo para agilizar el ingreso.

## 🚀 Características Principales

* **Escaneo de Códigos de Barras:** Integración de la cámara para leer códigos de productos en tiempo real, agilizando el llenado de formularios.
* **Validación de Datos:** Lógica de control para evitar campos vacíos o el ingreso de cantidades negativas.
* **Navegación Fluida:** Transiciones animadas entre pantallas para mejorar la experiencia de usuario (UX).
* **Actualización en Tiempo Real:** La lista de inventario reacciona automáticamente a los nuevos ingresos gracias al uso de flujos de datos (Flow).

## 🛠️ Stack Tecnológico y Arquitectura

El proyecto fue desarrollado cumpliendo estrictos estándares técnicos:

* **Lenguaje:** Kotlin
* **Interfaz de Usuario (UI):** Jetpack Compose
* **Arquitectura:** MVVM (Model-View-ViewModel) para separar la lógica de negocio de la interfaz gráfica y proteger el estado ante cambios de configuración.
* **Base de Datos Local:** Room Database (SQLite) para garantizar la persistencia de los datos del inventario.
* **Hardware y Machine Learning:** CameraX y Google ML Kit para el procesamiento de imágenes y lectura de códigos de barras sin necesidad de conexión a internet.

## 📱 Instrucciones de Prueba y Ejecución

Para evaluar correctamente todas las funcionalidades de esta aplicación (especialmente el acceso al hardware):

1. Clona este repositorio.
2. Abre el proyecto en **Android Studio**.
3. Sincroniza los archivos de Gradle.
4. Conecta un **dispositivo Android físico** mediante USB (asegúrate de tener activada la depuración por USB en las opciones de desarrollador).
5. Ejecuta la aplicación (Run) en el dispositivo físico, ya que el emulador no soporta de forma nativa la lectura fluida de códigos de barras con la cámara real.
