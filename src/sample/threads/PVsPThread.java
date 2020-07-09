package sample.threads;


import sample.characters.PlayerVsPlayer;



public class PVsPThread extends Thread {
PlayerVsPlayer policeman;


    public PVsPThread(PlayerVsPlayer policeman) {
        this.policeman = policeman;
    }
    @Override
    public void run() {
        policeman.start();
    }
}
