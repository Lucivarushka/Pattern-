package main.java.com.daria.Pattern;

public class Adapter {
    public static void main(String[] args) {
        RunAndThrowing adapter = new SportsmanAdapter(new Sportsman());
        adapter.run();
        adapter.throwing();
    }
}

interface RunAndThrowing {
    void run();

    void throwing();
}

class Sportsman {
    public void obstacleCourse() {
        System.out.println("Начать бег");
    }

    public void throwingCore() {
        System.out.println("Метнуть ядро");
    }
}

class SportsmanAdapter implements RunAndThrowing {
    private Sportsman sportsman = null;

    public SportsmanAdapter(Sportsman sportsman) {
        this.sportsman = sportsman;
    }

    @Override
    public void run() {
        sportsman.obstacleCourse();
    }

    @Override
    public void throwing() {
        sportsman.throwingCore();
    }
}