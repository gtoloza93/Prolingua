package kid.prolingua;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EventObject;
import java.util.ResourceBundle;




public class HelloController  {



    @FXML
    private Button salirButton;
    @FXML
    private Label ingresoMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Button IngresarButton;




    public void loginButtonOnAction(ActionEvent event){


        if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false){
            validateLogin();
        }
        else {
            ingresoMessageLabel.setText("Ingresa Username y Contraseña");
        }
    }
    public void salirButtonOnAction(ActionEvent event){
        Stage stage = (Stage) salirButton.getScene().getWindow();
        stage.close();

    }

    Stage categoriaStage = new Stage();
    public void validateLogin(){
        DatabaseConection connectNow = new DatabaseConection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM usseraccounts WHERE username = '"+ usernameTextField.getText() + "' AND password = '"+ passwordPasswordField.getText() +"' ";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){

                if (queryResult.getInt(1) == 1 ) {
                    //ingresoMessageLabel.setText("Welcome!");

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("interfazCategorias.fxml"));
                        categoriaStage.initStyle(StageStyle.UNDECORATED);
                        categoriaStage.setScene(new Scene(fxmlLoader.load(), 626, 342));
                        categoriaStage.show();

                        Stage currentStage = (Stage) ingresoMessageLabel.getScene().getWindow();
                        currentStage.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    ingresoMessageLabel.setText("Intentalo de nuevo!");
                }
            }
        }catch (Exception e){

            e.printStackTrace();

        }

    }

    Stage registerStage = new Stage();

    public void registerButton(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(fxmlLoader.load(), 626, 342));
            registerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };



}