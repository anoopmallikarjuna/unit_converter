package org.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class volume extends JFrame {

    String[] units = {"litre (ltr)","millilitre(ml)",};
    Container volumeMainContainer, fromContainer, toContainer, calculateContainer;
    JTextField volumeFromText, volumeToText;
    JComboBox volumeFromUnit, volumeToUnit;
    JButton volumeCalculate, volumeExit, volumeClear;

    float value;
    public volume(){
        volumeMainContainer = new Container();
        volumeMainContainer.setLayout(new BoxLayout(volumeMainContainer,BoxLayout.Y_AXIS));
        setContentPane(volumeMainContainer);

        fromContainer = new Container();
        fromContainer.setLayout(new GridLayout(1,2));

        toContainer = new Container();
        toContainer.setLayout(new GridLayout(1,2));

        calculateContainer = new Container();
        calculateContainer.setLayout(new GridLayout(3,1));

        volumeMainContainer.add(fromContainer);
        volumeMainContainer.add(toContainer);
        volumeMainContainer.add(calculateContainer);

        volumeFromText = new JTextField();
        volumeToText = new JTextField();

        volumeFromUnit = new JComboBox(units);
        volumeToUnit = new JComboBox(units);

        volumeFromText.setEditable(true);
        volumeToText.setEditable(false);

        volumeCalculate = new JButton("Calculate Result");
        volumeExit = new JButton("Exit");
        volumeClear = new JButton("Clear");

        fromContainer.add(volumeFromText);
        fromContainer.add(volumeFromUnit);

        toContainer.add(volumeToText);
        toContainer.add(volumeToUnit);

        calculateContainer.add(volumeCalculate);
        calculateContainer.add(volumeClear);
        calculateContainer.add(volumeExit);

        //adding actionlistener to lengthClear
        volumeClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volumeFromText.setText(null);
                volumeToText.setText(null);
                volumeFromUnit.setSelectedIndex(0);
                volumeToUnit.setSelectedIndex(0);
            }
        });

        //adding event listener to lengthExit
        volumeExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //adding event listener to the lengthCalculate
        volumeCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Float.parseFloat(String.valueOf(volumeFromText.getText()));

                if(volumeFromUnit.getSelectedIndex()==0){
                    if(volumeToUnit.getSelectedIndex()==0){
                        volumeToText.setText(String.valueOf(value));
                    }

                    if(volumeToUnit.getSelectedIndex()==1){
                        volumeToText.setText(String.valueOf(value * 1000));
                    }

                } else if (volumeFromUnit.getSelectedIndex()==1) {
                    if(volumeToUnit.getSelectedIndex()==0){
                        volumeToText.setText(String.valueOf(value/1000));
                    }

                    if(volumeToUnit.getSelectedIndex()==1){
                        volumeToText.setText(String.valueOf(value ));
                    }

                }
            }
        });
    }
}
