package coding.test;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod, BodyTypes planet) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == BodyTypes.MOON) return super.addSatellite(moon);
        else return false;
    }
}
