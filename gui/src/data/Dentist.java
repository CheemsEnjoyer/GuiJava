package data;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Dentist {

    public void performMedicalExam() {
        Random random = new Random();
        int whatIsWrongWithMe = random.nextInt(3) + 1;
        if (whatIsWrongWithMe == 1) {
            JOptionPane.showMessageDialog(null,
                    "Хммм, похоже у вас ужасный кариес! Его срочно нужно удалить");
        } else if (whatIsWrongWithMe == 2) {
            JOptionPane.showMessageDialog(null,
                    "Вы выглядите вполне здоровым, но вашим зубам, кхм, определенно не помешает чистка");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Некоторые ваши зубы уже не спасти, их придётся удалить. Не бойтесь, больно не будет!");
        }
    }

    public void removecCaries() {
        Random random = new Random();
        int whatIsWrongWithMe = random.nextInt(3) + 1;
        if (whatIsWrongWithMe == 1) {
            JOptionPane.showMessageDialog(null,
                    "Вам попался хороший врач который быстро и безболезненно убрал кариес," +
                            "вы чувствуете себя намного лучше!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Вы чувствуете неприятный привкус во рту и сильную боль." +
                            "Этот визит вы будете вспоминать еще долго....");
        }
    }

    public void cleanTheTeeths() {
        Random random = new Random();
        int whatIsWrongWithMe = random.nextInt(3) + 1;
        if (whatIsWrongWithMe == 1) {
            JOptionPane.showMessageDialog(null,
                    "Вам хорошо и быстро почистили зубы, вы чувствуете себя как огурчик!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Хоть вам и почистили зубы, вам все же кажется что это можно было сделать менее болезнее");
        }
    }

    public void deleteTheTeeths() {
        Random random = new Random();
        int whatIsWrongWithMe = random.nextInt(3) + 1;
        if (whatIsWrongWithMe == 1) {
            JOptionPane.showMessageDialog(null,
                    "Удаление прошло удачно, хоть вы и отходите от анестезии " +
                            "и чувствуете наступающую боль\"");
        } else {
            JOptionPane.showMessageDialog(null,
                    "..............вы не хотите даже вспоминать прошедшее");
        }
    }
}

