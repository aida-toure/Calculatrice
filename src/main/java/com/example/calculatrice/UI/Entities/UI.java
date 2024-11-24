package com.example.calculatrice.UI.Entities;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.Node;

import javafx.scene.control.Label;

import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.util.ArrayList;
import java.util.List;


public class UI {
    // attributes----------------------------------//
    // info related to window
    public static final Integer sizeXAbsoluteWindow = 500;
    public static final Integer sizeYAbsoluteWindow = 600;

    public static Integer oldSizeXAbsoluteWindow = 500;
    public static Integer oldSizeYAbsoluteWindow = 600;
    


    public Node element ;
    // constructor-----------------------------------//
    public UI(Node element){
        this.element = element;
    }

    // methods ---------------------------------------//

    // getters and setters--------------------------//
    public Node getElement() {
        return element;
    }
    public static void setOldSizeXAbsoluteWindow(int oldSizeXAbsoluteWindow) {
        UI.oldSizeXAbsoluteWindow = oldSizeXAbsoluteWindow;
    }

    public static void setOldSizeYAbsoluteWindow(int oldSizeYAbsoluteWindow) {
        UI.oldSizeYAbsoluteWindow = oldSizeYAbsoluteWindow;
    }

    public static int getOldSizeXAbsoluteWindow() {
        return oldSizeXAbsoluteWindow;
    }

    public static int getOldSizeYAbsoluteWindow() {
        return oldSizeYAbsoluteWindow;
    }

}
