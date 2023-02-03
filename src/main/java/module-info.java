module com.example.labb3a {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens se.ikran.kth.labb3A to javafx.fxml;
    exports se.ikran.kth.labb3A;
    exports;
    opens to
}