package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.adapter.MP4Player;
import ca.dal.cs.csci3130.designpatterns.adapter.MediaAdapter;
import ca.dal.cs.csci3130.designpatterns.adapter.SmartMediaPlayer;
import ca.dal.cs.csci3130.designpatterns.adapter.VLCPlayer;

public class AdapterTest {

    @Test
    public void testAdapterPattern() {
        VLCPlayer vlcPlayer = new VLCPlayer();
        MediaAdapter mediaAdapter = new MediaAdapter(vlcPlayer);
        SmartMediaPlayer smartMediaPlayer = new SmartMediaPlayer(mediaAdapter);

        //smartMediaPlayer.play("MP3", "abc.mp3");
        //smartMediaPlayer.play("VLC", "abc.vlc");

        MP4Player mp4Player = new MP4Player();
        MediaAdapter anotherAdapter = new MediaAdapter(mp4Player);
        SmartMediaPlayer anotherSmartMediaPlayer = new SmartMediaPlayer(anotherAdapter);
        anotherSmartMediaPlayer.play("MP4", "abc.mp4");
        anotherSmartMediaPlayer.play("MP3", "abc.mp3");
    }

}
