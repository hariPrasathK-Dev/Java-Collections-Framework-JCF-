
import java.util.ArrayList; // ArrayList is a collections framework API
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;

/*
Generics : 

Note : Most programmers just need to know three things regardng to the Generics :

1) Instantiating a generic class
2) Assigning an instance of a generic class with particular type(class) and then will i be able to assign to that variable, a subclass of that
type(class) ? A question to the 'polymorphism' regaring to the Generics in which a variation to the polymorphism property with regard to the generics.
3) Declaring a method that allows  generic type inputs, will i be able to input a type which is a sub-class of the instantiated type !

 🌟 What are Generics?

Generics = a way to write classes, interfaces, and methods that can work with any data type, but still give type safety.
Example:

List<String> names = new ArrayList<>();


Here, List<String> means this list can only hold Strings.

✅ Advantages of Generics (vs. no generics)

Type Safety

Without generics: you could put anything in a collection → errors at runtime.

With generics: compiler checks the type → errors caught at compile-time.

List<String> names = new ArrayList<>();
names.add("Hari");
names.add(10); // ❌ Compile-time error


No Casting Needed

Without generics: you must cast when retrieving.

With generics: automatic type inference.

// Without generics
List list = new ArrayList();
list.add("Hari");
String s = (String) list.get(0); // manual cast  

// With generics
List<String> list2 = new ArrayList<>();
list2.add("Hari");
String s2 = list2.get(0); // no cast needed


Code Reusability

You can write one class/method and use it for different types.

class Box<T> {
    T value;
    Box(T value) { this.value = value; }
    T getValue() { return value; }
}
Box<Integer> b1 = new Box<>(100);
Box<String> b2 = new Box<>("Hello");


Better Readability & Maintainability

When you see List<String>, you instantly know it holds Strings, not something else.

👉 Easy way to remember:

Without Generics = risk of runtime errors + lots of casting.

With Generics = safer, cleaner, reusable code.
 */

/*
 Polymorphism :

 Polymorphism (meaning)

Poly = many, morph = forms → “one thing, many forms.”
In Java → the same object/ method can behave differently depending on the context.

✅ Types of Polymorphism in Java

Compile-time Polymorphism (Method Overloading)

Same method name, but different parameter list (number/type/order).

Decided at compile time.

class MathUtil {
   int add(int a, int b) { return a+b; }
   double add(double a, double b) { return a+b; }
}


Runtime Polymorphism (Method Overriding)

A subclass provides its own implementation of a method defined in the parent class.

Decided at runtime → depends on the actual object being referenced.

class Animal {
   void sound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
   @Override
   void sound() { System.out.println("Bark"); }
}
class Cat extends Animal {
   @Override
   void sound() { System.out.println("Meow"); }
}
public class Demo {
   public static void main(String[] args) {
       Animal a = new Dog(); a.sound(); // Bark
       a = new Cat(); a.sound();       // Meow
   }
}

✅ Key Advantages of Polymorphism

Code Reusability → write general code, let subclasses specialize.

Flexibility → the same method call works differently for different objects.

Readability & Maintainability → reduces duplication, makes code cleaner.

Foundation of OOP in Java → used everywhere in frameworks like Spring (e.g., beans, interfaces).

👉 Easy way to remember:

Overloading = compile-time polymorphism (same name, different parameters).

Overriding = runtime polymorphism (same method, different implementation).
 */

public class filehandling_sorting_arraylist {

    // Note : TreeSet data structure is used whenever the data shoudl be sorted and
    // the the duplicates be avoided by defualt the data structure does that !

    // ArrayList is used when the order of the data is a must and then the array
    // thing should be dynamic allowing n insertions and then even deletions !
    // ArrayList<String> songList = new ArrayList<>() ;
    ArrayList<Song> songList = new ArrayList<>();

    public void printSong() {
        traceSong();
        System.out.println(songList);

        // songList.sort() requires some declaration of stuff within the method which we
        // will learn in the further examples.. As of now to keep things simple, just
        // use the Collections class' sort method

        /*
         * You’re very close, just a small correction 🙂
         * 
         * The Java Collections Framework (JCF) has interfaces (like List, Set, Map),
         * their implementations (like ArrayList, HashSet, HashMap), and some utility
         * classes.
         * 
         * Collections (note the s) is not a data structure class itself.
         * 👉 It is a utility/helper class that contains static methods to operate on
         * collections (like sort(), shuffle(), reverse(), min(), max(),
         * synchronizedList(), etc.).
         * 
         * So:
         * 
         * ✅ You are right that JCF has many classes with their own uses/drawbacks.
         * 
         * ❌ But Collections is not like ArrayList or HashSet (which store data).
         * 
         * ✅ Instead, Collections is like a toolbox of methods you can use on those data
         * structures.
         * 
         * “Collections Framework has many classes with their own uses and drawbacks.
         * One special class is the Collections utility class, which provides static
         * methods to operate on or return collections.”
         * 
         * Collection (interface)
         * 
         * Part of the root hierarchy in JCF.
         * 
         * Represents a group of objects (like a bag of elements).
         * 
         * Extended by List, Set, Queue.
         * 
         * Example:
         * 
         * Collection<String> list = new ArrayList<>();
         * 
         * 
         * Collections (class)
         * 
         * A utility class with only static methods.
         * 
         * Provides helper methods to work on collections (like sort, reverse, min, max,
         * shuffle).
         * 
         * Example:
         * 
         * Collections.sort(list);
         * 
         * 
         * 👉 Easy way to remember:
         * 
         * Collection = blueprint (interface) for storing data.
         * 
         * Collections = toolbox (utility class) for working with that data.
         */
        // Collections.sort(songList) ; // the list provided inside the sort method
        // should have meberswhich are comparable and that they should be implemet the
        // comparable interface
        // System.out.println(songList) ;
        for (Song song : songList) {
            System.out.println(song);
            System.out.println("----------------------------");
        }
    }

    public void traceSong() {
        // Load the sample song data file which has the name of the song and then the
        // singer separated by a forward slash
        File file = new File(
                "C://Users//hp859//Desktop//JAVA LEARNING//Java Collections Framework (JCF)//ArrayList/sampleData.txt");

        // Create a buffer to read the data and the use it in the program, buffered
        // reader is the buffer
        // itself which stores the read data from the file and then allws to use in the
        // program. Filereader is the object used fro the reading purpose

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = reader.readLine()) != null) {
                performSongSeparation(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void performSongSeparation(String lineToPerform) {
        String[] songDetails = lineToPerform.split("/");
        float r_float = Float.parseFloat(songDetails[2]);
        songList.add(new Song(songDetails[0], songDetails[1], r_float, songDetails[3]));
    }

    public static void main(String[] args) {
        filehandling_sorting_arraylist obj = new filehandling_sorting_arraylist();

        obj.printSong();
    }

}