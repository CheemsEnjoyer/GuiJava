package view;

import data.Ophomotolagist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OphomotolagistMenuWindow extends Window {
    public OphomotolagistMenuWindow() {
        Ophomotolagist ophomotolagist = new Ophomotolagist();
        setTitle("Офтальмолог");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JButton inspectionButton = new JButton("Осмотр");
        JButton fixEyesButton = new JButton("Коррекция зрения");
        JButton buyGooglesButton = new JButton("Купить очки");
        JButton exitButton = new JButton("Назад");
        add(inspectionButton);
        add(fixEyesButton);
        add(buyGooglesButton);
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
                ophomotolagist.performMedicalExam();
            }
        });
        fixEyesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ophomotolagist.correctEyes();
            }
        });
        buyGooglesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ophomotolagist.buyGlasses();
            }
        });
        setLocation(200,200);
        pack();
    }
}
