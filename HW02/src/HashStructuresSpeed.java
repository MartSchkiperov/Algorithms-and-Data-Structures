import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class HashStructuresSpeed {

    public static void main(String[] args) {
        Random rand = new Random();

        int[] randomArray = new int[1_000_000];
        HashMap<SimpleEntry<Integer, Integer>, List<SimpleEntry<Integer, Integer>>> hashMap = new HashMap<>();
        Map<SimpleEntry<Integer, Integer>, List<SimpleEntry<Integer, Integer>>> map = new HashMap<>();
        HashSet<SimpleEntry<Integer, Integer>> hashSet = new HashSet<>();
        List<SimpleEntry<Integer, Integer>> list = new ArrayList<>();
        SimpleEntry<Integer, Integer>[][] simpleEntryArray = new SimpleEntry[1000][1000];

        List<SimpleEntry<Integer, Integer>> simpleEntryList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            simpleEntryList.add(new SimpleEntry<>(i, i+1));
        }
        for (int i = 0; i < 1_000_000; i++) {
            randomArray[i] = rand.nextInt(1_000);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            hashMap.put(new SimpleEntry<>(rand.nextInt(1000), rand.nextInt(1000)), simpleEntryList);
        }
        String numberString = numberToString((System.currentTimeMillis() - startTime));
        System.out.println("\nHashMap<SimpleEntry, List> adding million entries: " + numberString + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            hashMap.get(new SimpleEntry<>(randomArray[i], randomArray[i]));
        }
        numberString = numberToString((System.currentTimeMillis() - startTime));
        System.out.println("HashMap<SimpleEntry, List> contains million times: " + numberString + "ms");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.put(new SimpleEntry(rand.nextInt(1000), rand.nextInt(1000)), simpleEntryList);
        }
        numberString = numberToString((System.currentTimeMillis() - startTime));
        System.out.println("\nMap<SimpleEntry, List> adding million entries: " + (numberString + "ms"));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.get(new SimpleEntry<>(randomArray[i], randomArray[i]));
        }
        numberString = numberToString((System.currentTimeMillis() - startTime));
        System.out.println("Map<SimpleEntry, List> contains million times: " + numberString + "ms");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            hashSet.add(new SimpleEntry(rand.nextInt(1000), rand.nextInt(1000)));
        }
        numberString = numberToString((System.currentTimeMillis() - startTime));
        System.out.println("\nHashSet<SimpleEntry> adding million entries: " + numberString + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            hashSet.contains(new SimpleEntry<>(randomArray[i], randomArray[i]));
        }
        numberString = numberToString((System.currentTimeMillis() - startTime));
        System.out.println("HashSet<SimpleEntry> contains million times: " + numberString + "ms");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            for (int j = 0; j < 1_000; j++) {
                simpleEntryArray[i][j] = new SimpleEntry<>(rand.nextInt(1000), rand.nextInt(1000));
            }
        }
        System.out.println("\nSimpleEntryArray[][] adding million entries: " + (System.currentTimeMillis() - startTime) + "ms");

        SimpleEntry<Integer, Integer> contains;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            contains = simpleEntryArray[randomArray[i]][randomArray[i]];
        }
        System.out.println("SimpleEntryArray[][] contains million times: " + (System.currentTimeMillis() - startTime) + "ms");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(new SimpleEntry(1, i));
        }
        System.out.println("\nList<SimpleEntry> adding million entries: " + (System.currentTimeMillis() - startTime) + "ms");

        System.out.println("Patience, may take even 1 hour of your life!");
        startTime = System.currentTimeMillis();
        for (int i = 999_999; i > -1; i--) {
            list.contains(new SimpleEntry<>(1, i));
        }
        numberString = numberToString((System.currentTimeMillis() - startTime));
        System.out.println("List<SimpleEntry> contains million times: " + numberString + "ms");

    }


    public static String numberToString(long number) {
        String number2string = number % 1000 + "";
        if (number2string.length() == 1) number2string = "00" + number2string;
        else if (number2string.length() == 2) number2string = "0" + number2string;
        return number / 1000 + " " + number2string;
    }

}
