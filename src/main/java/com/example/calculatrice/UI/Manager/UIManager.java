package com.example.calculatrice.UI.Manager;

import com.example.calculatrice.Controllers.CalculatriceController;
import com.example.calculatrice.UI.Entities.Button;
import com.example.calculatrice.UI.Entities.Buttons;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;

import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UIManager {
    // attributes -----------------------------------//
    // info related to window
    public final static Integer sizeXAbsoluteWindow = 500;
    public final static Integer sizeYAbsoluteWindow = 600;

    private Integer oldSizeXAbsoluteWindow = 500;
    private Integer oldSizeYAbsoluteWindow = 600;
    // info related to a specific node
    public String id;

    // constructor-----------------------------------//
    public UIManager(String id){
        this.id = id;
    }

    // methods ---------------------------------------//
    public static void setProperties(Node node) {

    }
    protected static void completeUI(String renderChoice, AnchorPane root){
        //set the size of the panes  & bend the children's size (nodes except pane) to the parent
        root.prefWidth(sizeXAbsoluteWindow);
        root.prefHeight(sizeXAbsoluteWindow); // 10 percent of the user's screen height size

        root.setTranslateX(0);
        root.setTranslateY(0);
        if (renderChoice.equals("MIN")) {
            LinkedList<Node> nodeToLookAT = new LinkedList<>();
            nodeToLookAT.add(root);
            while (!nodeToLookAT.isEmpty()) {
                Node currentNode = nodeToLookAT.poll();

                if (currentNode instanceof Pane) {
                    Pane pane = (Pane) currentNode;
                    setProperties(currentNode);
                    for (Node child : pane.getChildren()) {
                        nodeToLookAT.addFirst(child);
                    }
                } else {
                    //Complete the this
                        if (currentNode.getId().contains("button"))
                            for (Button button : Buttons.buttons) {
                                    System.out.println("yes2");
                                    // complete UI
                                    button.setButton(currentNode);
                                    // modify some properties
                                    List<Property> properties = new ArrayList<>();
                                    TilePane parent = (TilePane) currentNode.getParent();
                                    DoubleProperty xSize = new SimpleDoubleProperty(((100.0 / 4.0) * parent.getWidth()) - parent.getHgap());
                                    properties.add(xSize);
                                    DoubleProperty ySize = new SimpleDoubleProperty(((100.0 / 5.0) * parent.getHeight()) - parent.getVgap());
                                    properties.add(ySize);
                                    DoubleProperty xPos = new SimpleDoubleProperty(0.0);
                                    properties.add(xPos);
                                    DoubleProperty yPos = new SimpleDoubleProperty(0.0);
                                    properties.add(yPos);
                                    CalculatriceController init = new CalculatriceController();
                                    init.setProperties(currentNode, properties);
                        } else if (currentNode.getId().contains("title")) {
                            // modify some properties
                            List<Property> properties = new ArrayList<>();
                            VBox parent = (VBox) currentNode.getParent(); // name parent : frame
                            DoubleProperty xSize = new SimpleDoubleProperty(parent.getWidth());
                            properties.add(xSize);
                            DoubleProperty ySize = new SimpleDoubleProperty(((100.0 / 10.0) * parent.getHeight()));
                            properties.add(ySize);
                            DoubleProperty xPos = new SimpleDoubleProperty(0.0);
                            properties.add(xPos);
                            DoubleProperty yPos = new SimpleDoubleProperty(0.0);
                            properties.add(yPos);

                            CalculatriceController init = new CalculatriceController();
                            init.setProperties(currentNode, properties);
                        }
                }
            }
        }
    }
    public static void createUI (){
        // /!\ Node, Height and Width are added -> method : resetElementTransform
        // create each buttons----------------------------//
        // ----- numbers
        Button one = new Button("Button1", '1');
        Button two = new Button("Button3", '2');
        Button three = new Button("Button3",'3');
        Button four = new Button("Button4", '4');
        Button five = new Button("Button5", '5');
        Button six = new Button("Button6", '6');
        Button seven = new Button("Button7", '7');
        Button eight = new Button("Button8", '8');
        Button nine = new Button("Button9", '9');
        // ----- operators
        Button add = new Button("Button+", '+');
        Button sub = new Button("Button-", '-');
        Button multuply = new Button("Button*", '*');
        Button divide = new Button("Button/", '/');
        // ----- delimiters
        Button openParenthese = new Button("Button(", '(');
        Button closeParenthese = new Button("Button)", '(');

    }
    /** tous les éléments du root de la scène sont redimentionnés lorsque la fênetre change de taille.*/
    public static void responsive(Stage stage, Point2D newTransformSize){
        // get root : get anchor pane
        AnchorPane root = (AnchorPane) stage.getScene().getRoot();

        // get the size of user's device screen
        Screen userScreen = Screen.getPrimary();
        Rectangle2D userScreenSize = userScreen.getBounds();

        // get the percentage of the window compared to the user's device screen
        Double percentageX = (newTransformSize.getX() / userScreenSize.getWidth()) * 100;
        Double percentageY = (newTransformSize.getY() / userScreenSize.getHeight()) * 100;

        // set the children root (panes) position according to the size of the window
        // case 1 : no matter the percentage of y
        if (percentageY >= 0.0 && percentageY <= 100.0){
            for (Node pane : root.getChildren())
                AnchorPane.setTopAnchor(pane, 10.0);
        }
        // case 2 : the width changed several cases must occur
        // -------- case 2.1 : the percentage of x is under 30 percent of the user's window size
        // -------- result 2.1 : the window must have several tabs : MINIMALIST RESULT
        if (percentageX >= 0.0 && percentageX <= 30.00){
            // proceed to create the tabs
            completeUI("MIN",root);
            for (Node pane : root.getChildren()){
                if (!pane.getId().equals("calculator")){ // different because calculator is the main pane
                    Tab tab = new Tab();
                    tab.setContent(pane);
                }
            }
        }
        // -------- case 2.2 : the percentage of x is above 30 percent of the user's window size
        // -------- result 2.2 : one window needed
        else if (percentageX > 30.0) {
            completeUI("MAX",root);
        }
    }
        // getters and setters--------------------------//

    public String getId() {
        return id;
    }

    public void setOldSizeXAbsoluteWindow(int oldSizeXAbsoluteWindow) {
            this.oldSizeXAbsoluteWindow = oldSizeXAbsoluteWindow;
        }

        public void setOldSizeYAbsoluteWindow(int oldSizeYAbsoluteWindow) {
            this.oldSizeYAbsoluteWindow = oldSizeYAbsoluteWindow;
        }
}
