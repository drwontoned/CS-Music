package liu;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author
 */
public class Song implements Comparable<Song>, Serializable {

    //fields
    private String name;
    private String content;

    public Song(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Song other = (Song) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Song o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
