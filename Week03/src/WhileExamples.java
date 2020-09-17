public class WhileExamples {


    /**
     * On monday morning students wake up at 7:00 and they have lecture of Algorithms at 12:00.
     * Print each hour as XX:00 from 07:00 to 12:00, 7:00 with " wake up" and 12:00 " Algorithms lecture".
     * @param args
     */
    public static void main(String[] args) {

        /*
        Simplest while (true), exit: break;
         */
        System.out.println("while (true)\n====");
        System.out.println("07:00 wake up");
        int i = 8;

        while (true) {
            if (i == 12) {
                System.out.println(i + ":00 Algorithms lecture\n");
                break;
            }
            if (i < 10) {
                System.out.println("0" + i + ":00");
            } else {
                System.out.println(i + ":00");
            }
            i++;
        }

        /*
        While with condition, leaves cycle after filling condition
         */
        System.out.println("while (with condition)\n====");
        System.out.println("07:00 wake up");
        i = 8;

        while (i < 12) {
            if (i < 10) {
                System.out.println("0" + i + ":00");
            } else {
                System.out.println(i + ":00");
            }
            i++;
        }
        System.out.println("12:00 Algorithms lecture\n");

    }

}
