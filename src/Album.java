import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String title;
    private String artist;

    private List<Song> songs;

    public Album() {
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findSong(String title){
        for(Song s: this.songs){
            if(s.getTitle().equals(title)){
                return true;
            }
        }
            return false;
    }

    public boolean addSong(String title, double duration){
        if(!findSong(title)){
            Song s = new Song(title, duration);
            this.songs.add(s);
            System.out.println("Your song has been added");
            return true;
        }
        System.out.println("Song already present in the album");
        return false;
    }
    // Method overloading --> compile time
    public boolean addSongToMyPlayList(String title, LinkedList<Song> myPlayList){
        if(findSong(title)){
            for(Song s: this.songs){
                if(s.getTitle().equals(title)){
                    myPlayList.add(s);
                    System.out.println("Congrats! your song has been added to your playlist");
                    return true;
                }
            }
        }
        System.out.println("Song is not present");
        return false;
    }

    public boolean addSongToMyPlayList(int index, LinkedList<Song>myPlayList){
        index = index-1;
        if(index >= 0 && index < this.songs.size()){
           myPlayList.add(songs.get(index));
            System.out.println("Your song added successfully");
            return true;
        }
        System.out.println("Invalid song number");
        return false;
    }
}
