package ca.dal.cs.csci3130.designpatterns.adapter;

public class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        System.out.println("VLC: playing " + fileName);
    }

    @Override
    public void playMP4(String fileName) {
        //do nothing
        //potentially refused bequest code smell!
    }
}
