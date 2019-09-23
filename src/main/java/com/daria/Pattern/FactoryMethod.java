package main.java.com.daria.Pattern;


interface Cat {
    void purr();
}

class PersianCat implements Cat {
    public void purr() {
        System.out.println("Uppp");
    }
}

class RussianCat implements Cat {
    public void purr() {
        System.out.println("Rrrr");
    }
}

interface CatMaker {
    Cat createCat();
}

class PersianCatFactory implements CatMaker {
    public Cat createCat() {
        return new PersianCat();
    }
}

class RussianCatFactory implements CatMaker {
    public Cat createCat() {
        return new RussianCat();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        CatMaker myPersCat = new PersianCatFactory();
        CatMaker myRusCat = new RussianCatFactory();

        Cat persianCat = myPersCat.createCat();
        Cat russianCat = myRusCat.createCat();

        persianCat.purr();
        russianCat.purr();
    }
}