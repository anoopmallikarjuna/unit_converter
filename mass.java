package org.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mass extends JFrame {

    String[] units = {"Kilograms (kgs.)","grams (ms.)"};
    Container massMainContainer, fromContainer, toContainer, calculateContainer;
    JTextField massFromText, massToText;
    JComboBox massFromUnit, massToUnit;
    JButton massCalculate, massExit, massClear;

    float value;
    public mass(){
        massMainContainer = new Container();
        massMainContainer.setLayout(new BoxLayout(massMainContainer,BoxLayout.Y_AXIS));
        setContentPane(massMainContainer);

        fromContainer = new Container();
        fromContainer.setLayout(new GridLayout(1,2));

        toContainer = new Container();
        toContainer.setLayout(new GridLayout(1,2));

        calculateContainer = new Container();
        calculateContainer.setLayout(new GridLayout(3,1));

        massMainContainer.add(fromContainer);
        massMainContainer.add(toContainer);
        massMainContainer.add(calculateContainer);

        massFromText = new JTextField();
        massToText = new JTextField();

        massFromUnit = new JComboBox(units);
        massToUnit = new JComboBox(units);

        massFromText.setEditable(true);
        massToText.setEditable(false);

        massCalculate = new JButton("Calculate Result");
        massExit = new JButton("Exit");
        massClear = new JButton("Clear");

        fromContainer.add(massFromText);
        fromContainer.add(massFromUnit);

        toContainer.add(massToText);
        toContainer.add(massToUnit);

        calculateContainer.add(massCalculate);
        calculateContainer.add(massClear);
        calculateContainer.add(massExit);

        //adding actionlistener to lengthClear
        massClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                massFromText.setText(null);
                massToText.setText(null);
                massFromUnit.setSelectedIndex(0);
                massToUnit.setSelectedIndex(0);
            }
        });

        //adding event listener to lengthExit
        massExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //adding event listener to the lengthCalculate
        massCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Float.parseFloat(String.valueOf(massFromText.getText()));

                if(massFromUnit.getSelectedIndex()==0){
                    if(massToUnit.getSelectedIndex()==0){
                        massToText.setText(String.valueOf(value));
                    }

                    if(massToUnit.getSelectedIndex()==1){
                        massToText.setText(String.valueOf(value * 1000));
                    }
                } else if (massFromUnit.getSelectedIndex()==1) {
                    if(massToUnit.getSelectedIndex()==0){
                        massToText.setText(String.valueOf(value/1000));
                    }

                    if(massToUnit.getSelectedIndex()==1){
                        massToText.setText(String.valueOf(value ));
                    }
                }
            }
        });
    }
}
