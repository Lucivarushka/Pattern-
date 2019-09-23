package main.java.com.daria.Pattern;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        Weather weather = new Weather();
        WeatherReport report = new WeatherReport();
        weather.addWeather("+ 25");
        weather.addObserver(report);
        weather.addWeather("+ 32");
        weather.addWeather("- 2");
        weather.removeStudent("- 2");
    }
}

interface ObserverEvent {

    void event(List<String> changeData);

}


class Weather {
    private List<ObserverEvent> observers = new ArrayList<>();
    private List<String> weather = new ArrayList<>();

    public void addWeather(String temp) {
        weather.add(temp);
        notifyObservers();
    }

    public void removeStudent(String name) {
        weather.remove(name);
        notifyObservers();
    }

    public void addObserver(ObserverEvent observer) {
        observers.add(observer);
    }

    public void removeObserver(ObserverEvent observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ObserverEvent observer : observers) {
            observer.event(weather);
        }
    }
}

class WeatherReport implements ObserverEvent {
    public void event(List<String> changeDataWeather) {
        System.out.println("The report of weather has changed: " + changeDataWeather);
    }
}
