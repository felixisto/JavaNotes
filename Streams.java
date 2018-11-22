
public class Streams
{
    public static void main(String[] args)
    {
    	System.out.println("* * * *\nJAVA Stream samples\n* * * *");
        System.out.println("The number of stream types is overwhelming in JAVA.\nI highly advise to learn streams by memorizing the constructor arguments. Also, ignore what class the streams extend, it's useless and confusing.");
    	
        String str = "";
        
        // Stream descriptions
        System.out.println("\nReader and InputStream are simply interfaces that define commonly used methods.");
        System.out.println("Reader reads character streams. BufferedReader is a popular Reader subclass.");
        System.out.println("InputStream is the superclass of all input stream classes in JAVA. InputStream are usually passed around as arguments to initialize reader objects.");
        System.out.println("InputStreamReader wraps a InputStream (byte stream) and is used as a character stream.");
        System.out.println("BufferedReader wraps a Reader object and uses buffering to efficiently read it.");
        System.out.println("In most cases, BufferedReader is the best class to use for reading streams/files.");
        
        System.out.println("\nWriter and OutputStream are simply interfaces that define commonly used methods.");
        System.out.println("Writer writes character streams. BufferedWriter is a popular Writer subclass.");
        System.out.println("OutputStream is the superclass of all output stream classes in JAVA.");
        
        System.out.println("BufferedWriter wraps a Writer object and uses buffering to efficiently write to it.");
        System.out.println("FilterOutputStream wraps an OutputStream and overrides all its methods. Don't use this class directly, use the popular derived classes such as BufferedOutputStream.");
        System.out.println("BufferedOutputStream wraps an OutputStream and uses buffering to efficiently write to it.");
        System.out.println("PrintStream wraps an OutputStream or a File and adds support for auto flush and ability to print representations of various data values conveniently.");
        System.out.println("PrintWriter wraps a Writer and implements all PrintStream funcionality. It is incapable of writing raw bytes.");
        System.out.println("In most cases, PrintStream is the best class to use for writing to streams/files.");
        
        System.out.println("\nSystem.out is a PrintStream.\nSystem.in is an InputStream.");
        
        System.out.println("For Output streams only, flush() must be called in order to finish writing the buffered bytes. The flush method of OutputStream does nothing because it does not support buffering.");
        
        System.out.println("Don't forget to close() streams when done with them. Close streams only that you have opened. Closed streams cannot be reopened.");
    }
}
