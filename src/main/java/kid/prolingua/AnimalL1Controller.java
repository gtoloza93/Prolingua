package kid.prolingua;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

public class AnimalL1Controller {


    @FXML
    private Text parrotText;
    @FXML
    private Text parrotText1;
    @FXML
    private Text lionText;
    @FXML
    private Text lionText1;
    @FXML
    private Text horseText;
    @FXML
    private Text horseText1;
    @FXML
    private Text sheepText;
    @FXML
    private Text sheepText1;
    @FXML
    private Text turtleText;
    @FXML
    private Text turtleText1;
    @FXML
    private ProgressBar progressBar;



    private boolean parrotRta = false;
    private boolean lionRta = false;
    private boolean horseRta = false;
    private boolean sheepRta = false;
    private boolean turtleRta = false;

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
    Stage animalLevel1Stage = new Stage();
    public void restartButtonOnAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close(); // Cerrar la escena actual
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AnimalCategoriaLevel1.fxml"));
            animalLevel1Stage.initStyle(StageStyle.UNDECORATED);
            animalLevel1Stage.setScene(new Scene(fxmlLoader.load(), 626, 342));
            animalLevel1Stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //AnimalParrot
    public void parrotHandleDragDetection(MouseEvent mouseEvent ) {
        reproducirPronunciacion("parrotP.mp3");
        if (!isWordCorrectlyPlaced(parrotText)) {
            Dragboard db = parrotText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(parrotText.getText());
            db.setContent(cb);

            mouseEvent.consume();
        }


    }

    public void parrotHanledTextDragOver(DragEvent dragEvent) {

        if (!parrotRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }

    }

    public void parrotHanledTextDragDropped(DragEvent dragEvent) {

                Dragboard db = dragEvent.getDragboard();
                boolean success = false;
                if (db.hasString() && db.getString().equals("Parrot")) {
                    success = true;
                }
                dragEvent.setDropCompleted(success);
                dragEvent.consume();

                if (success) {
                    parrotText1.setText("Parrot");
                    correctRta++;
                    updateProgressBar();
                    parrotRta = true;

                } else {
                    parrotText1.setText("---X---");
                    incorrectRta++;
                    parrotRta = false;

                }


    }


    public void parrotHandleDragDone(DragEvent dragEvent) {

        if (parrotRta) {
            parrotText.setDisable(true);
            if (parrotText.getText().equals(parrotText1.getText())) {
                parrotText.setText("Good");
            } else {
                parrotText.setText("Wrong");
                parrotText.setDisable(true);
            }
        }
        else{
            parrotText.setDisable(true);
        }
        updateProgressBar();
    }




    //AnimalLion
    public void lionHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("lionP.mp3");

        if (!isWordCorrectlyPlaced(lionText)) {
            Dragboard db1 = lionText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(lionText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }


    public void lionHandleDragDone(DragEvent dragEvent) {
        if (lionRta) {
            lionText.setDisable(true);
            if (lionText.getText().equals(lionText1.getText())) {
                lionText.setText("Good");
            } else {
                lionText.setText("Wrong");
                lionText.setDisable(true);
            }

        }
        else{
            lionText.setDisable(true);
        }
        updateProgressBar();
    }

    public void lionHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Lion")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            lionText1.setText("Lion");
            correctRta++;
            updateProgressBar();
            lionRta = true;
        }else{
            lionText1.setText("---X---");
            incorrectRta++;
            lionRta = false;

        }



    }

    public void lionHanledTextDragOver(DragEvent dragEvent) {
        if (!lionRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }

    }

    //AnimalHorse

    public void horseHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("horseP.mp3");

        if (!isWordCorrectlyPlaced(horseText)) {
            Dragboard db1 = horseText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(horseText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }
    public void horseHandleDragDone(DragEvent dragEvent) {

        if (horseRta) {
            horseText.setDisable(true);
            if (horseText.getText().equals(horseText1.getText())) {
                horseText.setText("Good");
            } else {
                horseText.setText("Wrong");
                horseText.setDisable(true);
            }
        }
        else{
            horseText.setDisable(true);
        }
        updateProgressBar();
    }
    public void horseHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Horse")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            horseText1.setText("Horse");
            correctRta++;
            updateProgressBar();
            horseRta = true;
        } else {
            horseText1.setText("---X---");
            incorrectRta++;
            horseRta = false;

        }

    }

    public void horseHanledTextDragOver(DragEvent dragEvent) {

        if (!horseRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    //AnimalSheep
    public void sheepHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("sheepP.mp3");
        if (!isWordCorrectlyPlaced(sheepText)) {
            Dragboard db1 = sheepText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(sheepText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }

    public void sheepHandleDragDone(DragEvent dragEvent) {
        if (sheepRta) {
            sheepText.setDisable(true);
            if (sheepText.getText().equals(sheepText1.getText())) {
                sheepText.setText("Good");
            } else {
                sheepText.setText("Wrong");
                sheepText.setDisable(true);
            }

        }
        else{
            sheepText.setDisable(true);
        }
        updateProgressBar();
    }

    public void sheepHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Sheep")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            sheepText1.setText("Sheep");
            correctRta++;
            updateProgressBar();
            sheepRta = true;
        } else {
            sheepText1.setText("---X---");
            incorrectRta++;
            sheepRta = false;

        }


    }

    public void sheepHanledTextDragOver(DragEvent dragEvent) {

        if (!sheepRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    //AnimalTurtle

    public void turtleHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("turtleP.mp3");
        if (!isWordCorrectlyPlaced(turtleText)) {
            Dragboard db1 = turtleText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(turtleText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }
    public void turtleHandleDragDone(DragEvent dragEvent) {
        if (turtleRta) {
            turtleText.setDisable(true);
            if (turtleText.getText().equals(turtleText1.getText())) {
                turtleText.setText("Good");
            } else {
                turtleText.setText("Wrong");
                turtleText.setDisable(true);
            }

        }
        else{
            turtleText.setDisable(true);
        }
        updateProgressBar();
    }

    public void turtleHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Turtle")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            turtleText1.setText("Turtle");
            correctRta++;
            updateProgressBar();
            turtleRta = true;
        } else {
            turtleText1.setText("---X---");
            incorrectRta++;
            turtleRta = false;

        }


    }

    public void turtleHanledTextDragOver(DragEvent dragEvent) {

        if (!turtleRta && dragEvent.getDragboard().hasString()) {
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
