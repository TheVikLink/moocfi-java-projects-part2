/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author olehenrikvik
 */
public class Thermometer implements Sensor {

    private boolean thermometerIsOn;

    public Thermometer() {
        this.thermometerIsOn = false;
    }

    @Override
    public boolean isOn() {
        return thermometerIsOn;
    }

    @Override
    public void on() {
        thermometerIsOn = true;
    }

    @Override
    public void off() {
        thermometerIsOn = false;
    }

    @Override
    public int measure() {
        if (!isOn()) {
            throw new IllegalStateException();
        }
        return ThreadLocalRandom.current().nextInt(-30, 31);
    }

}
