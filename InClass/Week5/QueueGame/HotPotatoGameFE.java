package Week5.QueueGame;
import java.util.Scanner;

public class HotPotatoGameFE {

    public static Scanner keyboard = new Scanner(System.in);
    public static HotPotatoGame hpg = new HotPotatoGame();
    public static final int MIN_TIME = 1;
    public static final int MAX_TIME = 10;
    public static void main(String[] args)
    {
        greeting();
        boolean playGame = true;
        while (playGame)
        {
            hpg.resetTime();
            int numPlayers = getPlayerNumber();
            addPlayers(numPlayers);

            boolean gameOver = false;
            while(!gameOver)
            {
                String player = hpg.getCurrentPlayer();
                System.out.println(player+" enter a time to hold the potato from "+MIN_TIME+" TO "+ MAX_TIME);
                int time = keyboard.nextInt();
                keyboard.nextLine();

                if(time < MIN_TIME || time > MAX_TIME)
                {
                    System.out.println("Incorrect Value. Follow guidelines. Assuming Max value instead.");
                    time = MAX_TIME;
                }
                if(hpg.hasLost(time))
                {
                    System.out.println(player+" has been eliminated");
                    hpg.resetTime();
                }
                else
                {
                    hpg.addPlayer(player);
                }
                gameOver = hpg.getWin();
            }
            System.out.println("The winner is "+ hpg.getCurrentPlayer());
            System.out.println("Enter \"Yes\" to play again");
            String playAgain = keyboard.nextLine();
            if(playAgain.equalsIgnoreCase(playAgain) && playAgain != null)
                continue;
            else
                System.out.println("Goodbye");
                playGame = false;
        }
    }

    public static void greeting()
    {
        System.out.println("Welcome to the Hot Potato Game");
    }

    public static int getPlayerNumber()
    {
        int num = 0;
        while(num <=1)
        {
            System.out.println("Enter the number of players, must be greater than 1.");
            num = keyboard.nextInt();
            keyboard.nextLine();
        }

        return num;
    }

    public static void addPlayers(int num)
    {
        int i =0;
        while(i<num)
        {
            System.out.println("Enter player name");
            String input = keyboard.nextLine();

            if(input == null || input.isEmpty())
            {
                System.out.println("Invalid input");
                continue;
            }
            else
            {
                hpg.addPlayer(input);
            }
            i++;
        }
    }


    
}
