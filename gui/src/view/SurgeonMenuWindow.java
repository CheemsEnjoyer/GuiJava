package view;

import data.Surgeon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SurgeonMenuWindow extends Window {
    public SurgeonMenuWindow() {
        Surgeon surgeon = new Surgeon();
        setTitle("Хирург");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JButton inspectionButton = new JButton("Осмотр");
        JButton gutsOperation = new JButton("Операция на кишечник");
        JButton heartOperation = new JButton("Операция на сердце");
        JButton jointsOperation = new JButton("Операция на суставах");
        JButton exitButton = new JButton("Назад");
        add(inspectionButton);
        add(gutsOperation);
        add(heartOperation);
        add(jointsOperation);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                DoctorMenuWindow doctorwindow = new DoctorMenuWindow();
                doctorwindow.setVisible(true);
            }
        });
        inspectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                surgeon.performMedicalExam();
            }
        });
        gutsOperation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                surgeon.fixTheStomach();
            }
        });
        heartOperation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                surgeon.fixTheHeart();
            }
        });
        jointsOperation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                surgeon.fixTheJoints();
            }
        });
        setLocation(200,200);
        pack();
    }
}
