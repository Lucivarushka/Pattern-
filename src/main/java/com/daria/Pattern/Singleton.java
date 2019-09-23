package main.java.com.daria.Pattern;

public class Singleton {
    private static Singleton temp;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (temp == null) {
            temp = new Singleton();
        }
        return temp;
    }
}
