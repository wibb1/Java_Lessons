package com.willcampbell;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class HeavenlyBody {
    private final int bodyType;
    private final String name;
    private final Double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(int bodyType, String name, Double orbitalPeriod) {
        this.bodyType = bodyType;
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getBodyType() {
        return bodyType;
    }

    public Double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeavenlyBody that = (HeavenlyBody) o;
        return Objects.equals(getBodyType(), that.getBodyType()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBodyType(), getName());
    }
}
