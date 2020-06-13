package pl.arisa.cryptingapp.view;

import pl.arisa.cryptingapp.models.CryptingType;

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
                openCryptingView(CryptingType.MORSE);
            }
            });

        cesarCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCryptingView(CryptingType.CEZAR);
            }
        });

        affineCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCryptingView(CryptingType.AFFINE);
            }
        });

        compareEncryptedTextsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CompareStrings compareStrings = new CompareStrings();
                compareStrings.setVisible(true);
                dispose();
            }
        });
    }

    private void openCryptingView(CryptingType type) {
        App app = new App(type);
        app.setVisible(true);
        dispose();
    }
}

