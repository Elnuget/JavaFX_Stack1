import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PilaGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar el archivo FXML desde el paquete view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PilaView.fxml"));
            Parent root = loader.load();
            
            // Configurar la ventana
            primaryStage.setTitle("Gestor de Pila de Publicaciones");
            primaryStage.setResizable(true);
            
            Scene escena = new Scene(root, 800, 600);
            primaryStage.setScene(escena);
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al cargar la interfaz FXML: " + e.getMessage());
        }
    }
    

    
    public static void main(String[] args) {
        launch(args);
    }
}