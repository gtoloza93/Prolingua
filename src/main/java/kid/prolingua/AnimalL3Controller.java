package kid.prolingua;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AnimalL3Controller {

    @FXML
    private Button palabra1Button;



    @FXML
    private Text henText;
    @FXML
    private Text henText1;
    @FXML
    private Text pigText;
    @FXML
    private Text pigText1;
    @FXML
    private Text snakeText;
    @FXML
    private Text snakeText1;
    @FXML
    private Text mouseText;
    @FXML
    private Text mouseText1;
    @FXML
    private Text duckText;
    @FXML
    private Text duckText1;

    @FXML
    private ProgressBar progressBar;


    private boolean henRta = false;
    private boolean pigRta = false;
    private boolean snakeRta = false;
    private boolean mouseRta = false;
    private boolean duckRta = false;





    private int correctRta = 0;
    private int incorrectRta = 0;
    private int totalPreguntas = 5;

    private boolean isWordCorrectlyPlaced(Text text) {
        return text.getText().equals("Good");

    }
    private void reproducirPronunciacion(String nombreArchivo) {
        String rutaArchivo = getClass().getResource("/" + nombreArchivo).toString();
        Media media = new Media(rutaArchivo);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }


    public void backL1ButtonOnAction(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close(); // Cerrar la escena actual

        // Mostrar la escena anterior
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfazCategorias.fxml"));
            Scene escenaAnterior = new Scene(fxmlLoader.load());
            stage.setScene(escenaAnterior);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Stage animalLevel3Stage = new Stage();
    public void restartButtonOnAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close(); // Cerrar la escena actual
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AnimalCategoriaLevel3.fxml"));
            animalLevel3Stage.initStyle(StageStyle.UNDECORATED);
            animalLevel3Stage.setScene(new Scene(fxmlLoader.load(), 626, 342));
            animalLevel3Stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Animalhen
    public void henHandleDragDetection(MouseEvent mouseEvent ) {
        reproducirPronunciacion("hen.mp3");
        if (!isWordCorrectlyPlaced(henText)) {
            Dragboard db = henText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(henText.getText());
            db.setContent(cb);

            mouseEvent.consume();
        }


    }

    public void henHanledTextDragOver(DragEvent dragEvent) {

        if (!henRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }

    }

    public void henHanledTextDragDropped(DragEvent dragEvent) {

                Dragboard db = dragEvent.getDragboard();
                boolean success = false;
                if (db.hasString() && db.getString().equals("Hen")) {
                    success = true;
                }
                dragEvent.setDropCompleted(success);
                dragEvent.consume();

                if (success) {
                    henText1.setText("Hen");
                    correctRta++;
                    updateProgressBar();
                    henRta = true;

                } else {
                    henText1.setText("---X---");
                    incorrectRta++;
                    henRta = false;

                }


    }


    public void henHandleDragDone(DragEvent dragEvent) {

        if (henRta) {
            henText.setDisable(true);
            if (henText.getText().equals(henText1.getText())) {
                henText.setText("Good");
            } else {
                henText.setText("Wrong");
                henText.setDisable(true);
            }
        }
        else{
            henText.setDisable(true);
        }
        updateProgressBar();
    }




    //Animalpig
    public void pigHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("pig.mp3");

        if (!isWordCorrectlyPlaced(pigText)) {
            Dragboard db1 = pigText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(pigText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }


    public void pigHandleDragDone(DragEvent dragEvent) {
        if (pigRta) {
            pigText.setDisable(true);
            if (pigText.getText().equals(pigText1.getText())) {
                pigText.setText("Good");
            } else {
                pigText.setText("Wrong");
                pigText.setDisable(true);
            }

        }
        else{
            pigText.setDisable(true);
        }
        updateProgressBar();
    }

    public void pigHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Pig")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            pigText1.setText("Pig");
            correctRta++;
            updateProgressBar();
            pigRta = true;
        }else{
            pigText1.setText("---X---");
            incorrectRta++;
            pigRta = false;

        }



    }

    public void pigHanledTextDragOver(DragEvent dragEvent) {
        if (!pigRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }

    }

    //AnimalSnake

    public void snakeHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("snake.mp3");

        if (!isWordCorrectlyPlaced(snakeText)) {
            Dragboard db1 = snakeText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(snakeText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }
    public void snakeHandleDragDone(DragEvent dragEvent) {

        if (snakeRta) {
            snakeText.setDisable(true);
            if (snakeText.getText().equals(snakeText1.getText())) {
                snakeText.setText("Good");
            } else {
                snakeText.setText("Wrong");
                snakeText.setDisable(true);
            }
        }
        else{
            snakeText.setDisable(true);
        }
        updateProgressBar();
    }
    public void snakeHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Snake")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            snakeText1.setText("Snake");
            correctRta++;
            updateProgressBar();
            snakeRta = true;
        } else {
            snakeText1.setText("---X---");
            incorrectRta++;


        }

    }

    public void snakeHanledTextDragOver(DragEvent dragEvent) {

        if (!snakeRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    //AnimalMouse
    public void mouseHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("mouse.mp3");
        if (!isWordCorrectlyPlaced(mouseText)) {
            Dragboard db1 = mouseText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(mouseText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }

    public void mouseHandleDragDone(DragEvent dragEvent) {
        if (mouseRta) {
            mouseText.setDisable(true);
            if (mouseText.getText().equals(mouseText1.getText())) {
                mouseText.setText("Good");
            } else {
                mouseText.setText("Wrong");
                mouseText.setDisable(true);
            }

        }
        else{
            mouseText.setDisable(true);
        }
        updateProgressBar();
    }

    public void mouseHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Mouse")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            mouseText1.setText("Mouse");
            correctRta++;
            updateProgressBar();
            mouseRta = true;
        } else {
            mouseText1.setText("---X---");
            incorrectRta++;
            mouseRta = false;

        }


    }

    public void mouseHanledTextDragOver(DragEvent dragEvent) {

        if (!mouseRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    //AnimalDuck

    public void duckHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("duck.mp3");
        if (!isWordCorrectlyPlaced(duckText)) {
            Dragboard db1 = duckText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(duckText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }
    public void duckHandleDragDone(DragEvent dragEvent) {
        if (duckRta) {
            duckText.setDisable(true);
            if (duckText.getText().equals(duckText1.getText())) {
                duckText.setText("Good");
            } else {
                duckText.setText("Wrong");
                duckText.setDisable(true);
            }

        }
        else{
            duckText.setDisable(true);
        }
        updateProgressBar();
    }

    public void duckHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Duck")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            duckText1.setText("Duck");
            correctRta++;
            updateProgressBar();
            duckRta = true;
        } else {
            duckText1.setText("---X---");
            incorrectRta++;
            duckRta = false;

        }


    }

    public void duckHanledTextDragOver(DragEvent dragEvent) {

        if (!duckRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    Stage amazing = new Stage();
    private void updateProgressBar() {
        double progress = (double) correctRta / totalPreguntas;
        progressBar.setProgress(progress);
        if (correctRta + incorrectRta == totalPreguntas) {
            try {
                FXMLLoader fxmlLoader;
                Scene newScene;

                if (correctRta > 4) {
                    fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Amazing.fxml"));
                    newScene = new Scene(fxmlLoader.load(), 626, 342);
                    reproducirPronunciacion("Victoria.mp3");
                    System.out.println(totalPreguntas+"correct 4 o mas");
                } else if(correctRta == 4  ) {
                    fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("KeepItUP.fxml"));
                    newScene = new Scene(fxmlLoader.load(), 626, 342);
                    reproducirPronunciacion("Victoria.mp3");
                    System.out.println(totalPreguntas+"correct =4 y preguntas>=4");

                }else {
                    fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DontGiveUP.fxml"));
                    newScene = new Scene(fxmlLoader.load(), 626, 342);
                    reproducirPronunciacion("derrota.mp3");
                    System.out.println(totalPreguntas);

                }

                amazing.initStyle(StageStyle.UNDECORATED);
                amazing.setScene(newScene);
                amazing.show();


                Node source = progressBar.getScene().getRoot();
                Stage currentStage = (Stage) source.getScene().getWindow();
                currentStage.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
