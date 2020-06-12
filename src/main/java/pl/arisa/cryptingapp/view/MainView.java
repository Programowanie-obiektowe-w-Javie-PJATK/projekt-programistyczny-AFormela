package pl.arisa.cryptingapp.view;

import javax.swing.*;
import java.awt.*;

public class MainView {
    public static void show() {
        final int WIDTH = 1000;
        final int HEIGHT = 600;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setSize(WIDTH,HEIGHT);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setTitle("Crypting App");


                Container container = new Container();
                container.setLayout(null);
                frame.setContentPane(container);

                JLabel title = new JLabel("Crypt/decrypt your text!");
                title.setFont(new Font("Arial", Font.BOLD, 24));
                title.setSize(800, 24);
                title.setLocation(10, 10);
                container.add(title);

                JLabel text = new JLabel("Text");
                text.setFont(new Font("Arial", Font.PLAIN, 20));
                text.setSize(100, 20);
                text.setLocation(10, 40);
                container.add(text);

                JTextArea fieldText = new JTextArea();
                fieldText.setFont(new Font("Arial", Font.PLAIN, 15));
                fieldText.setSize(400, 60);
                fieldText.setLocation(10, 70);
                container.add(fieldText);

                JRadioButton cezarChooseButton = new JRadioButton("Cezar");
                cezarChooseButton.setFont(new Font("Arial", Font.PLAIN, 15));
                cezarChooseButton.setSelected(true);
                cezarChooseButton.setSize(80, 20);
                cezarChooseButton.setLocation(10, 160);
                container.add(cezarChooseButton);

                JRadioButton morseChooseButton = new JRadioButton("Morse");
                morseChooseButton.setFont(new Font("Arial", Font.PLAIN, 15));
                morseChooseButton.setSelected(true);
                morseChooseButton.setSize(80, 20);
                morseChooseButton.setLocation(100, 160);
                container.add(morseChooseButton);

                ButtonGroup chooseCryptingType = new ButtonGroup();
                chooseCryptingType.add(cezarChooseButton);
                chooseCryptingType.add(morseChooseButton);

                JButton cryptButton = new JButton("Crypt");
                cryptButton.setFont(new Font("Arial", Font.PLAIN, 15));
                cryptButton.setSize(100, 20);
                cryptButton.setLocation(50, 200);
                container.add(cryptButton);
            }
        });
    }


}
