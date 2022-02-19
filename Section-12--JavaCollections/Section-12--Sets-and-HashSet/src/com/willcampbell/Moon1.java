package com.willcampbell;

public class Moon1 extends HeavenlyBody1 {
    public Moon1(String name, double orbitalPeriod) {
        super(BodyTypes1.MOON, name, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody1 satellite) {
        return false;
    }
}
