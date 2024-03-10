package view;

import data.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends Window {
    public MainWindow() {
        setTitle("Поликлиника");
        JButton visitDoctorButton = new JButton("Посетить врача!");
        JButton doctorTableButton = new JButton("Просмотреть список врачей!");
        JButton exitButton = new JButton("Выход");
        // Кнопка открытия меню доступных для посещения врачей
        visitDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorMenuWindow doctorMenuWindow = new DoctorMenuWindow();
                doctorMenuWindow.setVisible(true);
                setVisible(false);
            }
        });
        // Кнопка выхода
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Действительно ли вы хотите выйти из приложения?", "Подтверждение",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        // Кнопка для таблицы доступных врачей
        doctorTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorTableWindow doctorTableWindow = new DoctorTableWindow();
                doctorTableWindow.setVisible(true);
                setVisible(false);
            }
        });
        add(visitDoctorButton, BorderLayout.NORTH);
        add(doctorTableButton, BorderLayout.CENTER);
        add(exitButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setSize(400,120);
        setLocation(200,200);
        setVisible(true);
    }
}
