package liu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 958022184
 */
public class SongCollection {

    ArrayList<Song> songList;

    public SongCollection() {
        songList = new ArrayList<>();
        readCollection();
    }

    public int songCount() {
        return songList.size();
    }

    public void addSong(Song c) {
        boolean equal = false;
        for (Song s : songList) {
            if (c.compareTo(s) == 0) {
                equal = true;
            }
        }
        if (!equal) {
            songList.add(c);
            writeCollection();
        }
    }

    public Song getSong(int i) {
        return songList.get(i);
    }

    public void deleteSong(Song c) {
        songList.remove(c);
        writeCollection();

    }

    public Song[] getSortedArray() {
        Collections.sort(songList);
        return songList.toArray(new Song[songList.size()]);
    }

    private boolean writeCollection() {
        boolean success = true;
        try (FileOutputStream fos = new FileOutputStream("songs.ser");
                ObjectOutputStream output = new ObjectOutputStream(fos)) {
            output.writeObject(songList);
        } catch (Exception ex) {
            System.out.println("Cannot write to file:\n" + ex.getMessage());
            success = false;
        }
        return success;
    }

    private boolean readCollection() {
        boolean success = true;
        File ser = new File("songs.ser");
        if (ser.exists()) {
            try (FileInputStream fis = new FileInputStream("songs.ser");
                    ObjectInputStream input = new ObjectInputStream(fis)) {
                songList = (ArrayList<Song>) input.readObject();
            } catch (Exception ex) {
                System.out.println("Cannot read from file:\n"
                        + ex.getMessage());
                success = false;
            }
        }
        return success;
    }
}
