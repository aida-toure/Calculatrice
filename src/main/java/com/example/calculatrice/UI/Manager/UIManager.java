package com.example.calculatrice.UI.Manager;

import com.example.calculatrice.UI.Entities.UI;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Affine;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;

public class UIManager {
    ArrayList<Tab> tabs = new ArrayList<>();
    public static void setProperties(Node node) {
        if (node.getId().equals("calculator")) {

        }else if (node.getId().equals("history")) {

        }else if (node.getId().equals("title")) {
            Label title = (Label) node;
            VBox parent = (VBox) node.getParent();
            title.prefWidth(parent.getWidth());
            title.prefHeight((double)(10/100) * parent.getHeight()); // 10 percent of the user's screen height size
        }else if (node.getId().equals("frame")){
            VBox layout = (VBox) node;
            AnchorPane parent = (AnchorPane) layout.getParent();

            layout.prefWidth(500);
            layout.prefHeight(parent.getHeight()); // 10 percent of the user's screen height size

            System.out.println(layout.getWidth());
            System.out.println(parent.getWidth());
        }else if (node.getId().equals("layout")){ // aka calculator screen
            node = (Pane) node;
            for (Node child1 : ((Pane) node).getChildren()){
                if (child1.getId().equals("buttons")){
                    TilePane buttons = (TilePane) child1;
                    buttons.prefWidth(buttons.getParent().getTranslateX());
                    buttons.prefHeight((double) (75/100)*buttons.getParent().getTranslateY());
                    buttons.setTranslateX(0);
                    buttons.setTranslateY(0);
                    buttons.setHgap(10);
                    buttons.setVgap(10);
                    for (Node child2 : buttons.getChildren()) {
                        if (child2.getId().contains("button")) {
                            Label button = (Label) child2;
                            button.prefWidth((double) (20/100)*buttons.getTranslateX() - buttons.getHgap());
                            button.prefHeight((double) (25/100)*buttons.getTranslateY() - buttons.getVgap());
                            button.setTranslateX(0);
                            button.setTranslateY(0);
                        }
                    }
                } else if (child1.getId().equals("result")) {
                    child1.prefWidth(UI.sizeXAbsoluteWindow);
                    child1.prefHeight((double) (24/100)*UI.sizeYAbsoluteWindow);
                    child1.setTranslateX(0);
                    child1.setTranslateY(0);
                }
            }
        }
    }
    protected static void resetElementTransform(String renderChoice, AnchorPane root){
        //set the size of the panes  & bend the children's size (nodes except pane) to the parent
        root.prefWidth(UI.sizeXAbsoluteWindow);
        root.prefHeight(UI.sizeYAbsoluteWindow); // 10 percent of the user's screen height size

        root.setTranslateX(0);
        root.setTranslateY(0);
        if (renderChoice.equals("MIN")){
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
                    // redimentionner à son parent
                    setProperties(currentNode);
                }
            }
        }
    }
    public static void createUI (Stage stage){
        AnchorPane root = (AnchorPane) stage.getScene().getRoot();

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
            // get the length of the root pane to get the number of the tabs needed
            int lengthRoot = root.getChildren().size();
            // proceed to create the tabs
            for (Node pane : root.getChildren()){
                if (!pane.getId().equals("calculator")){
                    Tab tab = new Tab();
                    resetElementTransform("MIN",root);
                    tab.setContent(pane);
                }
            }
        }
        // -------- case 2.2 : the percentage of x is above 30 percent of the user's window size
        // -------- result 2.2 : one window needed


    }
    public static void reduce(){

    }
}
