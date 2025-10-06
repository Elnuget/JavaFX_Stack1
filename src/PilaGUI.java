import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PilaGUI extends Application {
    
    private Pila pila;
    private TextArea txtResultado;
    private TextField txtCodigo;
    private TextField txtTitulo;
    private TextArea txtMensaje;
    private Label lblEstado;
    
    @Override
    public void start(Stage primaryStage) {
        pila = new Pila();
        
        primaryStage.setTitle("Gestor de Pila de Publicaciones");
        primaryStage.setResizable(true);
        
        // Layout principal
        VBox layoutPrincipal = new VBox(10);
        layoutPrincipal.setPadding(new Insets(10));
        
        // Panel superior - Entrada de datos
        VBox panelEntrada = crearPanelEntrada();
        
        // Panel central - Botones y visualización
        HBox panelCentral = new HBox(10);
        
        // Panel de botones (izquierda)
        VBox panelBotones = crearPanelBotones();
        
        // Panel de resultados (derecha)
        VBox panelResultados = crearPanelResultados();
        
        panelCentral.getChildren().addAll(panelBotones, panelResultados);
        
        // Panel inferior - Estado
        HBox panelEstado = crearPanelEstado();
        
        layoutPrincipal.getChildren().addAll(panelEntrada, panelCentral, panelEstado);
        
        Scene escena = new Scene(layoutPrincipal, 800, 600);
        primaryStage.setScene(escena);
        primaryStage.show();
        
        actualizarVisualizacion();
    }
    
    private VBox crearPanelEntrada() {
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(10));
        panel.setStyle("-fx-border-color: gray; -fx-border-width: 1;");
        
        Label titulo = new Label("Nueva Publicación");
        titulo.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        
        // Código
        Label lblCodigo = new Label("Código:");
        txtCodigo = new TextField();
        txtCodigo.setPrefWidth(150);
        grid.add(lblCodigo, 0, 0);
        grid.add(txtCodigo, 1, 0);
        
        // Título
        Label lblTitulo = new Label("Título:");
        txtTitulo = new TextField();
        txtTitulo.setPrefWidth(300);
        grid.add(lblTitulo, 0, 1);
        grid.add(txtTitulo, 1, 1);
        
        // Mensaje
        Label lblMensaje = new Label("Mensaje:");
        txtMensaje = new TextArea();
        txtMensaje.setPrefRowCount(3);
        txtMensaje.setPrefWidth(300);
        txtMensaje.setWrapText(true);
        grid.add(lblMensaje, 0, 2);
        grid.add(txtMensaje, 1, 2);
        
        // Configurar columnas
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.NEVER);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(col1, col2);
        
        panel.getChildren().addAll(titulo, grid);
        return panel;
    }
    
    private VBox crearPanelBotones() {
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(10));
        panel.setStyle("-fx-border-color: gray; -fx-border-width: 1;");
        panel.setPrefWidth(250);
        
        Label titulo = new Label("Operaciones");
        titulo.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        
        GridPane gridBotones = new GridPane();
        gridBotones.setHgap(10);
        gridBotones.setVgap(10);
        
        // Primera fila de botones
        Button btnApilar = new Button("Apilar Publicación");
        btnApilar.setPrefWidth(120);
        btnApilar.setOnAction(e -> apilarPublicacion());
        
        Button btnDesapilar = new Button("Desapilar");
        btnDesapilar.setPrefWidth(120);
        btnDesapilar.setOnAction(e -> desapilarPublicacion());
        
        gridBotones.add(btnApilar, 0, 0);
        gridBotones.add(btnDesapilar, 1, 0);
        
        // Segunda fila de botones
        Button btnVerTope = new Button("Ver Tope");
        btnVerTope.setPrefWidth(120);
        btnVerTope.setOnAction(e -> verTope());
        
        Button btnLimpiar = new Button("Limpiar Pila");
        btnLimpiar.setPrefWidth(120);
        btnLimpiar.setOnAction(e -> limpiarPila());
        
        gridBotones.add(btnVerTope, 0, 1);
        gridBotones.add(btnLimpiar, 1, 1);
        
        // Configurar columnas iguales
        ColumnConstraints colBtn1 = new ColumnConstraints();
        colBtn1.setHgrow(Priority.ALWAYS);
        ColumnConstraints colBtn2 = new ColumnConstraints();
        colBtn2.setHgrow(Priority.ALWAYS);
        gridBotones.getColumnConstraints().addAll(colBtn1, colBtn2);
        
        panel.getChildren().addAll(titulo, gridBotones);
        return panel;
    }
    
    private VBox crearPanelResultados() {
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(10));
        panel.setStyle("-fx-border-color: gray; -fx-border-width: 1;");
        
        Label titulo = new Label("Contenido de la Pila");
        titulo.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        
        txtResultado = new TextArea();
        txtResultado.setEditable(false);
        txtResultado.setPrefWidth(350);
        txtResultado.setPrefHeight(300);
        txtResultado.setStyle("-fx-font-family: monospace;");
        
        ScrollPane scroll = new ScrollPane(txtResultado);
        scroll.setFitToWidth(true);
        
        panel.getChildren().addAll(titulo, scroll);
        VBox.setVgrow(scroll, Priority.ALWAYS);
        
        return panel;
    }
    
    private HBox crearPanelEstado() {
        HBox panel = new HBox();
        panel.setPadding(new Insets(5, 10, 5, 10));
        panel.setStyle("-fx-border-color: gray; -fx-border-width: 1;");
        
        lblEstado = new Label("Pila vacía - Elementos: 0");
        lblEstado.setStyle("-fx-font-size: 12px;");
        
        panel.getChildren().add(lblEstado);
        return panel;
    }
    
    private void apilarPublicacion() {
        try {
            String codigo = txtCodigo.getText().trim();
            String titulo = txtTitulo.getText().trim();
            String mensaje = txtMensaje.getText().trim();
            
            if (codigo.isEmpty() || titulo.isEmpty() || mensaje.isEmpty()) {
                mostrarAlerta("Error", "Todos los campos son obligatorios", Alert.AlertType.ERROR);
                return;
            }
            
            Publicacion nuevaPublicacion = new Publicacion(codigo, titulo, mensaje);
            pila.apilar(nuevaPublicacion);
            
            limpiarCampos();
            actualizarVisualizacion();
            mostrarAlerta("Éxito", "Publicación apilada correctamente", Alert.AlertType.INFORMATION);
            
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al apilar: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    private void desapilarPublicacion() {
        try {
            Publicacion publicacionDesapilada = pila.desapilar();
            actualizarVisualizacion();
            
            String mensaje = "Publicación desapilada:\\n\\n" + publicacionDesapilada.toString();
            mostrarAlerta("Publicación Desapilada", mensaje, Alert.AlertType.INFORMATION);
            
        } catch (IllegalStateException e) {
            mostrarAlerta("Error", e.getMessage(), Alert.AlertType.WARNING);
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al desapilar: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    private void verTope() {
        try {
            Publicacion tope = pila.verTope();
            String mensaje = "Publicación en el tope:\\n\\n" + tope.toString();
            mostrarAlerta("Tope de la Pila", mensaje, Alert.AlertType.INFORMATION);
            
        } catch (IllegalStateException e) {
            mostrarAlerta("Error", e.getMessage(), Alert.AlertType.WARNING);
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al ver el tope: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    private void limpiarPila() {
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar");
        confirmacion.setHeaderText("¿Estás seguro?");
        confirmacion.setContentText("Esta acción eliminará todas las publicaciones de la pila.");
        
        if (confirmacion.showAndWait().get() == ButtonType.OK) {
            pila.limpiar();
            actualizarVisualizacion();
            mostrarAlerta("Éxito", "Pila limpiada correctamente", Alert.AlertType.INFORMATION);
        }
    }
    
    private void actualizarVisualizacion() {
        String estado = String.format("%s - Elementos: %d", 
                                    pila.estaVacia() ? "Pila vacía" : "Pila con elementos", 
                                    pila.tamano());
        lblEstado.setText(estado);
        
        if (pila.estaVacia()) {
            txtResultado.setText("La pila está vacía.\\n\\nAgrega publicaciones usando el formulario de arriba.");
        } else {
            txtResultado.setText(pila.toString());
        }
    }
    
    private void limpiarCampos() {
        txtCodigo.clear();
        txtTitulo.clear();
        txtMensaje.clear();
    }
    
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}