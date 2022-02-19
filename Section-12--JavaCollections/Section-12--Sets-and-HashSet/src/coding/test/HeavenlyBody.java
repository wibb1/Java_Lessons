package coding.test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = makeKey(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    public Key getKey() {
        return this.key;
    }

    public double getOrbitalPeriod() {
        return this.orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody body) {
        return this.satellites.add(body);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        return this.getKey().equals(((HeavenlyBody) obj).getKey());
    }

    @Override
    public final int hashCode() {
        return this.getKey().hashCode() + 57;
    }

    @Override
    public String toString() {
        return key.getName() + ": " + key.getBodyType() + ", " +
                orbitalPeriod;
    }

    public static class Key {
        private final String name;
        private final BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.bodyType = bodyType;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return getName().equals(key.getName()) && getBodyType() == key.getBodyType();
        }

        @Override
        public String toString() {
            return name + ": " + bodyType;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getBodyType());
        }
    }


    public enum BodyTypes {
        PLANET,
        DWARF_PLANET,
        MOON
    }
}
