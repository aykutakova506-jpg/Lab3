/**
 * Represents the doubly linked list for the music playlist.
 *
 * Your Name:        Aykut Akova
 * Your Student ID:  250446032
 * Your Date:        19.10.2026
 */
public class MusicPlaylist {

    private SongNode head;
    private SongNode tail;
    private SongNode current;

    public MusicPlaylist() {
        head = null;
        tail = null;
        current = null;
    }

    public void addSong(String title) {
        SongNode newNode = new SongNode(title);

        // liste boşsa üçü de aynı düğümü gösterir
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void removeSong(String title) {
        SongNode temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("The song isn't in the playlist");
            return;
        }

        System.out.println("Removed: " + title);

        // tek düğüm varsa liste boşalır
        if (head == tail) {
            head = null;
            tail = null;
            current = null;
        }
        // baştaki düğüm
        else if (temp == head) {
            head = head.next;
            head.prev = null;
            if (current == temp) {
                current = head;
            }
        }
        // sondaki düğüm
        else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
            if (current == temp) {
                current = tail;
            }
        }
        // aradaki düğüm: komşuları birbirine bağla
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            if (current == temp) {
                current = temp.next;
            }
        }
    }

    public void nextSong() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the last song of the playlist.");
        }
    }

    public void previousSong() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the first song of the playlist.");
        }
    }

    public void displayCurrentSong() {
        if (current != null) {
            System.out.println("Current Song: " + current.title);
        } else {
            System.out.println("No song is currently playing.");
        }
    }

    public void displayPlaylist() {
        SongNode temp = head;
        while (temp != null) {
            System.out.print(temp.title + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}