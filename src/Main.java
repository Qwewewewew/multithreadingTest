import java.util.Random;
import java.util.stream.IntStream;

//This thing compares multithreading vs single thread
//The task is to bubble sort two arrays of 10 000 integers from [0, 2000]

public class Main {

    //timer made public to access from other threads
    public static long start;
    public static long end;

    public static void main(String[] args) throws Exception {
        System.out.println("\n --Main started-- \n");

        //Arrays to work with

        int count = 15000;
        int limit = 20000;

        int[] arr1 = IntStream.generate(() -> new Random().nextInt(limit)).limit(count).toArray();
        int[] arr2 = IntStream.generate(() -> new Random().nextInt(limit)).limit(count).toArray();

        //Thread init
        SecThread thr1 = new SecThread(arr1);
        SecThread thr2 = new SecThread(arr2);


        //Timer start
        long startMain = System.nanoTime();

        //main test
        Sort.bubbleSort(arr1);
        Sort.bubbleSort(arr2);

        long endMain = System.nanoTime();
        
        //multithread test
        start = System.nanoTime();
        thr1.start();
        thr2.start();

        Thread.sleep(500); //Waiting for all the threads to finish
        System.out.println("Multithread: " + Math.round((end-start)/1000000));
        System.out.println("Single Thread: " + Math.round((endMain-startMain)/1000000));
    }
}