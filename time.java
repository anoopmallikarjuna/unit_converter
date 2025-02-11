package org.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class time extends JFrame {

    String[] units = {"hours (hrs)","minutes(mins.)","seconds (sec.)"};
    Container timeMainContainer, fromContainer, toContainer, calculateContainer;
    JTextField timeFromText, timeToText;
    JComboBox timeFromUnit, timeToUnit;
    JButton timeCalculate, timeExit, timeClear;

    float value;
    public time(){
        timeMainContainer = new Container();
        timeMainContainer.setLayout(new BoxLayout(timeMainContainer,BoxLayout.Y_AXIS));
        setContentPane(timeMainContainer);

        fromContainer = new Container();
        fromContainer.setLayout(new GridLayout(1,2));

        toContainer = new Container();
        toContainer.setLayout(new GridLayout(1,2));

        calculateContainer = new Container();
        calculateContainer.setLayout(new GridLayout(3,1));

        timeMainContainer.add(fromContainer);
        timeMainContainer.add(toContainer);
        timeMainContainer.add(calculateContainer);

        timeFromText = new JTextField();
        timeToText = new JTextField();

        timeFromUnit = new JComboBox(units);
        timeToUnit = new JComboBox(units);

        timeFromText.setEditable(true);
        timeToText.setEditable(false);

        timeCalculate = new JButton("Calculate Result");
        timeExit = new JButton("Exit");
        timeClear = new JButton("Clear");

        fromContainer.add(timeFromText);
        fromContainer.add(timeFromUnit);

        toContainer.add(timeToText);
        toContainer.add(timeToUnit);

        calculateContainer.add(timeCalculate);
        calculateContainer.add(timeClear);
        calculateContainer.add(timeExit);

        //adding actionlistener to lengthClear
        timeClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeFromText.setText(null);
                timeToText.setText(null);
                timeFromUnit.setSelectedIndex(0);
                timeToUnit.setSelectedIndex(0);
            }
        });

        //adding event listener to lengthExit
        timeExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //adding event listener to the lengthCalculate
        timeCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Float.parseFloat(String.valueOf(timeFromText.getText()));

                if(timeFromUnit.getSelectedIndex()==0){
                    if(timeToUnit.getSelectedIndex()==0){
                        timeToText.setText(String.valueOf(value));
                    }

                    if(timeToUnit.getSelectedIndex()==1){
                        timeToText.setText(String.valueOf(value * 60));
                    }

                    if(timeToUnit.getSelectedIndex()==2){
                        timeToText.setText(String.valueOf(value * 3600));
                    }
                } else if (timeFromUnit.getSelectedIndex()==1) {
                    if(timeToUnit.getSelectedIndex()==0){
                        timeToText.setText(String.valueOf(value/60));
                    }

                    if(timeToUnit.getSelectedIndex()==1){
                        timeToText.setText(String.valueOf(value ));
                    }

                    if(timeToUnit.getSelectedIndex()==2){
                        timeToText.setText(String.valueOf(value * 60));
                    }
                }else if (timeFromUnit.getSelectedIndex()==2) {
                    if(timeToUnit.getSelectedIndex()==0){
                        timeToText.setText(String.valueOf(value/3600));
                    }

                    if(timeToUnit.getSelectedIndex()==1){
                        timeToText.setText(String.valueOf(value/60 ));
                    }

                    if(timeToUnit.getSelectedIndex()==2){
                        timeToText.setText(String.valueOf(value ));
                    }
                }
            }
        });
    }
}
