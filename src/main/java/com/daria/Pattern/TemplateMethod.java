package main.java.com.daria.Pattern;

public class TemplateMethod {
    public static void main(String[] args) {
        Flowers rose = new Rose();
        Flowers tulip = new Tulip();
        rose.printFlowers();
        tulip.printFlowers();
    }
}

abstract class Flowers {
    public void printFlowers() {
        System.out.print("Pink ");
        differ();
        System.out.print(" bloom in the garden");
        System.out.println();
    }

    abstract void differ();
}

class Rose extends Flowers {
    public void differ() {
        System.out.print("roses");
    }
}

class Tulip extends Flowers {
    public void differ() {
        System.out.print("tulips");
    }
}
