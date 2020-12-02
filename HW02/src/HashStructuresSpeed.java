import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class HashStructuresSpeed {

    public static void main(String[] args) {
        Random rand = new Random();

        HashMap<SimpleEntry, List> hashMap = new HashMap<>();
        Map<SimpleEntry, List> map = new HashMap<>();
        HashSet<SimpleEntry> hashSet = new HashSet<>();
        SimpleEntry[][] simpleEntryArray = new SimpleEntry[1000][1000];

        List<SimpleEntry> simpleEntryList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            simpleEntryList.add(new SimpleEntry(i, i+1));
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            hashMap.put(new SimpleEntry(rand.nextInt(1000), rand.nextInt(1000)), simpleEntryList);
        }
        String numberString = numberToString((System.currentTimeMillis() - startTime));
        System.out.println("\nHashMap<SimpleEntry, List> million entries: " + numberString + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.put(new SimpleEntry(rand.nextInt(1000), rand.nextInt(1000)), simpleEntryList);
        }
        numberString = numberToString((System.currentTimeMillis() - startTime));
        System.out.println("\nMap<SimpleEntry, List> million entries: " + (numberString + "ms"));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            hashSet.add(new SimpleEntry(rand.nextInt(1000), rand.nextInt(1000)));
        }
        numberString = numberToString((System.currentTimeMillis() - startTime));
        System.out.println("\nHashSet<SimpleEntry> million entries: " + numberString + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            for (int j = 0; j < 1_000; j++) {
                simpleEntryArray[i][j] = new SimpleEntry(rand.nextInt(1000), rand.nextInt(1000));
            }
        }
        System.out.println("\nSimpleEntryArray[][] million: " + (System.currentTimeMillis() - startTime) + "ms\n");

    }


    public static String numberToString(long number) {
        String number2string = number % 1000 + "";
        if (number2string.length() == 1) number2string = "00" + number2string;
        else if (number2string.length() == 2) number2string = "0" + number2string;
        return number / 1000 + " " + number2string;
    }

}
