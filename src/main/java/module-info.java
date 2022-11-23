module com.example.mastermind {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.mastermind to javafx.fxml;
    exports com.example.mastermind;
}