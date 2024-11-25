package com.example.calculatrice.UI.Entities;

import com.example.calculatrice.UI.Manager.UIManager;
import javafx.scene.Node;
import java.util.ArrayList;

public class Button extends UIManager {
    public Node button;
    public char character;


    public Button(String id, char character) {
        super(id);
        this.character = character;

        // add to buttons to array lists
        Buttons.buttons.add(this);
        if (Character.isDigit(character)){
            Buttons.numbers.add(this);
        } else if (this.isOperator(character)) {
            Buttons.operators.add(this);
        } else if (this.isDelimiter(character)){
            Buttons.delimiters.add(this);
        }
    }
    private Boolean isOperator(char characterToCheck){
        Boolean isOperator = false;

        ArrayList<Character> operators = new ArrayList<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        for (char operator : operators){
            if (characterToCheck == operator){
                isOperator = true;
            }
        }
        return  isOperator;
    }
    private Boolean isDelimiter(char characterToCheck){
        Boolean isDelimiter = false;

        ArrayList<Character> operators = new ArrayList<>();
        operators.add('(');
        operators.add(')');

        for (char operator : operators){
            if (characterToCheck == operator){
                isDelimiter = true;
            }
        }
        return  isDelimiter;
    }

    public Node getButton() {
        return button;
    }

    public void setButton(Node button) {
        this.button = button;
    }
}
