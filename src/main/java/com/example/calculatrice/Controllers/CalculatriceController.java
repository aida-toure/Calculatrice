package com.example.calculatrice.Controllers;

import com.example.calculatrice.UI.Entities.Button;
import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CalculatriceController {

    @FXML
    private Label buttonOne;

    @FXML
    private TilePane buttons;

    @FXML
    private AnchorPane calculator;

    @FXML
    private VBox frame;

    @FXML
    private AnchorPane history;

    @FXML
    private VBox layoutCalculator;

    @FXML
    private VBox layoutHistory;

    @FXML
    private Label result;

    @FXML
    private AnchorPane root;

    @FXML
    private Label title;



public void setProperties(Node node, List<Property> properties){
        // get all the attributes to compare;
        Class<CalculatriceController> self = CalculatriceController.class;

        System.out.println(node.getId());
        for (Field attribute : self.getDeclaredFields()){
            if (node.getId().equals(attribute.getName())){
                for (Property property : properties){
                    //System.out.println("property : " + property);
                }
            }else if (node.getId().contains("button")){
                if (buttonOne != null){
                    System.out.println("YES");
                    buttonOne.setText("test");
                }
            }
        }
    }
}
