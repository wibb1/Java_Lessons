package coding.test;

public class Main {
    public static void main(String[] args) {
        Planet mars = new Planet("Mercury", 88, HeavenlyBody.BodyTypes.PLANET);
        Planet mars2 = new Planet("Mercury", 88, HeavenlyBody.BodyTypes.PLANET);
        Planet venus = new Planet("Venus", 225, HeavenlyBody.BodyTypes.PLANET);
        Planet earth = new Planet("Earth", 365, HeavenlyBody.BodyTypes.PLANET);
        Moon moon = new Moon("Moon", 27);

        Moon deimos = new Moon("Deimos", 1.3);
        Moon phobos = new Moon("Phobos", 0.3);
        Planet jupiter = new Planet("Jupiter", 4332, HeavenlyBody.BodyTypes.PLANET);
        Moon io = new Moon("Io", 1.8);
        Moon europa = new Moon("Europa", 3.5);
        Moon ganymede = new Moon("Ganymede", 7.1);
        Moon callisto = new Moon("Callisto", 16.7);
        Planet saturn = new Planet("Saturn", 10759, HeavenlyBody.BodyTypes.PLANET);
        Planet uranus = new Planet("Uranus", 30660, HeavenlyBody.BodyTypes.PLANET);
        Planet neptune = new Planet("Neptune", 165, HeavenlyBody.BodyTypes.PLANET);
        DwarfPlanet pluto = new DwarfPlanet("Pluto", 248.0);
        System.out.println(earth.addSatellite(moon) + " Earth-Moon\n" +
                jupiter.addSatellite(io) + " jupiter-io\n" +
                jupiter.addSatellite(europa) + " jupiter-europa\n" +
                jupiter.addSatellite(ganymede) + " jupiter-ganymede\n" +
                jupiter.addSatellite(callisto) + " jupiter-callisto\n" +
                mars.addSatellite(deimos) + " mars-deimos\n" +
                mars.addSatellite(phobos) + " mars-phobos\n" +
                mars.addSatellite(mars2) + " mars-mars2\n");
        System.out.println(venus);
        System.out.println(earth);
        System.out.println(moon);
        System.out.println(mars);
        System.out.println("mars == mars2 - " + mars.equals(mars2));


    }
}
