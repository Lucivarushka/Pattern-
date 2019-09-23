package main.java.com.daria.Pattern;

public class Memento {
    public static void main(String[] args) {
        Light light = new Light();
        light.setState("Turn on");
        light.printState();

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(light.createMementoLight());
        light.setState("Turn off");
        light.printState();

        light.setMemento(caretaker.getMemento());
        light.printState();
    }
}

class Light {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String newState) {
        state = newState;
    }

    public MementoForLight createMementoLight() {
        return new MementoForLight(state);
    }

    public void setMemento(MementoForLight memento) {
        state = memento.getState();
    }

    public void printState(){
        System.out.println(state);
    }
}

class MementoForLight {
    private String state;

    public MementoForLight(String newState) {
        state = newState;
    }

    public String getState() {
        return state;
    }
}

class Caretaker {
    private MementoForLight memento;

    public MementoForLight getMemento() {
        return memento;
    }

    public void setMemento(MementoForLight newMemento) {
        memento = newMemento;
    }
}