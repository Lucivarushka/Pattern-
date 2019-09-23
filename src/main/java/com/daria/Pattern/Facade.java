package main.java.com.daria.Pattern;

public class Facade {
    public static void main(String[] args) {
        GPSPower power = new GPSPower();
        GPSNotifier notifier = new GPSNotifier();
        RoadAdvisor advisor = new RoadAdvisor();

        GPSInterface gps = new GPSInterface(power, notifier, advisor);

        gps.activate();

        power.powerOff();
    }
}

class GPSPower {
    public void powerOn() {
        System.out.println("GPS On");
    }

    public void powerOff() {
        System.out.println("GPS Off");
    }
}

class GPSNotifier {
    public void downloadRoadInfo() {
        System.out.println("Загрузка информации о дорогах");
    }
}

class RoadAdvisor {
    public void route() {
        System.out.println("Маршрут построен");
    }
}

class GPSInterface {
    private GPSPower power;
    private GPSNotifier notifier;
    private RoadAdvisor advisor;

    public GPSInterface(GPSPower power, GPSNotifier notifier, RoadAdvisor advisor) {
        this.power = power;
        this.notifier = notifier;
        this.advisor = advisor;
    }

    public void activate() {
        power.powerOn();
        notifier.downloadRoadInfo();
        advisor.route();
    }
}