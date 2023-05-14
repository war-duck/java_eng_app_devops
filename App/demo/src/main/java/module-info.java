module test {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive javafx.base;

    opens test to javafx.fxml;
    exports test;
}