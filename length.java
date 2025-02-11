package org.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class length extends JFrame {

    String[] units = {"Kilometers (kms.)","Meters (ms.)","Centimeters (cms.)"};
    Container lengthMainContainer, fromContainer, toContainer, calculateContainer;
    JTextField lengthFromText, lengthToText;
    JComboBox lengthFromUnit, lengthToUnit;
    JButton lengthCalculate, lengthExit, lengthClear;

    float value;
    public length(){
        lengthMainContainer = new Container();
        lengthMainContainer.setLayout(new BoxLayout(lengthMainContainer,BoxLayout.Y_AXIS));
        setContentPane(lengthMainContainer);

        fromContainer = new Container();
        fromContainer.setLayout(new GridLayout(1,2));

        toContainer = new Container();
        toContainer.setLayout(new GridLayout(1,2));

        calculateContainer = new Container();
        calculateContainer.setLayout(new GridLayout(3,1));

        lengthMainContainer.add(fromContainer);
        lengthMainContainer.add(toContainer);
        lengthMainContainer.add(calculateContainer);

        lengthFromText = new JTextField();
        lengthToText = new JTextField();

        lengthFromUnit = new JComboBox(units);
        lengthToUnit = new JComboBox(units);

        lengthFromText.setEditable(true);
        lengthToText.setEditable(false);

        lengthCalculate = new JButton("Calculate Result");
        lengthExit = new JButton("Exit");
        lengthClear = new JButton("Clear");

        fromContainer.add(lengthFromText);
        fromContainer.add(lengthFromUnit);

        toContainer.add(lengthToText);
        toContainer.add(lengthToUnit);

        calculateContainer.add(lengthCalculate);
        calculateContainer.add(lengthClear);
        calculateContainer.add(lengthExit);

        //adding actionlistener to lengthClear
        lengthClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lengthFromText.setText(null);
                lengthToText.setText(null);
                lengthFromUnit.setSelectedIndex(0);
                lengthToUnit.setSelectedIndex(0);
            }
        });

        //adding event listener to lengthExit
        lengthExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //adding event listener to the lengthCalculate
        lengthCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Float.parseFloat(String.valueOf(lengthFromText.getText()));

                if(lengthFromUnit.getSelectedIndex()==0){
                    if(lengthToUnit.getSelectedIndex()==0){
                        lengthToText.setText(String.valueOf(value));
                    }

                    if(lengthToUnit.getSelectedIndex()==1){
                        lengthToText.setText(String.valueOf(value * 1000));
                    }

                    if(lengthToUnit.getSelectedIndex()==2){
                        lengthToText.setText(String.valueOf(value * 100000));
                    }
                } else if (lengthFromUnit.getSelectedIndex()==1) {
                    if(lengthToUnit.getSelectedIndex()==0){
                        lengthToText.setText(String.valueOf(value/1000));
                    }

                    if(lengthToUnit.getSelectedIndex()==1){
                        lengthToText.setText(String.valueOf(value ));
                    }

                    if(lengthToUnit.getSelectedIndex()==2){
                        lengthToText.setText(String.valueOf(value * 100));
                    }
                } else if (lengthFromUnit.getSelectedIndex()==2) {
                    if(lengthToUnit.getSelectedIndex()==0){
                        lengthToText.setText(String.valueOf(value/100000));
                    }

                    if(lengthToUnit.getSelectedIndex()==1){
                        lengthToText.setText(String.valueOf(value * 100));
                    }

                    if(lengthToUnit.getSelectedIndex()==2){
                        lengthToText.setText(String.valueOf(value ));
                    }
                }
            }
        });
    }
}
