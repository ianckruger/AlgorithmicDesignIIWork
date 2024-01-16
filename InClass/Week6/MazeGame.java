package Week6;
import java.util.Random;

public class MazeGame 
{
    public static final int MAZE_SIZE = 10;    
    public static final int OBST_AMT = (MAZE_SIZE*MAZE_SIZE)/10;
    private char[][] maze; // index 0 is the y, index 1 = x
    public static final char EMPTY = '_';
    public static final char OBST = 'X';
    public static final char PLAYER = 'O';
    public static final char PATH = '#';

    public static final String NORTH = "Go North";
    public static final String SOUTH = "Go South";
    public static final String EAST = "Go East";
    public static final String WEST = "Go West";
    public static final String BACK = "Go Back";


    private StackI<int[]> locations;
    private int[] currLoc;// index 0 is the y, index 1 = x

    public MazeGame()
    {
        this.init();
    }
    private void init()
    {
        maze = new char[MAZE_SIZE][MAZE_SIZE];
        for(int i=0; i<maze.length;i++)
            for (int j =0; j<maze[i].length;j++)
                maze[i][j] = EMPTY;
        this.addObstacles();

        maze[0][0] = PLAYER;
        currLoc = new int[] {0,0};
        locations = new LLStack<int[]>();
    }
    private void addObstacles()
    {
        Random r = new Random();
        for(int i = 0; i<OBST_AMT;i++)
        {
            int x = r.nextInt(MAZE_SIZE);
            int y = r.nextInt(MAZE_SIZE);
            if (maze[y][x] != EMPTY || (x==0 && y==0))
                continue;
            maze[y][x] = OBST;
        }
    }
    public void printMoveOptions()
    {
        int currY = currLoc[0];
        int currX = currLoc[1];
        int[] prevLoc = locations.peek();
        //North
        if(isValid(currY-1)&& maze[currY-1][currX] != OBST)
        {
            if(prevLoc != null && currY-1 == prevLoc[0] && currX == prevLoc[1])
                System.out.println(BACK);
            else
                System.out.println(NORTH);
        }
        if(isValid(currY+1)&& maze[currY+1][currX] != OBST)
        {
            if(prevLoc != null && currY+1 == prevLoc[0] && currX == prevLoc[1])
                System.out.println(BACK);
            else
                System.out.println(SOUTH);
        }
        if(isValid(currX-1)&& maze[currY][currX-1] != OBST)
        {
            if(prevLoc != null && currY == prevLoc[0] && currX-1 == prevLoc[1])
                System.out.println(BACK);
            else
                System.out.println(WEST);
        }
        if(isValid(currX+1)&& maze[currY][currX+1] != OBST)
        {
            if(prevLoc != null && currY == prevLoc[0] && currX+1 == prevLoc[1])
                System.out.println(BACK);
            else
                System.out.println(EAST);
        }

    }

    public void move(String input)
    {
       maze[currLoc[0]] [currLoc[1]] = EMPTY;
       int currY = currLoc[0];
       int currX = currLoc[1];
       int[] copyLoc = {currLoc[0],currLoc[1]};
       if(input.equalsIgnoreCase(NORTH))
        {
                if(isValid(currY-1) && maze[currY-1][currX]!=OBST)
                {
                    locations.push(copyLoc);
                    currLoc[0]--;
                }
                else
                {
                    System.out.println("Invalid Move.");
                }
        }
       else if(input.equalsIgnoreCase(SOUTH))
        {
                if(isValid(currY+1) && maze[currY+1][currX]!=OBST)
                {
                    locations.push(copyLoc);
                    currLoc[0]++;
                }
                else
                {
                    System.out.println("Invalid Move.");
                }
        }
       else if(input.equalsIgnoreCase(WEST))
       {
            if(isValid(currX-1) && maze[currY][currX-1]!=OBST)
            {
                locations.push(copyLoc);
                currLoc[1]--;
            }
            else
            {
                System.out.println("Invalid Move.");
            }
       }
       else if(input.equalsIgnoreCase(EAST))
       {
            if(isValid(currX+1) && maze[currY][currX+1]!=OBST)
            {
                locations.push(copyLoc);
                currLoc[1]++;
            }
            else
            {
                System.out.println("Invalid Move.");
            }
       }
       else if (input.equalsIgnoreCase(BACK))
       {
            if(locations.peek() != null)
            {
                int[] prevLoc = locations.pop();
                currLoc[0] = prevLoc[0];
                currLoc[1] = prevLoc[1];
            }
            else
            {
                System.out.println("Invalid move");
            }
       }
       else
       {
            System.out.println("Invalid move");
       }
       maze[currLoc[0]][currLoc[1]] = PLAYER;
    }

    private boolean isValid(int index)
    {
        return index >= 0 && index < maze.length;
    }
    public boolean getWin()
    {
        return currLoc[0]==maze.length-1 && currLoc[1]==maze.length-1;
    }
    public void reset()
    {
        this.init();
    }
    public void printFullMaze()
    {
        for(int i = 0;i<maze.length;i++)
        {
            for (int j = 0; j<maze.length;j++)
            {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
    public void printFullMazeWithPath()
    {
        while (locations.peek()!= null)
        {
            int[] temp = locations.pop();
            maze[temp[0]][temp[1]] = PATH;
        }
        this.printFullMaze();
    }
}
