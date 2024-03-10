package data;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ophomotolagist {

    public void performMedicalExam() {
        Random random = new Random();
        int whatIsWrongWithMe = random.nextInt(3) + 1;
        if (whatIsWrongWithMe == 1) {
            JOptionPane.showMessageDialog(null,
                    "У вас все хорошо со зрением, можно не беспокоиться");
        } else if (whatIsWrongWithMe == 2) {
            JOptionPane.showMessageDialog(null,
                    "К сожалению у вас плохое зрение, но вы можете сделать коррекцию зрения");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Кхм, вы не заметили что у вас отсуствует глаз, но теперь вы узнали..?");
        }
    }

    public void correctEyes() {
        Random random = new Random();
        int whatIsWrongWithMe = random.nextInt(3) + 1;
        if (whatIsWrongWithMe == 1) {
            JOptionPane.showMessageDialog(null,
                    "Операция прошла хорошо, вам вернулось зрение и вы не можете поверить своим глазам\"");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Вам немного неудобно, но в целом операция прошла хорошо\"");
        }
    }

    public void buyGlasses() {
        Random random = new Random();
        int whatIsWrongWithMe = random.nextInt(3) + 1;
        if (whatIsWrongWithMe == 1) {
            JOptionPane.showMessageDialog(null,
                    "Вы купили новые очки и все хорошо видите, хотя и не понимаете " +
                            "как вы сделали это у окулиста");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Неожиданно, но у окулист нельзя купить очки и вас обманули на деньги");
        }
    }
}
