package main.java.com.daria.Pattern;

public class Prototype {
    public static void main(String[] args) {
        Dog dog = new Dog("Ser", 2);
        System.out.println(dog);

        Dog clone = (Dog) dog.copy();
        System.out.println(clone);
    }
}

interface Copyable {
    Object copy();
}

class Dog implements Copyable {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object copy() {
        Dog copyDog = new Dog(name, age);
        return copyDog;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
