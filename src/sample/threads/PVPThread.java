package sample.threads;


import sample.characters.TwoPlayers;



public class PVPThread extends Thread {
TwoPlayers policeman;


    public PVPThread(TwoPlayers policeman) {
        this.policeman = policeman;
    }
    @Override
    public void run() {
        policeman.start();
    }
}
