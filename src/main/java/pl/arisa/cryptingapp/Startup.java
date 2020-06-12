package pl.arisa.cryptingapp;

import pl.arisa.cryptingapp.view.App;
import pl.arisa.cryptingapp.view.CompareStrings;
import pl.arisa.cryptingapp.view.MainMenu;

public class Startup {
    public static void main(String[] args) {
        //MainView.show();
        //ICrypter crypter = new CezarCrypter();
        //System.out.println(crypter.compareCryptedValues("veni", "asdadsx"));

        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
    }
}
