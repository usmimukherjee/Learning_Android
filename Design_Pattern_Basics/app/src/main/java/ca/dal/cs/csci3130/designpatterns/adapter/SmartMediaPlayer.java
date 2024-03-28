package ca.dal.cs.csci3130.designpatterns.adapter;

public class SmartMediaPlayer implements MediaPlayer {
    MediaAdapter adapter;

    public SmartMediaPlayer(MediaAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void play(String mediaType, String fileName) {
        if (mediaType.equals(MediaConstants.MP3)) {
            System.out.println("MP3: Playing " + fileName);
        } else if (mediaType.equals(MediaConstants.MP4) || mediaType.equals(MediaConstants.VLC)) {
            this.adapter.play(mediaType, fileName);
        }
    }
}
