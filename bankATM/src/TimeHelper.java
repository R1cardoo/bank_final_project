public class TimeHelper {

    private static TimeHelper instance = new TimeHelper();
    private long time = 20221216;

    public static TimeHelper getInstance() {
        return instance;
    }

    public long getTime() {
        return time;
    }

    public void increase() {
        time++;
    }
}
