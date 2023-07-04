package kid.prolingua;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.file.Paths;



public class HelloApplication extends Application {




    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(fxmlLoader.load(), 626, 342);
        //stage.setTitle("LINGUAKID");
        stage.setScene(scene);
        stage.show();
        reproducirFondo("musicFondoA.mp3", 0.1);

    }
    private void reproducirFondo(String musicaFondo, double volumen) {
        String rutaArchivo = getClass().getResource("/" + musicaFondo).toString();
        Media media = new Media(rutaArchivo);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(volumen);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();

    }




    public static void main(String[] args) {
        launch();
    }
}