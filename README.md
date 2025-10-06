# Tutorial: Crear un Gestor de Pilas con JavaFX
**Autor: Carlos Angulo - UDLA**

## ¿Qué vamos a crear?
Una aplicación con ventanas que gestiona una "pila" de publicaciones. Una pila es como una torre de platos: el último que pones es el primero que sacas.

---

## PASO 1: Configurar JavaFX (¡Muy Importante!)

### Descargar JavaFX
1. Ve a https://openjfx.io/
2. Descarga **JavaFX SDK 21** (o la versión más reciente)
3. Guárdalo en una carpeta fácil de recordar, por ejemplo: `C:\javafx-sdk-21\`

### Configurar IntelliJ IDEA
1. **File** → **Project Structure** (Ctrl+Alt+Shift+S)
2. Ir a **Libraries** → clic en **+** → **Java**
3. Buscar la carpeta `lib` dentro de JavaFX (ej: `C:\javafx-sdk-21\lib`)
4. Seleccionar **todos** los archivos .jar
5. Clic **OK**

### Configurar la Ejecución
1. **Run** → **Edit Configurations**
2. Crear nueva **Application**
3. **Main class**: `PilaGUI`
4. **VM options**: 
   ```
   --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls,javafx.fxml
   ```
   (Cambiar la ruta por donde instalaste JavaFX)

---

## PASO 2: Crear la Estructura de Carpetas

```
src/
├── PilaGUI.java              # Archivo principal
├── controller/
│   └── PilaController.java   # Controla los botones
├── view/
│   └── PilaView.fxml         # Diseño de la ventana
└── model/
    ├── Pila.java             # La pila de datos
    └── Publicacion.java      # Cada elemento de la pila
```

---

## PASO 3: Crear las Clases (en este orden)

### 1. Crear `Publicacion.java` (en carpeta model/)
```java
package model;

public class Publicacion {
    private int codigo;
    private String titulo;
    private String mensaje;
    
    // Constructor
    public Publicacion(int codigo, String titulo, String mensaje) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.mensaje = mensaje;
    }
    
    // Getters y Setters
    public int getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getMensaje() { return mensaje; }
    
    @Override
    public String toString() {
        return "Código: " + codigo + "\nTítulo: " + titulo + "\nMensaje: " + mensaje;
    }
}
```

### 2. Crear `Pila.java` (en carpeta model/)
```java
package model;
import java.util.Stack;

public class Pila {
    private Stack<Publicacion> pila;
    
    public Pila() {
        pila = new Stack<>();
    }
    
    public void apilar(Publicacion pub) { pila.push(pub); }
    public Publicacion desapilar() { return pila.pop(); }
    public boolean estaVacia() { return pila.isEmpty(); }
    public int tamano() { return pila.size(); }
    // ... más métodos
}
```

### 3. Crear `PilaView.fxml` (en carpeta view/)
Este archivo define cómo se ve la ventana (botones, campos de texto, etc.)

### 4. Crear `PilaController.java` (en carpeta controller/)
Controla qué pasa cuando haces clic en los botones.

### 5. Crear `PilaGUI.java` (archivo principal)
```java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PilaGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/PilaView.fxml"));
        primaryStage.setTitle("Gestor de Pilas");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

---

## PASO 4: Funcionalidades

### ✅ Lo que hace la aplicación:
- **Apilar**: Agregar una nueva publicación arriba de la pila
- **Desapilar**: Sacar la publicación de arriba
- **Ver Tope**: Ver qué hay arriba sin sacarlo
- **Limpiar**: Vaciar toda la pila

### ⚠️ Validaciones incluidas:
- El código solo acepta **números enteros**
- Si escribes letras, se borran automáticamente
- Todos los campos son obligatorios
- Alertas cuando algo sale mal

---

## PASO 5: Ejecutar el Proyecto

1. **Compilar**: Build → Build Project
2. **Ejecutar**: Run → Run 'PilaGUI'
3. Si hay errores, revisar que JavaFX esté bien configurado

### Problemas Comunes:
- **"Module not found"**: Revisar VM options
- **"JavaFX runtime components are missing"**: Revisar que JavaFX esté en Libraries
- **Error al cargar FXML**: Verificar que el archivo .fxml esté en la carpeta correcta

---

## PASO 6: Probar la Aplicación

1. **Llenar los campos**: Código (número), Título, Mensaje
2. **Clic en "Apilar"**: Agrega la publicación
3. **Ver el resultado**: Aparece en el panel derecho
4. **Probar otras funciones**: Desapilar, Ver Tope, Limpiar

---

## ¿Cómo funciona por dentro?

### Patrón MVC:
- **Model** (Pila, Publicacion): Los datos
- **View** (PilaView.fxml): Lo que ves en pantalla
- **Controller** (PilaController): Une los datos con la pantalla

### Concepto de Pila:
- **LIFO**: Last In, First Out (el último que entra, primero sale)
- Como una torre de platos: solo puedes agregar o sacar del tope

---

## Archivos Finales del Proyecto

```
📁 JavaFX_Stack1/
├── 📄 README.md
├── 📄 CONFIGURACION_JAVAFX.md
└── 📁 src/
    ├── 📄 PilaGUI.java
    ├── 📁 controller/
    │   └── 📄 PilaController.java
    ├── 📁 view/
    │   └── 📄 PilaView.fxml
    └── 📁 model/
        ├── 📄 Pila.java
        └── 📄 Publicacion.java
```
