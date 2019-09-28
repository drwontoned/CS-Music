package liu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JFrame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Nicolas Kellum
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        Interface view = new Interface("Song♪");
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setLocation(100, 200);
        view.pack();
        view.setVisible(true);
        /*
        Song jingleBell = new Song("Jingle Bell", "3330333035123");
        Song test = new Song("T H I C C", "3330333035d");
        SongCollection myThing = new SongCollection();
        myThing.addSong(jingleBell);
        myThing.addSong(test); */
    }

    public static void Play(String s) {
        InputStream note1;
        InputStream note2;
        InputStream note3;
        InputStream note4;
        InputStream note5;
        InputStream note6;
        InputStream note7;
        InputStream note8;
        InputStream note0;
        InputStream test;

        Scanner input = new Scanner(System.in);
        Scanner scanStr = new Scanner(s);
        scanStr.useDelimiter("");

        try {
            for (int j = 0; j <= s.length(); j++) {
                note0 = new FileInputStream(new File("src\\notes\\0.wav"));
                AudioStream note_0 = new AudioStream(note0);
                AudioPlayer.player.start(note_0);
                Thread.sleep(500);
                switch (scanStr.next()) {
                    case "1":
                        note1 = new FileInputStream(new File("src\\notes\\1.wav"));
                        AudioStream note_1 = new AudioStream(note1);
                        AudioPlayer.player.start(note_1);
                        break;
                    case "2":
                        note2 = new FileInputStream(new File("src\\notes\\2.wav"));
                        AudioStream note_2 = new AudioStream(note2);
                        AudioPlayer.player.start(note_2);
                        break;
                    case "3":
                        note3 = new FileInputStream(new File("src\\notes\\3.wav"));
                        AudioStream note_3 = new AudioStream(note3);
                        AudioPlayer.player.start(note_3);
                        break;
                    case "4":
                        note4 = new FileInputStream(new File("src\\notes\\4.wav"));
                        AudioStream note_4 = new AudioStream(note4);
                        AudioPlayer.player.start(note_4);
                        break;
                    case "5":
                        note5 = new FileInputStream(new File("src\\notes\\5.wav"));
                        AudioStream note_5 = new AudioStream(note5);
                        AudioPlayer.player.start(note_5);
                        break;
                    case "6":
                        note6 = new FileInputStream(new File("src\\notes\\6.wav"));
                        AudioStream note_6 = new AudioStream(note6);
                        AudioPlayer.player.start(note_6);
                        break;
                    case "7":
                        note7 = new FileInputStream(new File("src\\notes\\7.wav"));
                        AudioStream note_7 = new AudioStream(note7);
                        AudioPlayer.player.start(note_7);
                        break;
                    case "8":
                        note8 = new FileInputStream(new File("src\\notes\\8.wav"));
                        AudioStream note_8 = new AudioStream(note8);

                        AudioPlayer.player.start(note_8);
                        break;
                    case "0":
                        break;
                    default:
                        test = new FileInputStream(new File("src\\ez.wav"));
                        AudioStream testPlay = new AudioStream(test);
                        AudioPlayer.player.start(testPlay);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("played");
        }

    }

}
