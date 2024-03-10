package view;

import data.Doctor;
import data.DoctorTableModel;
import data.Repository;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DoctorTableWindow extends Window {
    private JTable jTable;

    public DoctorTableWindow() {
        setTitle("Список врачей");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаем таблицу
        JTable table = new JTable();

        // Создаем модель таблицы
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Имя");
        model.addColumn("Специализация");
        model.addColumn("Количество посещений");

        String filePath = "src/listOfDoctors.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String specialization = parts[2].trim();
                    int visitCount = Integer.parseInt(parts[3].trim());
                    model.addRow(new Object[]{id, name, specialization, visitCount});
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        // Кнопка "Назад"
        JButton backButton = new JButton("Назад");
        backButton.addActionListener(e -> {
            setVisible(false);
            new MainWindow().setVisible(true);
        });

        add(backButton, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
