

/*
 * Instead of storing an ArrayList of Strings representing the song names in the filehandling_sorting_arraylist class, we  try to store an ArrayList of objects 
 * representing this class Song which has  details associated with each Song object in the filehandling_sorting_arraylist class .
 */


public class Song 
{
    String songName ;
    String artist ;
    float ratings ;
    String bpm ;

    public Song(String s , String a , float r , String b)
    {
        songName = s ;
        artist = a ;
        ratings = r ;
        bpm = b ;
    }

    //Getters for the instance vairables
    public String getSong()
    {
        return this.songName ;
    } 

    public String getArtist()
    {
        return this.artist ;
    }

    public float getRating()
    {
        return this.ratings ;
    }

    public String getBpm()
    {
        return this.bpm ;
    }

        /*
* 1. Object class

Every class in Java implicitly extends Object (if no other superclass is given).

So every class inherits the toString() method.

2. Default toString() (from Object)

The default implementation is:

getClass().getName() + "@" + Integer.toHexString(hashCode())


Example:

Object obj = new Object();
System.out.println(obj);


Output → java.lang.Object@5a07e868
(class name + @ + memory-based hash code).

3. When you do System.out.println(obj)

println() internally calls:

String.valueOf(obj)


Which checks:

If obj == null → prints "null"

Else → calls obj.toString().

So yes ✅ whenever you print an object, Java automatically calls toString().

4. Overriding toString()

You can override toString() in your own class to give a meaningful string.

Example:

class Student {
    String name;
    int age;
    
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

public class Demo {
    public static void main(String[] args) {
        Student s = new Student("Hari", 19);
        System.out.println(s);
    }
}


Output →

Student{name='Hari', age=19}


👉 Easy way to remember:

Default toString() → className@hashcode (not human-friendly).

Overridden toString() → custom meaningful string for your object.
 */

    @Override
    public String toString()
    {
        return "Song : " + this.songName + "\n Artist : " + this.artist + "\n Ratings : " + this.ratings + "\n Beats Per Minute : " + this.bpm ;
    }
}
