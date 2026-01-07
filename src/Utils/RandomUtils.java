package Utils;

public class RandomUtils {
    public boolean chance(double probability) {
        return false;
    }

    public int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
