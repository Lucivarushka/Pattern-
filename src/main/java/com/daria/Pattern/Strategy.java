package main.java.com.daria.Pattern;

public class Strategy {
    public static void main(String[] args) {
        Fish perch = new Perch();
        perch.performSwim();
        perch.setSwim(new SeaFish());
        perch.performSwim();
        perch.setSwim(new FreshwaterFish());
        perch.performSwim();
    }
}

abstract class Fish {
    private Swim swim;

    public void setSwim(Swim swim) {
        this.swim = swim;
    }

    public void performSwim() {
        swim.fin();
    }
}

interface Swim {

    public void fin();

}

class SeaFish implements Swim {
    public void fin() {
        System.out.println("Fish lives in sea water");
    }
}

class FreshwaterFish implements Swim {
    public void fin() {
        System.out.println("Fish lives in fresh water");
    }
}

class Shark extends Fish {
    public Shark() {
        setSwim(new SeaFish());
    }
}

class Perch extends Fish {
    public Perch() {
        setSwim(new FreshwaterFish());
    }
}
