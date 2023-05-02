package main.java.com.xfherun.jmci.utils;


public class Sleep {
    private Sleep() {}

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
