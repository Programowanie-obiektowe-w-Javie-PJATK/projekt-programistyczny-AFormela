package pl.arisa.cryptingapp.view;

import javax.swing.*;

public class CompareStrings extends JFrame{
    private JButton compareTextsButton;
    private JTextField Result;
    private JPanel CompareText;
    private JTextField SecondText;
    private JTextField FirstText;
    private JLabel aLabel;
    private JLabel bLabel;
    private JPanel appPanel;


        public CompareStrings() {
            add(CompareText);
            setTitle("CryptingApp");
            setSize(400, 500);
            setContentPane(CompareText);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
        }
    }
