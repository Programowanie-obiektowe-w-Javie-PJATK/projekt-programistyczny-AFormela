package pl.arisa.cryptingapp.view;

import pl.arisa.cryptingapp.crypter.CezarCrypter;
import pl.arisa.cryptingapp.crypter.Crypter;
import pl.arisa.cryptingapp.crypter.ICrypter;
import pl.arisa.cryptingapp.crypter.MorseCrypter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompareStrings extends JFrame {
    private JButton compareTextsButton;
    private JPanel CompareText;
    private JTextArea SecondText;
    private JTextArea FirstText;
    private JPanel FirstTextPanel;
    private JPanel SecondTextPanel;
    private JTextPane ResultPane2;
    private JPanel ResultPanel;
    private JButton returnToMenuButton;
    private JLabel CompareInsertedTexts;
    private JScrollPane scrolling;
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
                String result = "";
                try {
                    String value1 = cryptWithCorrectCrypter(FirstText.getText());
                    String value2 = cryptWithCorrectCrypter(SecondText.getText());

                    result = crypter.compareCryptedValues(value1, value2);
                } catch (Exception exception) {
                    result = exception.getMessage();
                }
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

    private String cryptWithCorrectCrypter(String value) {
        ICrypter crypter;
        if(value.contains(".") || value.contains("-")) crypter = new MorseCrypter();
        else crypter = new CezarCrypter();

        return crypter.decrypt(value);
    }
}
