package main.java.com.daria.Pattern;

public class Bridge {
    public static void main(String[] args) {
        Animal animal = new Mammal(new Tiger());

        animal.typeOfAnimal();
    }
}

abstract class Animal {
    Type type;

    public Animal(Type type) {
        this.type = type;
    }

    abstract void showType();

    void typeOfAnimal() {
        showType();
        type.setType();
    }
}

class Mammal extends Animal {
    public Mammal(Type type) {
        super(type);
    }

    void showType() {
        System.out.println("Mammal");
    }
}

class Amphibian extends Animal {
    public Amphibian(Type type) {
        super(type);
    }

    void showType() {
        System.out.println("Amphibian");
    }
}

interface Type {

    void setType();

}

class Tiger implements Type {
    public void setType() {
        System.out.println("Tiger");
    }
}

class Frog implements Type {
    public void setType() {
        System.out.println("Frog");
    }
}

class Elephant implements Type {
    public void setType() {
        System.out.println("Elephant");
    }
}
