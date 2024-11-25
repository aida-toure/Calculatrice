package com.example.calculatrice;

import com.example.calculatrice.UI.Manager.UIManager;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("files/FXML/calculatrice-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), UIManager.sizeXAbsoluteWindow, UIManager.sizeYAbsoluteWindow);
        stage.setTitle("Bienvenue | Calculatrice !");
        stage.setScene(scene);

        UIManager.createUI();
        stage.show();

        stage.widthProperty().addListener((object, oldWidth, newWidth) ->{
            Point2D vector2 = new Point2D(newWidth.doubleValue(), 1);
            UIManager.responsive(stage, vector2);
        });
        stage.heightProperty().addListener((object, oldHeight, newHeight) ->{
            Point2D vector2 = new Point2D( 1, newHeight.doubleValue());
            UIManager.responsive(stage,vector2);
        });
    }

    public static void main(String[] args) {
        // lancer l'application
        launch();
    }
}