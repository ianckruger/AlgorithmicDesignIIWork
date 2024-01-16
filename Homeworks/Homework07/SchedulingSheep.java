package Homeworks.Homework07;

import java.io.File;
import java.util.Scanner;

public class SchedulingSheep 
{
    public static final String DELIM = "\t";
    MinHeap<Sheep> heap;
    Sheep currentSheep;
    int currentMinute;
    int shearTimeLeft;
    Sheep[] placeHolder;
    MinArrivalHeap<Sheep> arrivalHeap;

    public SchedulingSheep()
    {
        this.init();
    }

    public void init()
    {
        heap =  new MinHeap<Sheep>();
        arrivalHeap = new MinArrivalHeap<Sheep>();
        currentSheep = null;
        currentMinute = 0;
        shearTimeLeft = 0;
    }

    public void fileReader(String fileName)
    {
        try
        { 
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine())
            {
                String fileLine = fileScanner.nextLine();
                String[] fileLines = fileLine.split(DELIM);
                String name = fileLines[0];
                int arrival = Integer.parseInt(fileLines[2]);
                int shear = Integer.parseInt(fileLines[1]);
                Sheep temp = new Sheep(name, arrival, shear);
                if(temp.getArrivalTime()==0)
                {
                    addSheep(temp);
                }
                else
                    arrivalHeap.add(temp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } 
    }

    public void addSheep(Sheep aSheep)
    {
        if(currentSheep==null)
        {
            currentSheep = aSheep;
            shearTimeLeft = aSheep.getShearingTime();
        }   
        else
            heap.add(aSheep);
    }

    public void advanceOneMinute()
    //This method adds one to the current minute counter, and then shears the current sheep for one minute. 
    //If the sheep is now sheared, print the information and replace the current sheep with the order on 
    //top of the shearing time sorted heap.
    {
        if(noMoreSheep())
            return;
        currentMinute += 1;
        shearTimeLeft -= 1;
  
        //issue here
        if(currentMinute==arrivalHeap.peekArrival())
        {
            while(currentMinute==arrivalHeap.peekArrival())
            {
                Sheep temp = arrivalHeap.remove();
                temp.setArrived(true);
                heap.add(temp);
            }
        }
        if(shearTimeLeft==0)
        {
                System.out.println(currentSheep.toString());
                Sheep temp = heap.remove();
                shearTimeLeft = temp.getShearingTime();
                currentSheep = temp;
        }
    }

    public boolean noMoreSheep()
    {
        if(currentSheep==null && heap.isEmpty()==null)
            return true;
        return false;
    }
}
