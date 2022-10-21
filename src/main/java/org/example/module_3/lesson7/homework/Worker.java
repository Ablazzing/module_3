package org.example.module_3.lesson7.homework;

public class Worker {
    private boolean isTired;
    private int countCreatedBricks;

    public Worker(boolean isTired) {
        this.isTired = isTired;
    }

    public Worker() {
    }

    public Brick createBrick() throws WorkerTiredException {
        if (countCreatedBricks > 9) {
            isTired = true;
        }

        if (isTired) {
            throw new WorkerTiredException();
        }
        countCreatedBricks++;
        return new Brick();
    }
}
