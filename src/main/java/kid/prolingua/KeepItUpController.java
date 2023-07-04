package kid.prolingua;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class KeepItUpController {
    Stage animalL1 = new Stage();
    public void backButtonOnAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close(); // Cerrar la escena actual
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InterfazCategorias.fxml"));
            animalL1.initStyle(StageStyle.UNDECORATED);
            animalL1.setScene(new Scene(fxmlLoader.load(), 626, 342));
            animalL1.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Stage animalC1= new Stage();
    public void restarButtonOnAction(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close(); // Cerrar la escena actual
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AnimalCategoriaLevel1.fxml"));
            animalC1.initStyle(StageStyle.UNDECORATED);
            animalC1.setScene(new Scene(fxmlLoader.load(), 626, 342));
            animalC1.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private int currentLevel = 1;
    private final int totalLevels = 10;

    public void letsgoButtonOnAction(ActionEvent event) {
        currentLevel++;
        if (currentLevel <= totalLevels) {
            cargarSiguienteNivel(currentLevel);
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        } else {
            mostrarMensajeFinalizacion();
        }
    }

    private void cargarSiguienteNivel(int nivel) {
        String nivelFXML = "AnimalCategoriaLevel" + nivel + ".fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(nivelFXML));
            Stage nextLevelStage = new Stage();
            nextLevelStage.initStyle(StageStyle.UNDECORATED);
            nextLevelStage.setScene(new Scene(fxmlLoader.load(), 626, 342));
            nextLevelStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void mostrarMensajeFinalizacion() {

    }
}
