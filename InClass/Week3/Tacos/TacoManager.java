package Tacos;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class TacoManager 
{
    private Taco[] tacos;
    public static final int DEF_SIZE = 10;  
    public static final String DELIM = "\t";
    public static final int BODY_FIELD_AMT = 3;
    public static final int HEADER_FIELD_AMT = 2;


    public TacoManager()
    {
        init(DEF_SIZE);
    }
    public TacoManager(int size)
    {
        init(size);
    }
    public void init(int size)
    {
        if(size >= 1)
            tacos = new Taco[size];

        else
            tacos = new Taco[DEF_SIZE];
    }
    public void addTaco(Taco aTaco)
    {
        if(tacos[tacos.length-1] != null)
        {
            return;
        }
        for(int i=0; i<tacos.length;i++)
        {
            if(tacos[i] == null)
            {
                tacos[i] = aTaco;
                break;
            }
        }
        //TODO sort
    }
    public void removeTaco(String aName)
    {
        int removeIndex = -1;
        for(int i=0;i<tacos.length;i++)
        {
            if(tacos[i] != null && tacos[i].getName().equals(aName))
            {
                removeIndex = i;
                break;
            }
        }
        if(removeIndex == -1)
            return;
        else
        {
            for(int i=removeIndex; i<tacos.length-1; i++)
                tacos[i] = tacos[i+1];
            tacos[tacos.length-1] = null;
            
        }
    }
    private void sortTacos()
    {
        //bubble sort
        boolean swapped = true;
        while(swapped == true)
        {
            swapped = false;
            for(int i=0;i<tacos.length-1;i++)
            {
                if(tacos[i+1]==null)
                {
                    break;
                }
                if(tacos[i].getPrice()>tacos[i+1].getPrice())
                {
                    Taco temp = tacos[i];
                    tacos[i] = tacos[i+1];
                    tacos[i+1] = temp;
                    swapped = true;
                }
            }
        }
    }
    public void writeTacoFile(String aName)
    {
        try
        {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));

            fileWriter.println("Taco Amt: "+DELIM+tacos.length);
            
            // for each loop
            for(Taco taco:tacos)
            {
                if(taco ==null)
                {
                    break;
                }
                fileWriter.println(taco.getName()+DELIM+taco.getLocation()+DELIM+taco.getPrice());
            }
            fileWriter.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void readTacoFile(String aName)
    {
        try
        {
            Scanner fileScanner = new Scanner(new File(aName));
            String fileLine = fileScanner.nextLine();
            String[] splitLines = fileLine.split(DELIM);
            if(splitLines.length == HEADER_FIELD_AMT)
            {
                int size = Integer.parseInt(splitLines[1]);
                init(size);
            }
            else
                return;
            
            while(fileScanner.hasNextLine())
            {
                fileLine = fileScanner.nextLine();
                splitLines = fileLine.split(DELIM);
                if(splitLines.length == BODY_FIELD_AMT)
                {
                    String name = splitLines[0];
                    String location = splitLines[1];
                    double price = Double.parseDouble(splitLines[2]);
                    Taco aTaco = new Taco(name,location,price);
                    this.addTaco(aTaco);
                }
            }
            fileScanner.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void printTacos()
    {
        for(Taco taco : tacos)
        {
            if(taco == null)
            {
                break;
            }
            System.out.println(taco);
        }
    }
}
