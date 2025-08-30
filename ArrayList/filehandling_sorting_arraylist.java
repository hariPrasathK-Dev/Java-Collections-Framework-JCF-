
import java.util.ArrayList ; // ArrayList is a collections framework API
import java.io.File ;
import java.io.BufferedReader ;
import java.io.FileReader ;
import java.util.Collections ;

public class filehandling_sorting_arraylist
{

    // Note : TreeSet data structure is used whenever the data shoudl be sorted and the the duplicates be avoided by defualt the data structure does that !

    // ArrayList is used when the order of the data is a must and then the array thing should be dynamic allowing n insertions and then even deletions !
    ArrayList<String> songList = new ArrayList<>() ;
    public void printSong()
    {
        traceSong() ;
        System.out.println(songList);
        
        // songList.sort() requires some declaration of stuff within the method which we will learn in the further examples.. As of now to keep things simple, just use the Collections class' sort method
        
        // Collections framework has many classes which has their own uses and drawbacks. one such class is Collections class
        Collections.sort(songList) ; // the list provided inside the sort method should have meberswhich are comparable and that they should be implemet the comparable interface
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
        songList.add(songDetails[0]) ;
    }

    public static void main(String [] args)
    {
        filehandling_sorting_arraylist obj = new filehandling_sorting_arraylist() ;

        obj.printSong() ;
    }
}