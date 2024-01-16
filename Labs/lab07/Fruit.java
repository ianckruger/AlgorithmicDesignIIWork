package Labs.lab07;
/*
 * Written by Ian Kruger, CSCE146
 */

public class Fruit 
{
    private String type;
    private double weight;

    public Fruit(String aName, double aWeight)
    {
        this.setType(aName);
        this.setWeight(aWeight);
    }

    public Fruit()
    {
        this.init();
    }

    private void init()
    {
        this.type = "none";
        this.weight = 1.0;
    }

    private void setType(String aType)
    {
        if(this.type == "none")
            return;
        this.type = aType;
        
    }

    private void setWeight(double aWeight)
    {
        if(this.weight == 1.0)
            return;
        this.weight = aWeight;
    }

    public String getType()
    {
        return this.type;
    }

    public double getWeight()
    {
        return this.weight;
    }

    public String toString()
    {
        return "Type: "+ this.type+"\tWeight: "+this.weight;
    }

    public int comparing(Fruit aFruit) 
    {
        if (aFruit == null)
            return -1;
        int ret = Double.compare(this.weight, aFruit.getWeight());
        if (ret != 0) 
            return ret;
        return this.type.compareTo(aFruit.getType());
    }
    
}
