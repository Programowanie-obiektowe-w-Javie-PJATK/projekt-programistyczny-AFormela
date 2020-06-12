package pl.arisa.cryptingapp.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JPanel MainPage;
    private JButton morseCodeButton;
    private JButton affineCodeButton;
    private JButton cesarCodeButton;
    private JLabel CryptingApp;
    private JButton compareEncryptedTextsButton;
    private JPanel appPanel;

    public MainMenu() {
        add(MainPage);
        setTitle("CryptingApp");
        setSize(400,500);
        setContentPane(MainPage);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        morseCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
            });
    }
}

