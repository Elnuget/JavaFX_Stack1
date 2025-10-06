# Gestor de Pila de Publicaciones - JavaFX

Este proyecto implementa una interfaz gráfica con JavaFX para gestionar una pila de publicaciones usando la estructura de datos Stack.

## Características

La aplicación permite:
- **Apilar**: Agregar nuevas publicaciones a la pila
- **Desapilar**: Remover y mostrar la publicación del tope
- **Ver Tope**: Visualizar la publicación en el tope sin removerla
- **Limpiar**: Vaciar completamente la pila
- **Visualización**: Ver el estado completo de la pila en tiempo real

## Archivos del Proyecto

- `Publicacion.java` - Clase que representa una publicación con código, título y mensaje
- `Pila.java` - Implementación de la estructura de datos pila para publicaciones
- `PilaGUI.java` - Interfaz gráfica principal con JavaFX

## Configuración de JavaFX

### Opción 1: Usando IntelliJ IDEA
1. Ve a File → Project Structure → Libraries
2. Agrega JavaFX SDK (descárgalo desde https://openjfx.io/)
3. En Run Configuration, agrega los módulos VM options:
   ```
   --module-path "path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml
   ```

### Opción 2: Usando Eclipse
1. Descarga JavaFX SDK desde https://openjfx.io/
2. Agrega las librerías JAR al Build Path del proyecto
3. En Run Configuration → Arguments, agrega:
   ```
   --module-path "path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml
   ```

### Opción 3: Sin módulos (más simple)
Si tienes problemas con módulos, puedes:
1. Eliminar el archivo `module-info.java`
2. Asegurarte de que JavaFX esté en el classpath
3. Ejecutar directamente la clase `PilaGUI`

## Ejecución

Una vez configurado JavaFX:
1. Compila el proyecto
2. Ejecuta la clase `PilaGUI` 
3. La aplicación abrirá una ventana con la interfaz gráfica

## Funcionalidades de la Interfaz

### Panel de Nueva Publicación
- **Código**: Campo para el identificador único de la publicación
- **Título**: Campo para el título de la publicación  
- **Mensaje**: Área de texto para el contenido de la publicación

### Panel de Operaciones
- **Apilar Publicación**: Agrega una nueva publicación a la pila
- **Desapilar**: Remueve la publicación del tope y la muestra
- **Ver Tope**: Muestra la publicación del tope sin removerla
- **Limpiar Pila**: Vacía completamente la pila

### Panel de Contenido de la Pila
- Muestra todas las publicaciones en la pila
- Visualización desde el tope hacia la base
- Formato de texto simple y legible

### Panel de Estado
- Indica si la pila está vacía o contiene elementos
- Muestra el número total de elementos en la pila

## Validaciones

- Todos los campos (código, título, mensaje) son obligatorios
- Alertas informativas para operaciones exitosas
- Alertas de error para operaciones inválidas (ejemplo: desapilar pila vacía)
- Confirmación antes de limpiar la pila completamente

## Estructura de Datos

La pila implementa el principio LIFO (Last In, First Out):
- La última publicación agregada es la primera en ser removida
- Se puede ver el tope sin remover el elemento
- Se mantiene un contador automático del tamaño de la pila
- Usa internamente la clase Stack de Java para el almacenamiento

## Clase Pila - Métodos Principales

- `estaVacia()` - Verifica si la pila está vacía
- `apilar(Publicacion)` - Agrega una publicación al tope
- `desapilar()` - Remueve y retorna la publicación del tope
- `verTope()` - Retorna la publicación del tope sin removerla
- `tamano()` - Retorna el número de elementos en la pila
- `limpiar()` - Elimina todos los elementos de la pila
- `toString()` - Retorna una representación textual de toda la pila

¡Disfruta usando el Gestor de Pila de Publicaciones!