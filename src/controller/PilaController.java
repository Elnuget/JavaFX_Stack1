package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Pila;
import model.Publicacion;

import java.net.URL;
import java.util.ResourceBundle;

public class PilaController implements Initializable {
    
    @FXML
    private TextField txtCodigo;
    
    @FXML
    private TextField txtTitulo;
    
    @FXML
    private TextArea txtMensaje;
    
    @FXML
    private Button btnApilar;
    
    @FXML
    private Button btnDesapilar;
    
    @FXML
    private Button btnVerTope;
    
    @FXML
    private Button btnLimpiar;
    
    @FXML
    private TextArea txtResultado;
    
    @FXML
    private Label lblEstado;
    
    private Pila pila;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pila = new Pila();
        actualizarVisualizacion();
        
        // Agregar validación al campo código para que solo acepte números
        txtCodigo.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtCodigo.setText(newValue.replaceAll("[^\\d]", ""));
                mostrarAlerta("Error de Validación", 
                             "El código solo puede contener números enteros.", 
                             Alert.AlertType.WARNING);
            }
        });
    }
    
    @FXML
    private void apilarPublicacion() {
        try {
            String codigoTexto = txtCodigo.getText().trim();
            String titulo = txtTitulo.getText().trim();
            String mensaje = txtMensaje.getText().trim();
            
            if (codigoTexto.isEmpty() || titulo.isEmpty() || mensaje.isEmpty()) {
                mostrarAlerta("Error", "Todos los campos son obligatorios", Alert.AlertType.ERROR);
                return;
            }
            
            // Validar que el código sea un número válido
            int codigo;
            try {
                codigo = Integer.parseInt(codigoTexto);
                if (codigo <= 0) {
                    mostrarAlerta("Error de Validación", 
                                 "El código debe ser un número entero positivo.", 
                                 Alert.AlertType.ERROR);
                    return;
                }
            } catch (NumberFormatException e) {
                mostrarAlerta("Error de Validación", 
                             "El código debe ser un número entero válido.\n" +
                             "Por favor, introduce solo números.", 
                             Alert.AlertType.ERROR);
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
    
    @FXML
    private void desapilarPublicacion() {
        try {
            Publicacion publicacionDesapilada = pila.desapilar();
            actualizarVisualizacion();
            
            String mensaje = "Publicación desapilada:\n\n" + publicacionDesapilada.toString();
            mostrarAlerta("Publicación Desapilada", mensaje, Alert.AlertType.INFORMATION);
            
        } catch (IllegalStateException e) {
            mostrarAlerta("Error", e.getMessage(), Alert.AlertType.WARNING);
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al desapilar: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void verTope() {
        try {
            Publicacion tope = pila.verTope();
            String mensaje = "Publicación en el tope:\n\n" + tope.toString();
            mostrarAlerta("Tope de la Pila", mensaje, Alert.AlertType.INFORMATION);
            
        } catch (IllegalStateException e) {
            mostrarAlerta("Error", e.getMessage(), Alert.AlertType.WARNING);
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al ver el tope: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
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
            txtResultado.setText("La pila está vacía.\n\nAgrega publicaciones usando el formulario de arriba.");
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
}