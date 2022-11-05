import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static final Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        try (BufferedWriter locWriter = new BufferedWriter(new FileWriter("locations.txt"));
             BufferedWriter dirWriter = new BufferedWriter(new FileWriter("directions.txt"))) {
            for (Location location : locations.values()) {
                locWriter.write(location.getLocationID() + ", " + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q"))
                        dirWriter.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }
    }

    static {
        try (BufferedReader locReader = new BufferedReader(new FileReader("locations_big.txt"))) {
            locReader.lines().forEach(line -> {
                String[] data = line.split(",");
                int loc = Integer.parseInt(data[0]);
                String desc = data[1];
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, desc, tempExit));
                System.out.println("Imported loc: " + loc + "," + desc);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader dirReader = new BufferedReader(new FileReader("directions_big.txt"))) {
            dirReader.lines().forEach(line -> {
                String[] data = line.split(",");
                int loc = Integer.parseInt(data[0]);
                String dir = data[1];
                int dest = Integer.parseInt(data[2]);
                System.out.println(loc + "," + dir + "," + dest);
                Location location = locations.get(loc);
                location.addExit(dir, dest);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
