import java.net.*;
import java.io.*;

public class TimerTest
{
    public static final Double NANO_TO_MILLIS = 1000000.0;
    public static void main(String[] args) throws MalformedURLException, IOException
    {
    	int i =0;
    	while(i<5){
        // start timer
        long nanoStart = System.nanoTime();
        long milliStart = System.currentTimeMillis();

        // do work to be timed
        doWork();

        // stop timer
        long nanoEnd = System.nanoTime();
        long milliEnd = System.currentTimeMillis();

        // report response times
        long nanoTime = nanoEnd - nanoStart;
        long milliTime = milliEnd - milliStart;
        reportResponseTimes(nanoTime, milliTime);
        i++;
    	}
    }

    private static void reportResponseTimes(long nanoTime, long milliTime)
    {
        // convert nanoseconds to milliseconds and display both times with three digits of precision (microsecond)
        String nanoFormatted = String.format("%,.3f", nanoTime / NANO_TO_MILLIS);
        String milliFormatted = String.format("%,.3f", milliTime / 1.0 );

        //System.out.println("Milliseconds using nanoTime(): " + nanoFormatted);
        System.out.println("Milliseconds using currentTimeMillis: " + milliFormatted);
    }

    private static void doWork() throws MalformedURLException, IOException
    {
        URL url = new URL("http://google.com");
        URLConnection conn = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        System.out.println("Checking "+url.toString());
        
        while (in.readLine() != null) {
        	//System.out.println(in.readLine());
        }
        in.close();
    }
}