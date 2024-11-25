package com.example.calculatrice.UI.Entities;

import com.example.calculatrice.UI.Manager.UIManager;

import javax.swing.*;
import java.util.ArrayList;

public class Buttons extends UIManager {
    public static ArrayList<Button> buttons = new ArrayList<>();
    public static ArrayList<Button> numbers = new ArrayList<>();
    public static ArrayList<Button> operators = new ArrayList<>();
    public static ArrayList<Button> delimiters = new ArrayList<>();

    public Buttons(String id) {
        super(id);
    }
}
