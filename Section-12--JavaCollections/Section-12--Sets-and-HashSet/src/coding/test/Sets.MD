Sets

Modify the previous `HeavenyBody` examples so that the `HeavenlyBody` class also has a "`bodyType`" field. This field
will stor the type of HeavenlyBody (PLANET, DWARF_PLANET, MOON).

For each of the three types that is supported, subclass the HeavenlyBody class so that your program can create objects
of the appropriate type.

There is a restriction to that the only satellites that planets can have are moons.

Implement the following:

1. HeavenlyBody

- It has three private final fields. a key called key, a double called orbitalPeriod and a Set of type HeavenlyBody
  called satellites.
- A constructor that takes a String (name of the HeavenlyBody), a double (its orbital period) and a BodyType. key is
  initialized with a new key object and satellites is initialized with a new HashSet.
- Eight methods:
    - getOrbitalPeriod(), getKey(), boolean addSatellite(HeavenlyBody) (true if successful),getSatellites(), public
      final equals() (compares HeavenlyBodies keys), hashCode() (return hashCode of key), public static key makeKey(),
      toString() (return string "name: {bodyType}, {orbitalPeriod}"
- public Enum bodyTypes
- public static final key

1. BodyTypes (nested enum)
    - It has three constants Planet, DWARF_PLANET, MOON
2. Key(nested class)
    - It has two fields: String name, BodyTypes bodyType
    - A constructor declared as private that takes a Strng and a BodyType and initializes the fields within it.
    - 5 other methods: getName(), getBodyType(), equals() compare two key objects if they have the same name and
      bodyType, hashCode using name and bodytype + a number, toString() (returns name: bodyType)
3. Planet
    - constructor with String name and double orbitalPeriod
    - addSatellite(Moon moon)
4. DwarfPlanet
    - constructor with String name and double orbitalPeriod
5. Moon
    - constructor with String name and double orbitalPeriod

TIP: be extremely careful with the spelling the names of the fields, constructors and methods TIP: B extremely careful
about spaces/spelling and format in the returned String by toString()

NOTE: All fields are private (unless stated otherwise)
NOTE: All constructors are public (unless stated otherwise)
NOTE: All methods are public (unless stated otherwise)
NOTE: Do not add a main method to the solution code
