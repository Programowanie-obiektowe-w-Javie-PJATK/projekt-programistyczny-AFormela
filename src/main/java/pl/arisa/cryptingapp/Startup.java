package pl.arisa.cryptingapp;

import pl.arisa.cryptingapp.crypter.CezarCrypter;
import pl.arisa.cryptingapp.crypter.ICrypter;
import pl.arisa.cryptingapp.crypter.MorseCrypter;
import pl.arisa.cryptingapp.view.MainView;

public class Startup {
    public static void main(String[] args) {
        //MainView.show();
        ICrypter crypter = new CezarCrypter();
        System.out.println(crypter.compareCryptedValues("veni", "asdadsx"));
    }
}
