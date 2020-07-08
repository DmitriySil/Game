package sample.threads;

import sample.characters.Characters;
import sample.characters.Policeman;
import sample.characters.Terrorist;

public class PoliceThread extends Thread {
Policeman policeman;


    public PoliceThread(Policeman policeman) {
        this.policeman = policeman;
    }
    @Override
    public void run() {
        policeman.start();
    }
}
