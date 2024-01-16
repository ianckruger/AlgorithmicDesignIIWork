package Homeworks.Homework04;
import java.io.File;
import java.util.Scanner;
/*
 * Written by Ian Krugers
 */

public class RobotCommandManager 
{
    public static final String DELIM = "\n";
    public static final char ROBOT = 'O';
    public static final char EMPTY = '_';
    public static final char OBST = 'X';
    public static final int BOARD_SIZE = 10; 

    private char[][] board; // creates an xy board, where x is each row and y is each index of each row that creates a column

    private QueueI<String> commands;
    private int[] currLoc;

    public RobotCommandManager() //calls init aka the intializer
    {
        this.init();
    }

    private void init() // intializes the board. Set the board to empty, sets the robot to the first top right position of the board, and creates queue
    {
        board = new char[BOARD_SIZE][BOARD_SIZE];

        board[0][0] = ROBOT;
        commands = new LLQueue<String>();
        currLoc = new int[] {0,0};

    }

    public void fileRobotRead(String inputFile) // reads an inputted file to create a list of robot commands
    {
        try
        {
            Scanner fileScanner = new Scanner(new File(inputFile));
            while(fileScanner.hasNextLine())
            {
                String fileLine = fileScanner.nextLine();
                String[] splitLine = fileLine.split(DELIM);
                String command = splitLine[0];
                commands.enqueue(command);
            }
            fileScanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void fileBoardReader(String inputFile) // reads an inputted file to create the course of the board for the robot
    {
        try
        {
            Scanner fileScanner = new Scanner(new File(inputFile));
            int j=0;
            while(fileScanner.hasNextLine() && j < BOARD_SIZE)
            {
                String fileLine = fileScanner.nextLine();
                for (int i = 0;i < BOARD_SIZE && i < fileLine.length(); i++) 
                {
                    char character = fileLine.charAt(i);
                    if (character != '\n') 
                    { // Skip newline characters since splitting it doesnt matter anymore
                        board[j][i] = character;
                    }
                }
                j++;
            }
            fileScanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    public void moveRobot() // accesses the queue to determine what moves should go next
    {
        int j = 0;
        boolean hasntCrashed = true;
        while(!commands.isEmpty())
        {
            if(hasntCrashed == true)
            {
                System.out.println("Command "+j);
                board[currLoc[0]][currLoc[1]] = ROBOT;
                printFullBoard();
                System.out.println("\n\n");
            }
            
            board[currLoc[0]][currLoc[1]] = EMPTY;
            int currY = currLoc[0];
            int currX = currLoc[1];
            String robotMove = commands.dequeue();
            if (robotMove.equalsIgnoreCase("move up"))
            {
                if(isValid(currY-1) && board[currY-1][currX]!=OBST)
                {
                    currLoc[0]--;
                }
                else
                {
                    System.out.println("CRASH");
                    hasntCrashed = false;
                    break;
                    // end simulation
                }
            }
            else if (robotMove.equalsIgnoreCase("move down"))
            {
                if(isValid(currY+1) && board[currY+1][currX]!=OBST)
                {
                    currLoc[0]++;
                }
                else
                {
                    System.out.println("CRASH");
                    hasntCrashed = false;
                    break;
                    // end simulation
                }
            }
            else if (robotMove.equalsIgnoreCase("move left"))
            {
                if(isValid(currX-1) && board[currY][currX-1]!=OBST)
                {
                    currLoc[1]--;
                }
                else
                {
                    System.out.println("CRASH");
                    hasntCrashed = false;
                    break;
                    // end simulation
                }
            }
            else if (robotMove.equalsIgnoreCase("move right"))
            {
                if(isValid(currX+1) && board[currY][currX+1]!=OBST)
                {
                    currLoc[1]++;
                }
                else
                {
                    System.out.println("CRASH");
                    hasntCrashed = false;
                    break;
                    // end simulation
                }
            }
            else
            {
                System.out.println("ERROR: INVALID MOVE IN MOVELIST.\nIGNORING");
            }
            j+=1;
        }
        if(hasntCrashed==true) //if the robot hasnt crashed print the last board with the location since the loop doenst go to the last command
        {
            System.out.println("Command"+j);
            board[currLoc[0]][currLoc[1]] = ROBOT;
            printFullBoard();
            System.out.println("Simulation Ended");
        }
        
    }

    public void printFullBoard() // prints the board by iterating through each index of each row
    {
        for(int i = 0;i<board.length;i++)
        {
            for (int j = 0; j<board.length;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private boolean isValid(int index) //determines if the move is in the board or not
    {
        return index >= 0 && index <BOARD_SIZE;
    }

    public void reset() // initiliazes the board to reset it
    {
        this.init();
    }
}
