package com.willcampbell;

public class Planet1 extends HeavenlyBody1 {

    public Planet1(String name, double orbitalPeriod) {
        super(BodyTypes1.PLANET, name, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody1 moon) {
        if (moon.getKey().getBodyType() == BodyTypes1.MOON) {
            return super.addSatellite(moon);
        } else {
            return false;
        }
    }
}
