package Homeworks.Homework07;



public class Sheep implements Comparable<Sheep>, ArrivalTimeProvider
{
    String name;
    int arrivalTime;
    int shearingTime;
    boolean arrived = false;
    
    public Sheep(String aName, int aArr, int aShear)
    {
        setName(aName);
        setArrivalTime(aArr);
        setShearingTime(aShear);
    }

    public void setName(String aName)
    {
        if(aName != null)
            this.name = aName;
    }

    public void setArrivalTime(int aArrTime)
    {
        if(aArrTime <=0)
            return;
        this.arrivalTime = aArrTime;
    }

    public void setShearingTime(int aShear)
    {
        if(aShear <= 0)
            return;
        this.shearingTime = aShear;
    }

    public int getShearingTime()
    {
        return shearingTime;
    }
    
    public String getName()
    {
        return name;
    }

    public int getArrivalTime()
    {
        return arrivalTime;
    }

    public void setArrived(boolean a)
    {
        arrived = a;
    }

    public boolean getArrived()
    {
        return arrived;
    }

    @Override
    public int compareTo(Sheep aSheep)
    {
        if(arrived== false)
        {
            int compare = Integer.compare(arrivalTime, aSheep.getArrivalTime());
            return compare;
        }
        else
        {
            int compare = Integer.compare(shearingTime, aSheep.getShearingTime());
            if(compare == 0)
                compare = name.compareTo(aSheep.getName());
            return compare;
        }
    }

    public String toString()
    {
        return "Name: "+name+" Shearing Time: "+shearingTime+" Arrival Time: "+arrivalTime;
    }

}
