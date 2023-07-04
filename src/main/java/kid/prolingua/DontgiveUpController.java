package kid.prolingua;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class DontgiveUpController {

    Stage animalC1= new Stage();
    public void restartButtonOnAction(ActionEvent event) {
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
}

