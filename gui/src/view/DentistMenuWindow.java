package view;

import data.Dentist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DentistMenuWindow extends Window {
    public DentistMenuWindow() {
        Dentist dentist = new Dentist();
        setTitle("Стоматолог");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JButton inspectionButton = new JButton("Осмотр");
        JButton removeCariesButton = new JButton("Удалить кариес");
        JButton teethCleaningButton = new JButton("Почистить зубы");
        JButton deleteTeethButton = new JButton("Удаление зубов");
        JButton exitButton = new JButton("Назад");
        add(inspectionButton);
        add(removeCariesButton);
        add(teethCleaningButton);
        add(deleteTeethButton);
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
                dentist.performMedicalExam();
            }
        });
        removeCariesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dentist.removecCaries();
            }
        });
        teethCleaningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dentist.cleanTheTeeths();
            }
        });
        deleteTeethButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dentist.deleteTheTeeths();
            }
        });
        setLocation(200,200);
        pack();
    }
}
