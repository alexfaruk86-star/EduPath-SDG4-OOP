package gui;

import javax.swing.*;
import model.*;

public class EduPathGUI {


    public static void main(String[] args) {


        JFrame frame = new JFrame("EduPath - SDG 4 Quality Education");

        frame.setSize(500,400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JTextArea area = new JTextArea();

        area.setText(
                "===== EduPath SDG 4 =====\n\n" +
                "Quality Education Platform\n\n" +
                "Course: Java Programming\n" +
                "Teacher: Dr Ahmad\n" +
                "Student: Alex\n\n" +
                "Completion: 80%\n" +
                "Quiz Score: 9/10\n"
        );


        frame.add(area);

        frame.setVisible(true);

    }

}