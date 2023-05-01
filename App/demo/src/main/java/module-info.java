module test {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens test to javafx.fxml;
    exports test;
}