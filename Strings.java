import java.util.ArrayList;
import java.util.Arrays;

public class Strings
{
    public static void main(String[] args)
    {
    	System.out.println("* * * *\nJAVA String samples\n* * * *");
    	System.out.println("String uses Unicode UTF-16. It extends the CharSequence interface. Chars in JAVA are 2 bytes long and also Unicode UTF-16.");
    	
        String str = "tester bester tester";
        String tip = " results: ";
        
        System.out.println("\nTesting string '" + str + "'...");
        String a = Strings.substring(str, 0, str.length()).toString();
        System.out.println("Substring 0 to str.length()" + tip + a);
        String b = Strings.splitString(str, " ").toString();
        System.out.println("Split by whitespace" + tip + b);
        String c = Strings.replaceAllInString(str, "test", "rest");
        System.out.println("Replace all 'test' with 'rest'" + tip + c);
        String d = Strings.toUpperCase(str);
        System.out.println("To upper case" + tip + d);
        
        str = "  2  spaces  inbetween";
        System.out.println("\nTesting string '" + str + "'...");
        String e = Strings.trimMultipleSpaces(str);
        System.out.println("Trim multiple spaces" + tip + e);
        
        str = "why hello there";
        System.out.println("\nTesting string '" + str + "'...");
        String f = Strings.contains(str, "hello") ? "true" : "false";
        System.out.println("Contains 'hello'?" + tip + f);
        String g = Strings.contains(str, "bye") ? "true" : "false";
        System.out.println("Contains 'bye'?" + tip + g);
        String h = Strings.startsWith(str, "why") ? "true" : "false";
        System.out.println("Starts with 'why'?" + tip + h);
        String i = Strings.startsWith(str, "hello") ? "true" : "false";
        System.out.println("Starts with 'hello'?" + tip + i);
        String j = Strings.endsWith(str, "there") ? "true" : "false";
        System.out.println("Ends with 'there'?" + tip + j);
        String k = Strings.equalsIgnoreCase(str, "WHY hello THERE") ? "true" : "false";
        System.out.println("Equals ignore case 'WHY hello THERE'?" + tip + k);
    }
    
    static String substring(String string, int start, int end)
    {
    	return string.substring(start, end);
    }
    
    static ArrayList<String> splitString(String string, String separator)
    {
    	String[] result = string.split(separator);
    	return new ArrayList<String>(Arrays.asList(result));
    }
    
    static String replaceAllInString(String string, String target, String replacement)
    {
    	return string.replaceAll(target, replacement);
    }
    
    static String toLowerCase(String string)
    {
    	return string.toLowerCase();
    }
    
    static String toUpperCase(String string)
    {
    	return string.toUpperCase();
    }
    
    static String trim(String string)
    {
    	return string.trim();
    }
    
    static String trimLeadingSpaces(String string)
    {
    	return string.replaceAll("^\\s+", "");
    }
    
    static String trimTrailingSpaces(String string)
    {
    	return string.replaceAll("\\s+$", "");
    }
    
    static String trimMultipleSpaces(String string)
    {
    	return string.trim().replaceAll("\\s{2,}", " ");
    }
    
    static boolean contains(String string, String sub)
    {
    	return string.contains(sub);
    }
    
    static boolean startsWith(String string, String sub)
    {
    	return string.startsWith(sub);
    }
    
    static boolean endsWith(String string, String sub)
    {
    	return string.endsWith(sub);
    }
    
    static boolean equalsIgnoreCase(String a, String b)
    {
    	return a.equalsIgnoreCase(b);
    }
}
