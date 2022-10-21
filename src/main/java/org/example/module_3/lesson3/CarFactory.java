package org.example.module_3.lesson3;

public class CarFactory {
    private Worker worker;

    public CarFactory(Worker worker) {
        this.worker = worker;
    }

    public boolean createCar() {
        return worker.makeCar();
    }

    public Wheel createWheel(int radius) {
        return worker.createWheel(radius);
    }
}
