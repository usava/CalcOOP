package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Commander implements ActionListener
{
    JTextField textField = null;
    Calculator calc = null;

    public Commander(JTextField textField) {
        this.textField = textField;
        this.calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        try {
            textField.setText(calc.eventAction(e.getActionCommand()));
        } catch (Exception e1) {
            textField.setText("Error");
        }
    }
}
