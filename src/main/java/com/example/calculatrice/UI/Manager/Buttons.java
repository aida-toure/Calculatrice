package com.example.calculatrice.UI.Manager;

import com.example.calculatrice.UI.Entities.UI;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Buttons extends UI {
    public static ArrayList<Character> numberChar = new ArrayList<>();
    public static ArrayList<Character> operatorChar = new ArrayList<>();

    public Buttons(Node element) {
        super(element);
//        if (Character.isDigit(()element.getId())){
//            numberChar.add(character);
//        }else{
//            operatorChar.add(character);
//        }
    }
}
