package Homeworks.Homework06;

import java.io.File;
import java.util.Scanner;

public class BSTManager 
{
    public static final String DELIM = "\t";
    public static final String CIRCLE = "Circle";
    public static final String RECT = "Rectangle";
    public static final String TRI = "Right Triangle";
    private LinkedBST<Shape> tree;
    public Scanner keyboard = new Scanner(System.in); 

    public BSTManager()
    {
        this.init();
    }

    public void init()
    {
        tree =  new LinkedBST<Shape>();
    }


    public void fileReader(String inputFile) // reads the file inputted from the user and converts it into various arrays of linked lists
    {
        try
        {
            Scanner fileScanner = new Scanner(new File(inputFile)); 
            while(fileScanner.hasNextLine())
            {
                String fileLine = fileScanner.nextLine();
                String[] splitLine = fileLine.split(DELIM);
                if(splitLine[0].equalsIgnoreCase(CIRCLE))
                {
                    double radius = Double.parseDouble(splitLine[1]);
                    Shape circle = new Shape(CIRCLE,0.0,0.0,0.0,0.0,radius);
                    tree.add(circle);
                }
                else if(splitLine[0].equalsIgnoreCase(RECT))
                {
                    double length = Double.parseDouble(splitLine[1]);
                    double width = Double.parseDouble(splitLine[2]);
                    Shape rectangle = new Shape(RECT,length, width, 0, 0,0);
                    tree.add(rectangle);
                }
                else if(splitLine[0].equalsIgnoreCase(TRI))
                {
                    double base = Double.parseDouble(splitLine[1]);
                    double height = Double.parseDouble(splitLine[2]);
                    Shape rightTriangle = new Shape(TRI,0,0,base,height,0);
                    tree.add(rightTriangle);
                }
                else
                    continue;
            }
        fileScanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addShape()
    {
        System.out.println("Please enter the shape you want to add: ");
        keyboard.nextLine();
        String type = keyboard.nextLine();
        if(type.equalsIgnoreCase(CIRCLE))
        {
            System.out.println("Please enter the radius: ");
            double radius = keyboard.nextDouble();
            Shape data = new Shape(type, 0,0,0,0,radius);
            tree.add(data);
        }
        else if(type.equalsIgnoreCase(RECT))
        {
            System.out.println("Please enter the width: ");
            double width = keyboard.nextDouble();
            System.out.println("Please enter the length: ");
            double length = keyboard.nextDouble();
            Shape data = new Shape(type,length, width,0,0,0);
            tree.add(data);
        }
        else if(type.equalsIgnoreCase(TRI))
        {
            System.out.println("Please enter the base: ");
            double base = keyboard.nextDouble();
            System.out.println("Please enter the height: ");
            double height = keyboard.nextDouble();
            Shape data = new Shape(type,0, 0,base,height,0);
            tree.add(data);
        }
    }

    public void remove()
    {
        System.out.println("Please enter the shape you want to remove: ");
        keyboard.nextLine();
        String type = keyboard.nextLine();
        if(type.equalsIgnoreCase(CIRCLE))
        {
            System.out.println("Please enter the radius: ");
            double radius = keyboard.nextDouble();
            Shape data = new Shape(type, 0,0,0,0,radius);
            tree.remove(data, type);
        }
        else if(type.equalsIgnoreCase(RECT))
        {
            System.out.println("Please enter the width: ");
            double width = keyboard.nextDouble();
            System.out.println("Please enter the length: ");
            double length = keyboard.nextDouble();
            Shape data = new Shape(type,length, width,0,0,0);
            tree.remove(data, type);
        }
        else if(type.equalsIgnoreCase(TRI))
        {
            System.out.println("Please enter the base: ");
            double base = keyboard.nextDouble();
            System.out.println("Please enter the height: ");
            double height = keyboard.nextDouble();
            Shape data = new Shape(type,0, 0,base,height,0);
            tree.remove(data, type);
        }
    }

    public boolean search()
    {
        System.out.println("Please enter the shape you want to search for: ");
        keyboard.nextLine();
        String type = keyboard.nextLine();
        if(type.equalsIgnoreCase(CIRCLE))
        {
            System.out.println("Please enter the radius: ");
            double radius = keyboard.nextDouble();
            Shape data = new Shape(type, 0,0,0,0,radius);
            return tree.search(data, type);
        }
        else if(type.equalsIgnoreCase(RECT))
        {
            System.out.println("Please enter the width: ");
            double width = keyboard.nextDouble();
            System.out.println("Please enter the length: ");
            double length = keyboard.nextDouble();
            Shape data = new Shape(type,length, width,0,0,0);
            return tree.search(data, type);
        }
        else if(type.equalsIgnoreCase(TRI))
        {
            System.out.println("Please enter the base: ");
            double base = keyboard.nextDouble();
            System.out.println("Please enter the height: ");
            double height = keyboard.nextDouble();
            Shape data = new Shape(type,0, 0,base,height,0);
            return tree.search(data, type);
        }
        else
            return false;
    }

    public void print()
    {
        System.out.println("Which traversal?\nEnter 1. For Pre-order.\nEnter 2. For In-order\nEnter 3. For Post-order");
        int choice = keyboard.nextInt();
        if(choice ==1)
            tree.printPreorder();
        else if(choice ==2)
            tree.printInOrder();
        else if(choice==3)
            tree.printPostOrder();
        else
            System.out.println("Did not enter 1,2, or 3");
    }

    public void removeGreaterThanArea()
    {
        System.out.println("Please enter the area: ");
        double area = keyboard.nextDouble();
        tree.removeGreaterThanArea(area);
    }

    public void printToFile() 
    {
        System.out.println("Please enter a file name to write to: ");
        String fileName = keyboard.nextLine();
        tree.printToFileWriter(fileName);
    }

    


    
}
