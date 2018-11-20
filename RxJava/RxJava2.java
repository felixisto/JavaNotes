
public class Threads
{
    public static void main(String[] args)
    {
    	System.out.println("* * * *\nJAVA RxJava samples\n* * * *");
        System.out.println("http://reactivex.io/documentation/observable.html");
    	
        String str = "";
        
        // Executes accept callback on another thread
        Observable.just("First").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception 
            {
                Log.v("rxJava", "1:: " + s);
            }
        });
        
        // Executes the accept(i) callback 5 times, with each value in the defined range.
        // Finally, the run() callback is called.
        Observable.range(1, 5).concatMap(new Function<Integer, ObservableSource<Integer>>() 
                {
                    @Override
                    public ObservableSource<Integer> apply(Integer integer) throws Exception {
                        return Observable.just(integer).delay(1000, TimeUnit.MILLISECONDS);
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer i) throws Exception {
                        Log.v("rxJava", "2:: " + i.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.v("rxJava", "2:: on Fail");
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.v("rxJava", "2:: on Complete");
                    }
                });
        
        // Executes accept(integers) callback 3 times, with values [1,2] [3,4] and [5].
        // Finally, the run() callback is called.
        Observable.range(1, 5).buffer(2).subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) throws Exception 
            {
                Log.v("rxJava", "3:: " + integers.toString());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.v("rxJava", "3:: on Fail");
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.v("rxJava", "3:: on Complete");
            }
        });
    }
}
