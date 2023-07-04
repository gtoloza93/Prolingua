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

public class AnimalL2Controller {

    @FXML
    private Button palabra1Button;



    @FXML
    private Text cowText;
    @FXML
    private Text cowText1;
    @FXML
    private Text rabbitText;
    @FXML
    private Text rabbitText1;
    @FXML
    private Text frogText;
    @FXML
    private Text frogText1;
    @FXML
    private Text spiderText;
    @FXML
    private Text spiderText1;
    @FXML
    private Text birdText;
    @FXML
    private Text birdText1;

    @FXML
    private ProgressBar progressBar;


    private boolean cowRta = false;
    private boolean rabbitRta = false;
    private boolean frogRta = false;
    private boolean spiderRta = false;
    private boolean birdRta = false;





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
    Stage animalLevel2Stage = new Stage();
    public void restartButtonOnAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close(); // Cerrar la escena actual
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AnimalCategoriaLevel2.fxml"));
            animalLevel2Stage.initStyle(StageStyle.UNDECORATED);
            animalLevel2Stage.setScene(new Scene(fxmlLoader.load(), 626, 342));
            animalLevel2Stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Animalcow
    public void cowHandleDragDetection(MouseEvent mouseEvent ) {
        reproducirPronunciacion("cow.mp3");
        if (!isWordCorrectlyPlaced(cowText)) {
            Dragboard db = cowText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(cowText.getText());
            db.setContent(cb);

            mouseEvent.consume();
        }


    }

    public void cowHanledTextDragOver(DragEvent dragEvent) {

        if (!cowRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }

    }

    public void cowHanledTextDragDropped(DragEvent dragEvent) {

                Dragboard db = dragEvent.getDragboard();
                boolean success = false;
                if (db.hasString() && db.getString().equals("Cow")) {
                    success = true;
                }
                dragEvent.setDropCompleted(success);
                dragEvent.consume();

                if (success) {
                    cowText1.setText("Cow");
                    correctRta++;
                    updateProgressBar();
                    cowRta = true;

                } else {
                    cowText1.setText("---X---");
                    incorrectRta++;
                    cowRta = false;

                }


    }


    public void cowHandleDragDone(DragEvent dragEvent) {

        if (cowRta) {
            cowText.setDisable(true);
            if (cowText.getText().equals(cowText1.getText())) {
                cowText.setText("Good");
            } else {
                cowText.setText("Wrong");
                cowText.setDisable(true);
            }
        }
        else{
            cowText.setDisable(true);
        }
        updateProgressBar();
    }




    //AnimalRabbit
    public void rabbitHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("rabbit.mp3");

        if (!isWordCorrectlyPlaced(rabbitText)) {
            Dragboard db1 = rabbitText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(rabbitText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }


    public void rabbitHandleDragDone(DragEvent dragEvent) {
        if (rabbitRta) {
            rabbitText.setDisable(true);
            if (rabbitText.getText().equals(rabbitText1.getText())) {
                rabbitText.setText("Good");
            } else {
                rabbitText.setText("Wrong");
                rabbitText.setDisable(true);
            }

        }
        else{
            rabbitText.setDisable(true);
        }
        updateProgressBar();
    }

    public void rabbitHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Rabbit")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            rabbitText1.setText("Rabbit");
            correctRta++;
            updateProgressBar();
            rabbitRta = true;
        }else{
            rabbitText1.setText("---X---");
            incorrectRta++;
            rabbitRta = false;

        }



    }

    public void rabbitHanledTextDragOver(DragEvent dragEvent) {
        if (!rabbitRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }

    }

    //AnimalFrog

    public void frogHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("frog.mp3");

        if (!isWordCorrectlyPlaced(frogText)) {
            Dragboard db1 = frogText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(frogText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }
    public void frogHandleDragDone(DragEvent dragEvent) {

        if (frogRta) {
            frogText.setDisable(true);
            if (frogText.getText().equals(frogText1.getText())) {
                frogText.setText("Good");
            } else {
                frogText.setText("Wrong");
                frogText.setDisable(true);
            }
        }
        else{
            frogText.setDisable(true);
        }
        updateProgressBar();
    }
    public void frogHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Frog")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            frogText1.setText("Frog");
            correctRta++;
            updateProgressBar();
            frogRta = true;
        } else {
            frogText1.setText("---X---");
            incorrectRta++;


        }

    }

    public void frogHanledTextDragOver(DragEvent dragEvent) {

        if (!frogRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    //AnimalSpider
    public void spiderHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("spider.mp3");
        if (!isWordCorrectlyPlaced(spiderText)) {
            Dragboard db1 = spiderText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(spiderText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }

    public void spiderHandleDragDone(DragEvent dragEvent) {
        if (spiderRta) {
            spiderText.setDisable(true);
            if (spiderText.getText().equals(spiderText1.getText())) {
                spiderText.setText("Good");
            } else {
                spiderText.setText("Wrong");
                spiderText.setDisable(true);
            }

        }
        else{
            spiderText.setDisable(true);
        }
        updateProgressBar();
    }

    public void spiderHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Spider")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            spiderText1.setText("Spider");
            correctRta++;
            updateProgressBar();
            spiderRta = true;
        } else {
            spiderText1.setText("---X---");
            incorrectRta++;
            spiderRta = false;

        }


    }

    public void spiderHanledTextDragOver(DragEvent dragEvent) {

        if (!spiderRta && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    //AnimalBird

    public void birdHandleDragDetection(MouseEvent mouseEvent) {
        reproducirPronunciacion("bird.mp3");
        if (!isWordCorrectlyPlaced(birdText)) {
            Dragboard db1 = birdText.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(birdText.getText());

            db1.setContent(cb);

            mouseEvent.consume();
        }

    }
    public void birdHandleDragDone(DragEvent dragEvent) {
        if (birdRta) {
            birdText.setDisable(true);
            if (birdText.getText().equals(birdText1.getText())) {
                birdText.setText("Good");
            } else {
                birdText.setText("Wrong");
                birdText.setDisable(true);
            }

        }
        else{
            birdText.setDisable(true);
        }
        updateProgressBar();
    }

    public void birdHanledTextDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString() && db.getString().equals("Bird")) {
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();

        if (success) {
            birdText1.setText("Bird");
            correctRta++;
            updateProgressBar();
            birdRta = true;
        } else {
            birdText1.setText("---X---");
            incorrectRta++;
            birdRta = false;

        }


    }

    public void birdHanledTextDragOver(DragEvent dragEvent) {

        if (!birdRta && dragEvent.getDragboard().hasString()) {
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
