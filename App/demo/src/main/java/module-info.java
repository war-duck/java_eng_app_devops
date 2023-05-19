module main {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive javafx.base;
    requires junit;

    opens main to javafx.fxml;
    exports main;
}