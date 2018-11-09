import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Collections
{
    public static void main(String[] args)
    {
    	System.out.println("* * * *\nJAVA Collection samples\n* * * *");
    	System.out.println("List is an interface extended by most arrays. HashMap<S,V> is your typical mutable map class. Invalid index value is equal to -1.");
    	
        String str = "";
        
        // Collections init
        System.out.println("\nArrayList<V> (implements List) is your typical mutable resizable array class. Allows null as elements. The size, isEmpty, get, set, iterator, and listIterator operations run in constant time. The add operation runs in amortized constant time, that is, adding n elements requires O(n) time." + str + "'...");
        
        int[] primitiveInts = {4, 5, 1};
        System.out.println("int[] primitiveInts = {4, 5, 1}");
        
        String[] strings = {"1", "2", "3"};
        System.out.println("String[] strings = {\"1\", \"2\", \"3\"}");
        
        Integer[] integers = {4, 5, 1};
        System.out.println("Integer[] integers = {4, 5, 1}");
        
        List listOfStrings = Arrays.asList(strings);
        System.out.println("Arrays.asList(strings) = " + listOfStrings.toString());
        
        List listOfIntegers = Arrays.asList(integers);
        System.out.println("Arrays.asList(integers) = " + listOfIntegers.toString());
        
        ArrayList arrayListOfStrings = new ArrayList(listOfStrings);
        System.out.println("arrayListOfStrings = new ArrayList(Arrays.asList(strings)) = " + arrayListOfStrings.toString());
        arrayListOfStrings.add("I'm different!");
        System.out.println("arrayListOfStrings.add(\"I'm different!\") = " + arrayListOfStrings.toString());
        arrayListOfStrings.add(null);
        System.out.println("arrayListOfStrings.add(null) = " + arrayListOfStrings.toString());
        
        System.out.println("\nHastMap<K,V> your typical mutable resizable map class. Allows null keys and values. Makes no guarantees as to the order of the map.");
        HashMap<String, String> genericMap = new HashMap();
        genericMap.put("key1", "value1");
        System.out.println("genericMap.add(\"key1\", \"value1\") = " + genericMap.toString());
        genericMap.put("key2", null);
        System.out.println("genericMap.add(\"key2\", null) = " + genericMap.toString());
    }
}
