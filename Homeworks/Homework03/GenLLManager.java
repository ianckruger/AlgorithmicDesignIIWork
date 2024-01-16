package Homeworks.Homework03;
/*
 * Written by Ian Kruger, CSCE146
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import Homeworks.Homework02.Game;

public class GenLLManager 
{
    public static final String DELIM = "[\t\n]"; //uses both \n and \t as delimiters
    public static final int BODY_FIELD_AMOUNT = 2;
    private GenLL[] organizedTasks;
    Scanner keyboard = new Scanner(System.in);


    public GenLLManager() // initializes array of linked lists instead of a linked list
    {
        organizedTasks = new GenLL[5];
        for(int i=0;i<organizedTasks.length;i++)
        {
            organizedTasks[i] = new GenLL();
        }   
    }

    public void fileReader(String inputFile) // reads the file inputted from the user and converts it into various arrays of linked lists
    {
        try
        {
            Scanner fileScanner = new Scanner(new File(inputFile)); 
            for(int i=0;i<organizedTasks.length;i++)
            {
                organizedTasks[i].reset(); // gets rid of any data in linked list array
            }
            while(fileScanner.hasNextLine())
            {
                String fileLine = fileScanner.nextLine();
                String[] splitLine = fileLine.split(DELIM);
                if (splitLine.length == 2)
                {
                    String name = splitLine[1];
                    int priority = Integer.parseInt(splitLine[0]);
                    Task aTask = new Task(name, priority);
                    organizedTasks[priority].add(aTask);
                }
                
            }
        fileScanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addToTasks() // allows the user to manually add indidivual tasks to the array of linked lists
    {
        System.out.println("Please input the name of your task: ");
        String name = keyboard.nextLine();
        System.out.println("Please input the priority of your task (0-4, with 0 being the most important)");
        int priority = keyboard.nextInt();
        keyboard.nextLine();

        Task aTask = new Task(name, priority);
        if(!organizedTasks[priority].contains(aTask)) //checks if the task is already in the LL
        {
            organizedTasks[priority].add(aTask);
        }
        else
            System.out.println("Task not added. List already contains task "+ name+ "of priority "+ priority);
    }

    public void removeTask() //allows the user to remove any task from the LL
    {
        System.out.println("Please input the name of the task you want to remove: ");
        String name = keyboard.nextLine();
        System.out.println("Please input the priority of the task you want to remove (0-4, with 0 being the most important)");
        int priority = keyboard.nextInt();

        Task aTask = new Task(name, priority);
        boolean removed = organizedTasks[priority].remove(aTask); // returns a boolean determining if anything was removed or not
        if(!removed)
            System.out.println("Task not found. Nothing removed."); // if nothing is removed inform user
        else
            System.out.println("Successfully removed task.");
    }

    public void printLists() // iterates through each LL in the array to print object
    {
        System.out.println("Printing Lists...\n");
        for (int i =0; i<organizedTasks.length;i++)
        {
            organizedTasks[i].print();
            System.out.println("\n");
        }
        System.out.println("Finished Printing.");
    }

    public void fileWriter(String fileName) // writes to a file based on the information in the searched linked list.
    {
        try
        {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
            for (int i =0; i<organizedTasks.length;i++)
                {
                    organizedTasks[i].goToHead();
                    while(organizedTasks[i].hasMore())
                    {
                        Task currTask = organizedTasks[i].getCurrent();
                        fileWriter.println(currTask.getPriority()+"\t"+currTask.getName()+"\n");
                        organizedTasks[i].goToNext();
                    }
                }
            fileWriter.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
