import java.util.*;

public class SimpleEntryHashMap {

    public static void main(String[] args) {
        HashMap<AbstractMap.SimpleEntry, AbstractMap.SimpleEntry> previous = new HashMap<>();
        previous.put(new AbstractMap.SimpleEntry(1, 0), new AbstractMap.SimpleEntry(0, 0));
        previous.put(new AbstractMap.SimpleEntry(1, 1), new AbstractMap.SimpleEntry(1, 0));
        previous.put(new AbstractMap.SimpleEntry(3, 1), new AbstractMap.SimpleEntry(1, 1));

        System.out.println("map: " + previous);
        System.out.println("does contain [1, 1]?: " + previous.containsKey(new AbstractMap.SimpleEntry(1, 1)));

        AbstractMap.SimpleEntry<Integer, Integer> startpoint = new AbstractMap.SimpleEntry(3, 1);
        System.out.println("\nmoves: ");
        System.out.println(startpoint);
        while(true) {
            int south = startpoint.getKey();
            int east = startpoint.getValue();
            startpoint = previous.get(startpoint);
            System.out.println(startpoint);
            if (startpoint.getKey() - south != 0) System.out.println("moved south");
            else System.out.println("moved east");
            if (startpoint.getKey() == 0 && startpoint.getValue() == 0) break;
        }
    }
}
