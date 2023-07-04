/*
 * module poov.testejavafx {
 * requires javafx.controls;
 * requires javafx.fxml;
 * 
 * opens poov.testejavafx to javafx.fxml;
 * exports poov.testejavafx;
 * }
 */
module poov.testejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens poov.testejavafx to javafx.fxml;
    opens poov.testejavafx.controller to javafx.fxml, javafx.graphics;
    opens poov.testejavafx.model to javafx.base, javafx.fxml, javafx.graphics;

    exports poov.testejavafx;
}
