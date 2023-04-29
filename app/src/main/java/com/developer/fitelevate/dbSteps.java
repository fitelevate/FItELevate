package com.developer.fitelevate;

public class dbSteps {
    int stepCount;
    int calory;
    int distance;

    dbSteps(){};

    public dbSteps(int stepCount, int calory, int distance) {
        this.stepCount = stepCount;
        this.calory = calory;
        this.distance = distance;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public int getCalory() {
        return calory;
    }

    public void setCalory(int calory) {
        this.calory = calory;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
