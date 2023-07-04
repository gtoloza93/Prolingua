module kid.prolingua {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;


    opens kid.prolingua to javafx.fxml;
    exports kid.prolingua;
}