# Configuración de JavaFX para el proyecto

## Pasos para configurar JavaFX en IntelliJ IDEA:

### 1. Descargar JavaFX
- Ve a https://openjfx.io/
- Descarga JavaFX SDK (versión 11 o superior)
- Extrae el archivo en una carpeta conocida (ej: C:\javafx\javafx-sdk-21)

### 2. Configurar las librerías del proyecto
1. Ve a File → Project Structure (Ctrl+Alt+Shift+S)
2. En Libraries → + → Java
3. Navega hasta la carpeta lib de JavaFX SDK
4. Selecciona todos los archivos JAR
5. Aplica los cambios

### 3. Configurar VM Options para ejecución
1. Ve a Run → Edit Configurations
2. Selecciona o crea una configuración para PilaGUI
3. En VM options, agrega:
```
--module-path "C:\ruta\a\javafx\lib" --add-modules javafx.controls,javafx.fxml
```
(Reemplaza "C:\ruta\a\javafx\lib" con la ruta real a tu JavaFX)

### 4. Ejecutar la aplicación
- Ejecuta la clase PilaGUI
- La aplicación debería abrir con la nueva interfaz FXML

## Alternativa sin módulos (si hay problemas):
1. Elimina el archivo module-info.java
2. Configura solo las librerías JAR en el classpath
3. Ejecuta directamente PilaGUI.main()

## Estructura final del proyecto con FXML:
```
src/
├── module-info.java      # Configuración de módulos JavaFX
├── PilaGUI.java          # Aplicación principal (simplificada)
├── PilaController.java   # Controlador con lógica de eventos
├── PilaView.fxml         # Definición XML de la interfaz
├── Pila.java             # Modelo de datos
└── Publicacion.java      # Entidad de publicación
```