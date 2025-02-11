package org.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame{
    public JFrame mainframe;

    //converters
    public JButton Length, Mass, Volume, Time;
    public Home(){
        mainframe = new JFrame("Unit Converter");

        //set the layout for the mainframe
        mainframe.setLayout(new GridLayout(2,2));
        //setting up the Jframe
        mainframe.setSize(700,350);

        mainframe.setVisible(true);
        //when the close button is hit the J Frame will gets closed completely
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Length = new JButton("Length Converter");
        Mass = new JButton("Mass Converter");
        Volume = new JButton("Volume Converter");
        Time = new JButton("Time Converter");

        mainframe.add(Length);//adds the length button
        mainframe.add(Mass);//adds the mass button
        mainframe.add(Volume);//adds the volume button
        mainframe.add(Time);//adds the time button

        //set actionlisteners for all the buttons

        Length.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                length length = new length();
                length.setTitle("Length Converter");//title of the window
                length.setSize(700,350);
                length.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//only close the current window
                length.setVisible(true);

            }
        });

        Mass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mass mass = new mass();
                mass.setTitle("Mass Converter");//title of the window
                mass.setSize(700,350);
                mass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//only close the current window
                mass.setVisible(true);
            }
        });

        Volume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volume volume = new volume();
                volume.setTitle("Volume Converter");
                volume.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                volume.setSize(700,350);
                volume.setVisible(true);
            }
        });

        Time.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time time = new time();
                time.setTitle("Time Converter");
                time.setSize(700,350);
                time.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                time.setVisible(true);
            }
        });
        mainframe.pack();
    }

    //main method
    public static void main(String[] args) {
        new Home();
    }



}