package ee.ttu.algoritmid.guessinggame;

import java.util.Random;

public class GameTester {

    public static void main(String[] args) {
        Fruit[] fruitArray = {new Fruit("Apelsin", 150),
                new Fruit("Banaan", 185),
                new Fruit("Greip", 250),
                new Fruit("Mango", 210),
                new Fruit("Pirn", 170),
                new Fruit("Ploom", 50),
                new Fruit("Virsik", 130),
                new Fruit("Õun", 110)
        };

        Random rand = new Random();
        int correctGuessings = 0;

        for (int i = 0; i < 10; i++) {
            String testingMessage = "Tested random fruit: ";

            Fruit testedFruit;
            if (i == 0) {
                testedFruit = new Fruit("Ploom", 50);
                testingMessage = "\nSmallest mass fruit: ";
            }
            else if (i == 1) {
                testedFruit = new Fruit("Greip", 250);
                testingMessage = "Biggest mass fruit: ";
            }
            else if (i == 2) {
                testedFruit = new Fruit("Apelsin", 150);
                testingMessage = "First fruit in array: ";
            }
            else if (i == 3) {
                testedFruit = new Fruit("Õun", 110);
                testingMessage = "Last fruit in array: ";
            }
            else testedFruit = fruitArray[rand.nextInt(fruitArray.length)];

            System.out.println(testingMessage + testedFruit.getName());

            Oracle oracle = new Oracle(testedFruit);
            GuessingGame game = new GuessingGame(oracle);
            String gameResult = game.play(fruitArray);

            if (testedFruit.getName().equals(gameResult)) {
                System.out.println("Guesser result correct: " + gameResult);
                correctGuessings++;
            } else {
                System.out.println("### Guesser result NOT CORRECT: " + gameResult + " ###");
            }
            System.out.println();
        }

        if (correctGuessings == 10) {
            System.out.println("=====\nAll 10 guessings corrrect!");
        } else {
            System.out.println("=====\nCorrrect only " + correctGuessings + " guessings from 10\n");
        }
    }
}
