module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.calculatrice to javafx.fxml;
    exports com.example.calculatrice;
    exports com.example.calculatrice.Controllers;
    opens com.example.calculatrice.Controllers to javafx.fxml;
    exports com.example.calculatrice.UI;
    opens com.example.calculatrice.UI to javafx.fxml;
    exports com.example.calculatrice.UI.Manager;
    opens com.example.calculatrice.UI.Manager to javafx.fxml;
    exports com.example.calculatrice.UI.Entities;
    opens com.example.calculatrice.UI.Entities to javafx.fxml;
    exports com.example.calculatrice.Back;
    opens com.example.calculatrice.Back to javafx.fxml;
}