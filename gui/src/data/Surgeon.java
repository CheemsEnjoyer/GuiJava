package data;

import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class Surgeon {



    public void performMedicalExam() {
        Random random = new Random();
        int whatIsWrongWithMe = random.nextInt(3) + 1;
        if (whatIsWrongWithMe == 1) {
            JOptionPane.showMessageDialog(null,
                    "У вас присуствуют проблемы с желудком, срочно сделайте операцию на него!");
        } else if (whatIsWrongWithMe == 2) {
            JOptionPane.showMessageDialog(null,
                    "У вас присуствуют проблемы с сердцем, сделайте операцию или умретё!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "У вас больные суставы, сделайте операцию на них и они перестанут болеть!");
        }
    }

    public void fixTheStomach() {
        Random random = new Random();
        int whatIsWrongWithMe = random.nextInt(2) + 1;
        if (whatIsWrongWithMe == 1) {
            JOptionPane.showMessageDialog(null,
                    "У вас был обнаружен гастрит и вы успешно сделали операцию на него!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Вам сделали легкую операцию на аппендикс и вы отлично себя чувствуете," +
                            "хоть и вам кажется что вы схуднули");
        }
    }

    public void fixTheHeart() {
        Random random = new Random();
        int whatIsWrongWithMe = random.nextInt(2) + 1;
        if (whatIsWrongWithMe == 1) {
            JOptionPane.showMessageDialog(null,
                    "Вам сделали коронарное шунтирование и вы уже чувствуете как улучшилось ваше кровеообращение");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Проблемы были, кхм, *немного* хуже чем вам казалось и вам вставили новое сердце");
        }
    }

    public void fixTheJoints() {
        Random random = new Random();
        int whatIsWrongWithMe = random.nextInt(2) + 1;
        if (whatIsWrongWithMe == 1) {
            JOptionPane.showMessageDialog(null,
                    "У вас были слегка повреждены внутренние части суставов и вам " +
                            "сделали артроскопическое лечение суставов");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Вы и сами не знаете как так случилось, но вы не заметили что у вас отсуствуют некоторые суставы " +
                            "до недавнего осмотра, вам сделали замену суставов + и вы отлично себя чувствуете");
        }
    }
}
