
public class Threads
{
    public static void main(String[] args)
    {
    	System.out.println("* * * *\nJAVA Thread samples\n* * * *");
        System.out.println("A thread is a parallel code execution that has a beginning and an end. Threads can be paused/resumed. Concurrency is what we call a multi-threaded environment.");
    	
        String str = "";
        
        // Thread creation
        System.out.println("\nRunnable is an interface for classes that want to be executed by a Thread. When a new thread is created, the Runnable is given and the method run() is used as the execution starting point.");
        System.out.println("A Thread is a thread of execution in a program. It takes a Runnable object and calls it's run() method when the thread is started by start().");
        System.out.println("\nRunnable runnable = new Runnable() {@Override public void run() {System.out.println(\"Hello from \" + Thread.currentThread().getName());} };");
        System.out.println("new Thread(runnable).start();");
        
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from " + Thread.currentThread().getName());
            }
        };
        
        System.out.println("Hello from " + Thread.currentThread().getName());
        
        new Thread(runnable).start();
        
        // Thread queues
        
        
        // Thread safety
        
    }
}
