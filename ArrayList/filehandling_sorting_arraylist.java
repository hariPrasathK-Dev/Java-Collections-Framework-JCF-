
import java.util.ArrayList ; // ArrayList is a collections framework API
import java.io.File ;
import java.io.BufferedReader ;
import java.io.FileReader ;

public class filehandling_sorting_arraylist
{

    ArrayList<String> songList = new ArrayList<>() ;
    public void printSong()
    {
        traceSong() ;
        System.out.println(songList);
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