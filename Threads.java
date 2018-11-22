
public class Threads
{
    public static void main(String[] args)
    {
    	System.out.println("* * * *\nJAVA Thread samples\n* * * *");
        System.out.println("A thread is a parallel code execution that has a beginning and an end. Threads can be paused/resumed. Concurrency is what we call a multi-threaded environment.");
    	
        String str = "";
        
        // Some model
        Model model = new Model(50);
        System.out.println("\nCreating a dummy model object with a value so it can be read from the threads later.");
        
        // Thread creation
        System.out.println("\nRunnable is an interface for classes that want to be executed by a Thread. When a new thread is created, the Runnable is given and the method run() is used as the execution starting point.");
        System.out.println("A Thread is a thread of execution in a program. It takes a Runnable object and calls it's run() method when the thread is started by start().");
        System.out.println("\nRunnable runnable = new Runnable() {@Override public void run() {System.out.println(\"Hello from \" + Thread.currentThread().getName());} };");
        System.out.println("new Thread(runnable).start();");
        
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from " + Thread.currentThread().getName() + ", special value of model is " + model.getSpecialValue());
            }
        };
        
        new Thread(runnable).start();
        
        // Thread safety
        // See the private classes below
        System.out.println("\nThread safety is accomplished by putting threads in a queue before they execute their target code.");
        System.out.println("One way to do this is by using the keyword 'synchronized' in the method signature like so: synchronized static public Constants getShared()");
        System.out.println("Note that constructors cannot be synchronized — using the synchronized keyword with a constructor is a syntax error. Synchronizing constructors doesn't make sense, because only the thread that creates an object should have access to it while it is being constructed.");
        System.out.println("Another way is to put threads into queues, and have then read the code one at a time.");
        System.out.println("\nThere is fancy way to achieve thread safety for singleton creation even without synchronization:\nprivate static class BillPughSingleton() {private static final Singleton INSTANCE = new Singleton();}\npublic class Singleton() {public static Singleton getShared() {return BillPughSingleton.SINGLETON;}}");
        
        // Sleep
        // Exception is used if the thread is interrupted sleeping
        // Handle the interruptuon in the catch clause
        System.out.println("\nMain thread will sleep for 1 millisecond. Sleep can be interrupted and handled with try/catch");
        
        try {
        	Thread.sleep(1);
        }
        catch (Exception e)
        {
        	
        }
        
        System.out.println("Hello from " + Thread.currentThread().getName() + ", special value of model is " + model.getSpecialValue());
        
        // Thread queues
        // Usually platform specific. On Android, there are a bunch of fancy tools such as Handler/Looper and AsyncTask.
    }
    
    
}

// Thread safe class
class Model
{
	private int _value;
	
	public Model(int value)
	{
		_value = value;
	}
	
	synchronized public int getValue()
	{
		return _value;
	}
	
	synchronized public double getSpecialValue()
	{
		return _value * Constants.getShared().getMultiplier();
	}
	
	public void setValue(int value)
	{
		_value = value;
	}
}

// Singleton safe class
class Constants
{
	static private Constants singleton;
	private final double _multiplier;
	
	public Constants()
	{
		_multiplier = 2.0;
	}
	
	// Synchronized method to control simultaneous access 
	synchronized static public Constants getShared()
	{
		if (singleton == null)
		{
			singleton = new Constants();
		}
		
		return singleton;
	}
	
	public double getMultiplier()
	{
		return _multiplier;
	}
}
