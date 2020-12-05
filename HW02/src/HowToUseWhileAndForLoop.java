public class HowToUseWhileAndForLoop {

    public static void main(String[] args) {

        boolean notReady = true;

        while (notReady) {
            System.out.println("Started while");

            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 3) {
                    notReady = false;
                    break;
                }
            }

            System.out.println("It also prints this");
        }

        System.out.println("Now out of while and for-loop");
    }
}
