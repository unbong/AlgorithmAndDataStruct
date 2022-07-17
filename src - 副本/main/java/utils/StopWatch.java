package utils;

public class StopWatch{
    private long startMS =0;

    public StopWatch()
    {
        startMS = System.currentTimeMillis();
    }

    public String elapsedTime()
    {
        long time = System.currentTimeMillis()- startMS;
        return Long.valueOf(time).toString();
    }
}
