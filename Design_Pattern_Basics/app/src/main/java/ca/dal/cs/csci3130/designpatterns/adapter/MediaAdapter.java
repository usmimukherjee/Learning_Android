package ca.dal.cs.csci3130.designpatterns.adapter;

public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(AdvancedMediaPlayer player) {
        this.advancedMediaPlayer = player;
    }

    @Override
    public void play(String mediaType, String fileName) {
        if (mediaType.equals(MediaConstants.VLC)) {
            this.advancedMediaPlayer.playVLC(fileName);
        } else if (mediaType.equals(MediaConstants.MP4)) {
            this.advancedMediaPlayer.playMP4(fileName);
        }
    }
}
