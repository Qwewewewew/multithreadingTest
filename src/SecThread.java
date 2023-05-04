public class SecThread extends Thread {
    
    
    private int[] arr;

    public SecThread(int[] arr){
        this.arr = arr;
    }

    @Override
    public void run() {
        Sort.bubbleSort(arr);
        Main.end = System.nanoTime();
    }
}
