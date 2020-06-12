package pl.arisa.cryptingapp.view;

import javax.swing.*;

public class CompareStrings extends JFrame {
    private JButton compareTextsButton;
    private JPanel CompareText;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JPanel FirstText;
    private JPanel SecondText;
    private JTextPane ResultPane2;
    private JPanel ResultPanel;
    private JButton returnToMenuButton;
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
