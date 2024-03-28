package ca.dal.cs.csci3130.designpatterns.adapter;

public class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        //do nothing
    }

    @Override
    public void playMP4(String fileName) {
        System.out.println("MP4: playing " + fileName);
    }
}
