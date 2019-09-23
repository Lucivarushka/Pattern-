package main.java.com.daria.Pattern;

public class Decorator {
    public static void main(String[] args) {
        Hello example = new Asterisk(new Brackets(new Italian("Buongiorno")));
        example.say();
    }
}

interface Hello {

    void say();

}

class Italian implements Hello {
    String greeting;

    public Italian(String greeting) {
        this.greeting = greeting;
    }

    public void say() {
        System.out.print(greeting);
    }
}

class Brackets implements Hello {
    Hello component;

    public Brackets(Hello component) {
        this.component = component;
    }

    public void say() {
        System.out.print("\"");
        component.say();
        System.out.print("\"");
    }
}

class Asterisk implements Hello {
    Hello component;

    public Asterisk(Hello component) {
        this.component = component;
    }

    public void say() {
        System.out.print("*");
        component.say();
        System.out.print("*");
    }
}