
import java.util.ArrayList ; // ArrayList is a collections framework API
import java.io.File ;
import java.io.BufferedReader ;
import java.io.FileReader ;
import java.util.Collections ;

public class filehandling_sorting_arraylist
{

    // Note : TreeSet data structure is used whenever the data shoudl be sorted and the the duplicates be avoided by defualt the data structure does that !

    // ArrayList is used when the order of the data is a must and then the array thing should be dynamic allowing n insertions and then even deletions !
    // ArrayList<String> songList = new ArrayList<>() ;
    ArrayList<Song> songList = new ArrayList<>() ;
    public void printSong()
    {
        traceSong() ;
        System.out.println(songList);
        
        // songList.sort() requires some declaration of stuff within the method which we will learn in the further examples.. As of now to keep things simple, just use the Collections class' sort method
        
        /*
         * You’re very close, just a small correction 🙂

            The Java Collections Framework (JCF) has interfaces (like List, Set, Map), their implementations (like ArrayList, HashSet, HashMap), and some utility classes.

            Collections (note the s) is not a data structure class itself.
            👉 It is a utility/helper class that contains static methods to operate on collections (like sort(), shuffle(), reverse(), min(), max(), synchronizedList(), etc.).

            So:

            ✅ You are right that JCF has many classes with their own uses/drawbacks.

            ❌ But Collections is not like ArrayList or HashSet (which store data).

            ✅ Instead, Collections is like a toolbox of methods you can use on those data structures.

            “Collections Framework has many classes with their own uses and drawbacks. One special class is the Collections utility class, which provides static methods to operate on or return collections.”
         
            Collection (interface)

            Part of the root hierarchy in JCF.

            Represents a group of objects (like a bag of elements).

            Extended by List, Set, Queue.

            Example:

            Collection<String> list = new ArrayList<>();


            Collections (class)

            A utility class with only static methods.

            Provides helper methods to work on collections (like sort, reverse, min, max, shuffle).

            Example:

            Collections.sort(list);


            👉 Easy way to remember:

            Collection = blueprint (interface) for storing data.

            Collections = toolbox (utility class) for working with that data.
            */
       // Collections.sort(songList) ; // the list provided inside the sort method should have meberswhich are comparable and that they should be implemet the comparable interface
       // System.out.println(songList) ;
       for(Song song : songList)
       {
        System.out.println(song) ;
        System.out.println("----------------------------") ;
       }
    }

    public void traceSong()
    {
        // Load the sample song data file which has the name of the song and then the singer separated by a forward slash
        File file = new File("C://Users//hp859//Desktop//JAVA LEARNING//Java Collections Framework (JCF)//ArrayList/sampleData.txt") ;
        
        // Create a buffer to read the data and the use it in the program, buffered reader is the buffer 
        // itself which stores the read data from the file and then allws to use in the program. Filereader is the object used fro the reading purpose

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file)) ;
            String line = null ;

            while((line = reader.readLine()) != null)
            {
                performSongSeparation(line) ;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace() ;   
        }

    }

    public void performSongSeparation(String lineToPerform)
    {
        String [] songDetails = lineToPerform.split("/") ;
        float r_float = Float.parseFloat(songDetails[2]) ;
        songList.add(new Song(songDetails[0],songDetails[1],r_float,songDetails[3])) ;
    }

    public static void main(String [] args)
    {
        filehandling_sorting_arraylist obj = new filehandling_sorting_arraylist() ;

        obj.printSong() ;
    }


}