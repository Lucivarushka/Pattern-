package main.java.com.daria.Pattern;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        Fly pasAir = new PassengerAircraft();
        Fly pasAir2 = new PassengerAircraft();
        Fly helicopter = new Helicopter();
        Fly aviette = new Aviette();

        CompositeApp composit = new CompositeApp();

        composit.addComponent(new Helicopter());
        composit.addComponent(new PassengerAircraft());
        composit.addComponent(aviette);
        composit.addComponent(pasAir);
        composit.addComponent(helicopter);
        composit.addComponent(pasAir2);

        composit.wing();

        composit.removeComponent(pasAir);
        composit.removeComponent(pasAir2);

        composit.wing();
    }
}

interface Fly {

    void wing();

}

class PassengerAircraft implements Fly {
    public void wing() {
        System.out.println("It's Passenger Aircraft");
    }
}

class Helicopter implements Fly {
    public void wing() {
        System.out.println("It's Helicopter");
    }
}

class Aviette implements Fly {
    public void wing() {
        System.out.println("It's Aviette");
    }
}

class CompositeApp implements Fly {
    private List<Fly> componentsOfPlanes = new ArrayList<>();

    public void addComponent(Fly component) {
        componentsOfPlanes.add(component);
    }

    public void removeComponent(Fly component) {
        componentsOfPlanes.remove(component);
    }

    public void wing() {
        for (Fly component : componentsOfPlanes) {
            component.wing();
        }
    }
}
