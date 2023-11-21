module com.example.iterator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.iterator to javafx.fxml;
    exports com.example.iterator;
}