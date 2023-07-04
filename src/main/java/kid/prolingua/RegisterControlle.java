package kid.prolingua;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterControlle  {


    @FXML
    private Button regresarInicioButton;
    @FXML
    private Label registerMessageLabel;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private PasswordField contraseñaPasswordField;
    @FXML
    private PasswordField repetirPasswordField;
    @FXML
    private TextField usernameTextField;


    public void regresarButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) regresarInicioButton.getScene().getWindow();
        stage.close();


    }

    public void registerButtonOnAction(ActionEvent event){
        if (contraseñaPasswordField.getText().equals(repetirPasswordField.getText())){
            confirmPasswordLabel.setText("Registro Exitoso!");

            registerUser();

        }else{
            confirmPasswordLabel.setText("Contraseñas error");
        }

    }

    public void registerUser(){
        DatabaseConection connectNow = new DatabaseConection();
        Connection connectDB = connectNow.getConnection();

        String username = usernameTextField.getText();
        String password = contraseñaPasswordField.getText();

        String insertFields = "INSERT INTO usseraccounts(username, password) VALUES  ('";
        String insertValues = username +"','" + password +"')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);



        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    public void regresarLoginButtonOnAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close(); // Cerrar la escena actual

        // Mostrar la escena anterior
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene escenaAnterior = new Scene(fxmlLoader.load(),626, 342);
            stage.setScene(escenaAnterior);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

