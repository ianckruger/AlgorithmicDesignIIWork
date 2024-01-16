package Week4.Taco2;
import java.util.Scanner;
import java.io.*;


public class TacoManager
{

    public static final String DELIM = "\t";
    public static final int BODY_FIELD_AMT = 3;
    private GenLL2<Taco> tacos;

    public TacoManager()
    {
        tacos = new GenLL2<Taco>();
    }

    public void addTaco(Taco aTaco)
    {
        tacos.add(aTaco);
        this.sortTacos();
    }

    public void removeTaco(String aName)
    {
        tacos.reset();//sets current to head
        while(tacos.hasMore())
        {
            if(tacos.getCurrent().getName().equalsIgnoreCase(aName))
            {
                tacos.removeCurrent();
                break;
            }
            tacos.goToNext();
        }
    }

    private void sortTacos()
    {
        boolean swapped = true;
        while(swapped)
        {
            swapped=false;
            for(int i=0;i<tacos.getSize();i++)
            {
                if(tacos.getAt(i+1) == null)
                    break;
                if(tacos.getAt(i).getPrice() > tacos.getAt(i+1).getPrice())
                {
                    Taco temp = tacos.getAt(i);
                    tacos.setAt(i, tacos.getAt(i+1));
                    tacos.setAt(i+1,temp);
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
            tacos.reset();
            while(tacos.hasMore())
            {
                Taco aTaco = tacos.getCurrent();
                fileWriter.println(aTaco.getName()+DELIM+aTaco.getLocation()+DELIM+aTaco.getPrice());
                tacos.goToNext();
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
            while(fileScanner.hasNextLine());
            {
                String fileLine = fileScanner.nextLine();
                String[] splitLines = fileLine.split(DELIM);
                if(splitLines.length== BODY_FIELD_AMT)
                {
                    String name = splitLines[0];
                    String loc = splitLines[1];
                    double price = Double.parseDouble(splitLines[2]);
                    Taco aTaco = new Taco(name, loc, price);
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
        tacos.print();
    }

}

