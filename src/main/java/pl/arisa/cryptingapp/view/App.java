package pl.arisa.cryptingapp.view;

import pl.arisa.cryptingapp.crypter.CezarCrypter;
import pl.arisa.cryptingapp.crypter.Crypter;
import pl.arisa.cryptingapp.crypter.ICrypter;
import pl.arisa.cryptingapp.crypter.MorseCrypter;
import pl.arisa.cryptingapp.fileManager.FileManager;
import pl.arisa.cryptingapp.models.CryptingType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static java.lang.Integer.parseInt;

public class App extends JFrame {
    private JLabel MethodName;
    private JPanel CryptoMethod;
    private JPanel InputTextPanel;
    private JPanel OutputTextPanel;
    private JTextPane InputText;
    private JTextPane OutputText;
    private JButton saveToFileButton;
    private JButton decryptButton;
    private JButton encryptButton;
    private JButton readFromFileButton;
    private JButton mainMenuButton;
    private JTextField aValue;
    private JTextField bValue;
    private JLabel aLabel;
    private JLabel bLabel;
    private JPanel appPanel;
    private ICrypter crypter;
    private CryptingType cryptingType;

    public App(CryptingType cryptingType) {
        add(CryptoMethod);
        setTitle("CryptingApp");
        setSize(400, 500);
        MethodName.setText(cryptingType.toString());
        setContentPane(CryptoMethod);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        this.cryptingType = cryptingType;

        switch (cryptingType) {
            case CEZAR:
            case AFFINE:
                crypter = new CezarCrypter();
                break;
            case MORSE:
                crypter = new MorseCrypter();
                break;
            default:
                crypter = new Crypter();
                break;
        }

        if(cryptingType != CryptingType.AFFINE) {
            aValue.setVisible(false);
            aLabel.setVisible(false);
            bValue.setVisible(false);
            bLabel.setVisible(false);
        }

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu menu = new MainMenu();
                menu.setVisible(true);
                dispose();
            }
        });

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result;
                if(cryptingType == CryptingType.AFFINE && !aValue.getText().isEmpty() && !bValue.getText().isEmpty()) {
                    result = crypter.crypt(InputText.getText(), parseInt(aValue.getText()), parseInt(bValue.getText()));
                } else {
                    result = crypter.crypt(InputText.getText());
                }
                OutputText.setText(result);

            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result;
                if(cryptingType == CryptingType.AFFINE && !aValue.getText().isEmpty() && !bValue.getText().isEmpty()) {
                    result = crypter.decrypt(InputText.getText(), parseInt(aValue.getText()), parseInt(bValue.getText()));
                } else {
                    result = crypter.decrypt(InputText.getText());
                }
                OutputText.setText(result);
            }
        });

        readFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a file to load");

                int userSelection = fileChooser.showOpenDialog(getContentPane());
                if(userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToLoad = fileChooser.getSelectedFile();
                    FileManager fileManager = new FileManager(fileToLoad.getPath());
                    InputText.setText(fileManager.loadFromFile());
                }
            }
        });

        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a file to save");

                int userSelection = fileChooser.showSaveDialog(getContentPane());
                if(userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToLoad = fileChooser.getSelectedFile();
                    FileManager fileManager = new FileManager(fileToLoad);
                    fileManager.saveToFile(OutputText.getText());
                }
            }
        });
    }
}