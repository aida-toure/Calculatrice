package com.example.calculatrice.UI.Entities;

import com.example.calculatrice.UI.Manager.UIManager;

import javax.swing.*;

public class Title extends UIManager {
    String zoneText;


    public Title(String id) {
        super(id);
    }

    public void setZoneText(String zoneText) {
        this.zoneText = zoneText;
    }

    public String getZoneText() {
        return zoneText;
    }
}
