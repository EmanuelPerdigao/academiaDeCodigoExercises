import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.Scanner;
public class Dealer
{

    private static int randomNumber;
    private boolean isRightNumber;


    public Dealer(int Number) {
        this.randomNumber = Number;
        this.isRightNumber = false;

        welcome();
    }

    public Dealer() {
        this.isRightNumber = false;
        randomNumber = 8;

        welcome();
    }

    public void welcome() {
        System.out.println("\n****************************************");
        System.out.println("========= Welcome to the game ==========");
        System.out.println("****************************************\n");
    }

    public boolean isRightGuess(int playerGuess, String playerName)
    {
        if (playerGuess == randomNumber) {
            System.out.println("\nThe player " + playerName + " guessed the right number!!!");
            return true;
        } else {
            System.out.println("Wrong guess " + playerName + "\n");
            return false;
        }

    }

    public void mechanism() {
        int playerAmmount = 0;
        boolean guessed = false;
        int guess;

        //scan user input
        Prompt promt = new Prompt(System.in, System.out);
        IntegerInputScanner scannerInt = new IntegerInputScanner();
        StringInputScanner scannerString = new StringInputScanner();

        System.out.println("How many players will play the game?");

        //scan user input to know how many players will play and store it in a variable playerAmmount
        do
        {
            System.out.println("Write a number greater then 1.");
            playerAmmount = promt.getUserInput(scannerInt);
        }
        while (playerAmmount <= 1);

        Player[] playerArray = new Player[playerAmmount];


        //scan for all players names
        for (int i = 0; i < playerAmmount; i++) {

           /* System.out.println("\nType player number " + (i + 1) + " name" + "\n");*/

            scannerString.setMessage("\nType player number " + (i + 1) + " name: ");
            String playerName = promt.getUserInput(scannerString);
            playerArray[i] = new Player(playerName);
        }

        while (!guessed)
        {

            for (int i = 0; i < playerArray.length; i++)
            {

                do
                {
                    //scan user input to guess the number
                    scannerInt.setMessage("Player " + playerArray[i].getName() + " guess the number: ");
                    scannerInt.setError("Try a number between 1 and 20");

                    guess = promt.getUserInput(scannerInt);
                }
                while (guess > 20 || guess < 1);

                if (isRightGuess(playerArray[i].guessNumber(guess), playerArray[i].getName()))
                {
                    guessed = true;
                    System.exit(0);
                }
            }
        }


    }
}
