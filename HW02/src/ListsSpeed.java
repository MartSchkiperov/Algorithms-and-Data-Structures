import java.util.*;

public class ListsSpeed {

    public static void main(String[] args) {

        int maxLength = 100_000;
        Random rand = new Random();
        int[] array = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            array[i] = rand.nextInt(1000);
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < maxLength; i++) {
            linkedList.add(array[i]);
        }
        for (int i = 0; i < maxLength; i++) {
            //int a = linkedList.poll();
            int a = linkedList.pop();
if (i < 10) System.out.println(a);
            //int a = linkedList.get(i);
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("linkedList pop: " + (stopTime - startTime) + "ms\n");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < maxLength; i++) {
            linkedList.add(array[i]);
        }
        for (int i = 0; i < maxLength; i++) {
            int a = linkedList.poll();
            //int a = linkedList.pop();
if (i < 10) System.out.println(a);
            //int a = linkedList.get(i);
        }
        stopTime = System.currentTimeMillis();
        System.out.println("linkedList POLL: " + (stopTime - startTime) + "ms\n");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < maxLength; i++) {
            linkedList.add(array[i]);
        }
        for (int i = 0; i < maxLength; i++) {
            int a = linkedList.pollFirst();
            //int a = linkedList.pop();
if (i < 10) System.out.println(a);
            //int a = linkedList.get(i);
        }
        stopTime = System.currentTimeMillis();
        System.out.println("linkedList POLL FIRST: " + (stopTime - startTime) + "ms\n");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < maxLength; i++) {
            linkedList.add(array[i]);
        }
        for (int i = 0; i < maxLength; i++) {
            int a = linkedList.pollLast();
            //int a = linkedList.pop();
if (i < 10) System.out.println(a);
            //int a = linkedList.get(i);
        }
        stopTime = System.currentTimeMillis();
        System.out.println("linkedList POLL LAST: " + (stopTime - startTime) + "ms\n");


        startTime = System.currentTimeMillis();
        Node startNode = new Node(null, array[maxLength - 1]);
        for (int i = maxLength - 2; i > -1; i--) {
            startNode = new Node(startNode, array[i]);
        }
        for (int i = 0; i < maxLength; i++) {
            int a = startNode.value;
if (i < 10) System.out.println(a);
            startNode = startNode.next;
        }
        stopTime = System.currentTimeMillis();
        System.out.println("node: " + (stopTime - startTime) + "ms\n");


        startTime = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            list.add(array[i]);
        }
        for (int i = 0; i < maxLength; i++) {
            int a = list.get(i);
if (i < 10) System.out.println(a);
        }
        stopTime = System.currentTimeMillis();
        System.out.println("list: " + (stopTime - startTime) + "ms\n");


        startTime = System.currentTimeMillis();
        list = new ArrayList<>();
        for (int a : array) {
            list.add(a);
        }
        int i = 0;
        while (list.size() != 0) {
            int a = list.remove(0);
if (i < 10) { System.out.println(a);
                i++;
            }
        }
        stopTime = System.currentTimeMillis();
        System.out.println("list REMOVE(0): " + (stopTime - startTime) + "ms\n");
    }


    static public class Node {
        Node next;
        int value;

        public Node(Node next, int value) {
            this.value = value;
            this.next = next;
        }
    }

}
