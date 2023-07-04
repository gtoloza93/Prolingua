package kid.prolingua;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class InterfazCategoriaController {

    Stage animalLevelStage = new Stage();
    public void playAnimalsButtonOnAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close(); // Cerrar la escena actual
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AnimalCategoriaLevel1.fxml"));
                animalLevelStage.initStyle(StageStyle.UNDECORATED);
                animalLevelStage.setScene(new Scene(fxmlLoader.load(), 626, 342));
                animalLevelStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void backButtonOnAcction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close(); // Cerrar la escena actual

        // Mostrar la escena anterior
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene escenaAnterior = new Scene(fxmlLoader.load());
            stage.setScene(escenaAnterior);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
