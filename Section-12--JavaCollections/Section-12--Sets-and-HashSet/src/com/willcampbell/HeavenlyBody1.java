package com.willcampbell;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody1 {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody1> satellites;

    public enum BodyTypes1 {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody1(BodyTypes1 bodyType, String name, double orbitalPeriod) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public Double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody1 satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody1> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof HeavenlyBody1) {
            HeavenlyBody1 theO = (HeavenlyBody1) o;
            return this.key.equals(theO.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return key.name + ": " + key.bodyType.name().charAt(0)
                + key.bodyType.name().substring(1).toLowerCase()
                .replace("_", " ") + ", " + orbitalPeriod;
    }

    public static Key makeKey(String name, BodyTypes1 bodyType) {
        return new Key(name, bodyType);
    }

    public static final class Key {
        private final String name;
        private final BodyTypes1 bodyType;

        private Key(String name, BodyTypes1 bodyType) {
            this.bodyType = bodyType;
            this.name = name;
        }

        public BodyTypes1 getBodyType() {
            return bodyType;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(getName(), key.getName()) && getBodyType() == key.getBodyType();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getBodyType(), 101);
        }

        @Override
        public String toString() {
            return name + ": " + bodyType;
        }
    }
}
