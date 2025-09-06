import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class hashMapImplementation {
    public static void main(String[] args) {
        /*
         * HashMap maitains a key-value pair and often denoted as HashMap<key,value> or
         * HashMap<k,v>
         * Each entry(Key-value pair) in Map is an entity. Key should be unique, HashMap
         * is not thread
         * safe(if two threads try to access the same HashMap dataStructure, then it
         * result in ambiguity). Since it is not thread safe, we get one benefit :
         * Performance optimization. It is
         * not an ordered Collection which means it doesn't return the keys and values
         * in the same order in which they were inserted. It neither does any kind of
         * sorting to keys and values.
         * In HashMap we can put null keys as well as null values.
         * 
         * HashTable is same as HashMap but it is thread safe.
         * HashTable can only have null values and no null keys are allowed. Apart from
         * these differences, there is no difference.
         *
         */

        HashMap<Integer, String> hMap = new HashMap<>();

        hMap.put(1, "Hari Prasath");
        hMap.put(2, "Karuna Karan");
        hMap.put(3, "KalaiSelvi");
        hMap.put(4, "Deeksha");
        hMap.put(5, "Janani");
        hMap.put(6, "Rithwik");
        hMap.put(7, "Rithika");

        System.out.println(hMap);
        System.out.println(hMap.entrySet());

        /*
         * Accessing the keys and values of the HashMap using the entrySet() method of
         * the HashMap class.
         * This involves Assigning the Set object to Map.Entry interface which has
         * getKey() and getValue() methods associated with it !
         * 
         */
        Set set = hMap.entrySet();
        Iterator itr = set.iterator();

        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();

            System.out.println("Key : " + mapEntry.getKey());
            System.out.println("Value : " + mapEntry.getValue());

        }

        /*
         * Another way is to use the keySet() method of the HashMap class which returns
         * the keys associated with the given hashMap object.
         * Then we could use the .get() method passing those keys as the input to the
         * method to get the values of those keys in turn getting the keys as well as
         * the value !
         * 
         */
        Set keySet = hMap.keySet();
        System.out.println(keySet);

        Iterator itr2 = keySet.iterator();

        while (itr2.hasNext()) {
            int key = (int) itr2.next();
            System.out.println("Key : " + key + " ; Value : " + hMap.get(key));
        }

        // Getting a value assoicated with a key :
        String val = hMap.get(6);
        System.out.println("key : " + 6 + " ; Value : " + val);

        // Removing the HashMap entries :

        // Method 1 : Specifying the key only :
        System.out.println("The Set of the HasMap Entries : " + hMap);

        hMap.remove(7);
        System.out.println("After removal of the key 7 : " + hMap);

        // Method 2 : Specifying both the key and the value. Note : Removes the given
        // entry only if the correct key-value pair is present in the HasMap entry. If
        // the key isthere but the soecified Vlaue in the method is not there rather
        // some ither value is associated with the key in the ahshMap, then no deletion
        // (or) removal happens !

        hMap.remove(1, "Anonymous");
        System.out.println("After applying the remove method on (1,'Anonymous')" + hMap); // Note here since the value
                                                                                          // is given anonymous here but
                                                                                          // actually "Hari Prasath" is
                                                                                          // associated with the key 1,
                                                                                          // so no removal happens

        // IsEmty() method :
        System.out.println("Is the HashMap empty ? "+hMap.isEmpty());
        
        //containsKey and containsValue method :
        System.out.println("Does the key 1 present ? "+hMap.containsKey(1));
        System.out.println("Does the value 'Karuna Karan' ? "+hMap.containsValue("Karuna karan"));

        // size() method for the HashMap :
        System.out.println("Size of the HashMap Data Structure : "+hMap.size());
    }
}