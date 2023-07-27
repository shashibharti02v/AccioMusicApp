import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Doorie", "Atif Aslam");
        Album album2 = new Album("Tera Chehra", "Adnan Sami");

        album1.addSong("Kuch Is Tarha", 3.4);
        album1.addSong("O Re Piya", 5.3);
        album1.addSong("Mahi Ve",2.8);
        album1.addSong("Maula", 4.7);

        album2.addSong("Tera Chehra", 3.5);
        album2.addSong("Teri Bahoon mein", 5.3);

//        if(album1.findSong("abc")){
//            System.out.println("Song is present");
//        }
//        else {
//            System.out.println("Song is not present");
//        }
//
//        if(album1.findSong("Kuch Is Tarha")){
//            System.out.println("Song is present ");
//        }
//        else{
//            System.out.println("Song is not present");
//        }

        // create playList

        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addSongToMyPlayList("Kuch Is Tarha", myPlayList);
        album1.addSongToMyPlayList("Maula", myPlayList);
        album2.addSongToMyPlayList("Tera Chehra", myPlayList);
        album1.addSongToMyPlayList("Mahi Ve", myPlayList);

        play(myPlayList);


    }
    public static void play(LinkedList<Song>myPlayList){
        ListIterator<Song>itr = myPlayList.listIterator();

        if(!itr.hasNext()){
            System.out.println("Sorry ! Your PlayList is Empty");
            return ;
        }
        System.out.println(itr.next());
        System.out.println(itr.next());
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        boolean wasNext = true;
        printMenu();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your option");
        boolean isDeleted;
        boolean quit = false;
        while(true) {
            int option = sc.nextInt();

            switch (option){
                case 1: if(wasNext == false){
                    itr.next();
                    wasNext = true;
                }
                    if(itr.hasNext()){
                        System.out.println("Now Playing");
                    System.out.println(itr.next());
                        wasNext = true;
                }
                    else{
                        System.out.println("You have reached the end of playlist");
                    }
                    break;

                case 2: if(wasNext == true){
                    itr.previous();
                    wasNext = false;
                }
                    if(itr.hasPrevious()){
                        System.out.println("Now Playing");
                    System.out.println(itr.previous());
                        wasNext = false;
                }
                    else{
                        System.out.println("You are reached the end of playlist");
                    }
                    break;

                case 3:
                    if(wasNext == true){
                        if(itr.hasPrevious()){
                            System.out.println("Now song is playing");
                            System.out.println(itr.previous());
                            wasNext = false;
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println("Now song is playing");
                            System.out.println(itr.next());
                            wasNext = true;
                        }
                    }
                    break;

                case 4:  printSong(myPlayList);
                    break;

                case 5: itr.remove();
                    System.out.println("Your song has been deleted");
                    isDeleted = true;
                    break;

                case 6: printMenu();
                    break;
                case 7:
                    System.out.println("Size of your playlist is: "+ myPlayList.size());

                case 8:
                    exit(0);
            }
        }

    }

    public static void printSong(LinkedList<Song>myPlayList){
        for(Song s: myPlayList){
            System.out.println(s);
        }
    }

    public static void printMenu(){
        System.out.println("1: Play next song");
        System.out.println("2: Play previous song");
        System.out.println("3: Repeat current song");
        System.out.println("4: Show all song in the playlist");
        System.out.println("5: Delete the current song");
        System.out.println("6: Show the menu again");
        System.out.println("7: Show the size of playlist");
        System.out.println("8: Exit");
    }
}