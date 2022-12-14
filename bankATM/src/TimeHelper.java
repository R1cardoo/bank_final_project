public class TimeHelper {

    private static TimeHelper instance = null;
    private long time = 20221216;

    public static TimeHelper getInstance() {
        if (instance == null) {
            instance = new TimeHelper();
        }
        return instance;
    }

    public long getTime() {
        return time;
    }
    public void increase() {
        time++;
    }
}
