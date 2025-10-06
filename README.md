# JavaFX Stack Manager - UDLA
**Autor: Carlos Angulo**

## Descripción
Aplicación JavaFX que implementa un gestor de pila de publicaciones utilizando el patrón MVC (Model-View-Controller) con FXML para la separación de la interfaz de usuario y la lógica de negocio.

## Estructura del Proyecto

### Estructura de paquetes:
- **`PilaGUI.java`** - Clase principal que inicia la aplicación (paquete raíz)
- **`controller/PilaController.java`** - Controlador que maneja la lógica de la interfaz
- **`view/PilaView.fxml`** - Vista FXML que define la estructura visual
- **`model/Pila.java`** - Modelo que implementa la estructura de datos pila
- **`model/Publicacion.java`** - Modelo que representa una publicación

### Arquitectura MVC con FXML:

**Model (Modelo) - Paquete `model`:**
- `model/Pila.java`: Gestiona las operaciones de la pila (apilar, desapilar, ver tope, etc.)
- `model/Publicacion.java`: Representa los objetos que se almacenan en la pila

**View (Vista) - Paquete `view`:**
- `view/PilaView.fxml`: Define la interfaz gráfica usando XML declarativo

**Controller (Controlador) - Paquete `controller`:**
- `controller/PilaController.java`: Conecta la vista con el modelo, maneja eventos y actualiza la interfaz

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

## Ventajas del uso de FXML

### Separación de responsabilidades:
- **Vista**: Definida completamente en XML (PilaView.fxml)
- **Lógica**: Concentrada en el controlador Java (PilaController.java)
- **Modelo**: Independiente de la interfaz (Pila.java, Publicacion.java)

### Beneficios:
1. **Mantenimiento más fácil**: Cambios visuales sin tocar código Java
2. **Diseño declarativo**: Interfaz más clara y legible
3. **Reutilización**: Componentes pueden ser reutilizados
4. **Colaboración**: Diseñadores pueden trabajar en FXML independientemente
5. **Herramientas**: Compatible con Scene Builder para diseño visual

## Validaciones

- Todos los campos (código, título, mensaje) son obligatorios
- Alertas informativas para operaciones exitosas
- Confirmaciones para operaciones destructivas
- Manejo de excepciones para operaciones en pila vacía

## Estructura de archivos organizada por paquetes
```
src/
├── PilaGUI.java              # Clase principal (Application)
├── module-info.java          # Configuración de módulos JavaFX
├── controller/
│   └── PilaController.java   # Controlador MVC con @FXML
├── view/
│   └── PilaView.fxml         # Definición XML de la interfaz
└── model/
    ├── Pila.java             # Modelo de la pila
    └── Publicacion.java      # Modelo de publicación
```

## Beneficios de la organización por paquetes

✅ **Separación clara de responsabilidades por capas**
✅ **Código más mantenible y escalable**  
✅ **Facilita el trabajo en equipo**
✅ **Estructura estándar de la industria**
✅ **Mejor encapsulamiento**
✅ **Facilita pruebas unitarias por capa**
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