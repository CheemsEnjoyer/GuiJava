package view;
import data.Doctor;
import data.DoctorRepositoryImp;
import data.DoctorTableModel;
import data.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class DoctorMenuWindow extends Window {
    private JTable jTable;
    public DoctorMenuWindow() {
        Random random = new Random();
        Repository doctorRepository = new DoctorRepositoryImp();
        setTitle("Врач");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JButton visitSurgeonButton = new JButton("Хирург");
        JButton visitDentistButton = new JButton("Стоматолог");
        JButton visitOphthalmologistButton = new JButton("Офтальмолог");
        JButton exitButton = new JButton("Назад");
        add(visitSurgeonButton);
        add(visitDentistButton);
        add(visitOphthalmologistButton);
        add(exitButton);
        // Кнопка назад
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
        // Кнопка посещения хирурга
        visitSurgeonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomIndex = random.nextInt(doctorRepository.getCount());
                Doctor surgeon = doctorRepository.findById(randomIndex);
                if (surgeon != null && surgeon.getSpecialization().equals("Хирург")) {
                    surgeon.incrementVisitsCount();
                    doctorRepository.update(surgeon);
                    String surgeonName = surgeon.getName();
                    String message = "Вас будет обследовать врач " + surgeonName;
                    JOptionPane.showMessageDialog(null, message);

                    SurgeonMenuWindow surgeonMenuWindow = new SurgeonMenuWindow();
                    surgeonMenuWindow.setVisible(true);
                    setVisible(false);
                } else {
                    String message = "К сожалению, последний хирург уволился 2 недели назад, попробуйте в следующий раз!";
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        });
        // Кнопка посещения стоматолога
        visitDentistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomIndex = random.nextInt(doctorRepository.getCount());
                Doctor dentist = doctorRepository.findById(randomIndex);

                // Проверяем, был ли найден стоматолог
                if (dentist != null && dentist.getSpecialization().equals("Стоматолог")) {
                    dentist.incrementVisitsCount();
                    doctorRepository.update(dentist);
                    String dentistName = dentist.getName();
                    String message = "Вас будет обследовать врач " + dentistName;
                    JOptionPane.showMessageDialog(null, message);

                    DentistMenuWindow dentistMenuWindow = new DentistMenuWindow();
                    dentistMenuWindow.setVisible(true);
                    setVisible(false);
                } else {
                    String message = "К сожалению, все стоматологи ушли в частные клиники, но может он найдется в следующий раз!";
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        });

        // Кнопка посещения окулиста
        visitOphthalmologistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomIndex = random.nextInt(doctorRepository.getCount());
                Doctor ophthalmologist = doctorRepository.findById(randomIndex);
                // Проверяем, был ли найден офтальмолог
                if (ophthalmologist != null && ophthalmologist.getSpecialization().equals("Офтальмолог")) {
                    ophthalmologist.incrementVisitsCount();
                    doctorRepository.update(ophthalmologist);
                    String ophthalmologistName = ophthalmologist.getName();
                    String message = "Вас будет обследовать врач " + ophthalmologistName;
                    JOptionPane.showMessageDialog(null, message);

                    OphomotolagistMenuWindow ophthalmologistMenuWindow = new OphomotolagistMenuWindow();
                    ophthalmologistMenuWindow.setVisible(true);
                    setVisible(false);
                } else {
                    String message = "К сожалению, все офтальмологи ушли работать в клинику коррекции зрения....";
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        });
        setLocationByPlatform(true);
        setLocation(200,200);
        pack();
    }
}
