import java.util.concurrent.ThreadLocalRandom;

public class Generate {
    public static int red(){
        return ThreadLocalRandom.current().nextInt(255);
    }
    public static int green(){
        return ThreadLocalRandom.current().nextInt(255);
    }
    public static int blue(){
        return ThreadLocalRandom.current().nextInt(255);
    }
}
