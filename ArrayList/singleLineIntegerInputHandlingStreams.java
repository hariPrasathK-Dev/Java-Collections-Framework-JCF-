
import java.util.Scanner;
import java.util.Arrays;

public class singleLineIntegerInputHandlingStreams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
         * Arrays.stream() => requires an array to convert to a stream, i.e , here
         * convertes our array of Strings to a stream of Strings.
         * Assume Stream like a pipeline where you can have ecach element flowing
         * without actually using a for loop or something like that. we'll deal
         * with streams in details later .
         * 
         * .mapToInt() => requires a function as an input argument and so here we have
         * given the lambda function which takes ecah s(string) one by one as
         * an input and gives an integer an an output. This mapToInt() method convertes
         * the stream of Strings to a stream of Intgers because the return type of this
         * method is
         * <IntStream>
         * 
         * .toArray() => this method finally convertes the stream of integers generated
         * by the mapToInt() method to an array of integers.
         */
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();

        for (int i : arr) {
            System.out.println(i);
        }

        sc.close();
    }
}