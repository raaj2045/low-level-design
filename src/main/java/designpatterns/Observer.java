package designpatterns;

import java.util.ArrayList;
import java.util.List;

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update();
}

class ObservableConcreteClass implements Observable {
    private int data;
    private final List<Observer> observers;

    public ObservableConcreteClass() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
        notifyObservers();
    }
}

class ObserverConcreteClass implements Observer {
    private final ObservableConcreteClass observable;

    public ObserverConcreteClass(ObservableConcreteClass observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Data changed to " + observable.getData());
    }
}



class Main {
    public static void main(String[] args) {
        ObservableConcreteClass weatherStation = new ObservableConcreteClass();

        ObserverConcreteClass tvDisplayObserver = new ObserverConcreteClass(weatherStation);
        ObserverConcreteClass mobileDisplayObserver = new ObserverConcreteClass(weatherStation);

        weatherStation.addObserver(tvDisplayObserver);
        weatherStation.addObserver(mobileDisplayObserver);
        weatherStation.setData(10);
        weatherStation.removeObserver(tvDisplayObserver);
        weatherStation.setData(20);
    }
}