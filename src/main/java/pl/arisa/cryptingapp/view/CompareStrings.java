package pl.arisa.cryptingapp.view;

import pl.arisa.cryptingapp.crypter.Crypter;
import pl.arisa.cryptingapp.crypter.ICrypter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompareStrings extends JFrame {
    private JButton compareTextsButton;
    private JPanel CompareText;
    private JTextPane SecondText;
    private JTextPane FirstText;
    private JPanel FirstTextPanel;
    private JPanel SecondTextPanel;
    private JTextPane ResultPane2;
    private JPanel ResultPanel;
    private JButton returnToMenuButton;
    private JLabel CompareInsertedTexts;
    private JPanel appPanel;

    public CompareStrings() {
        add(CompareText);
        setTitle("CryptingApp");
        setSize(400, 500);
        setContentPane(CompareText);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        compareTextsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ICrypter crypter = new Crypter();
                String result = crypter.compareCryptedValues(FirstText.getText(), SecondText.getText());
                ResultPane2.setText(result);
            }
        });

        returnToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu menu = new MainMenu();
                menu.setVisible(true);
                dispose();
            }
        });
    }
}
