package pl.arisa.cryptingapp.view;

import javax.swing.*;

public class App extends JFrame {
    private JLabel MethodName;
    private JPanel CryptoMethod;
    private JTextField InputText;
    private JTextField OutputText;
    private JButton saveToFileButton;
    private JButton decryptButton;
    private JButton encryptButton;
    private JButton readFromFileButton;
    private JButton mainMenuButton;
    private JTextField aValue;
    private JTextField bValue;
    private JPanel appPanel;

    public App() {
        add(CryptoMethod);
        setTitle("CryptingApp");
        setSize(400, 500);
        setContentPane(CryptoMethod);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}