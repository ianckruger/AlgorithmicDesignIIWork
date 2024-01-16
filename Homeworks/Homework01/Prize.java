package Homeworks.Homework01;
/*
 * Written by Ian Kruger, CSCE146
 */
public class Prize {
    
    private String name;
    private double price;
    private boolean inUse;

    public Prize()
    {
        this.name = "none";
        this.price = 0.0;
        this.inUse = false;
    }
    public Prize(String aName, double aPrice)
    {
        this.setName(aName);
        this.setPrice(aPrice);
    }
    public boolean getInUse()
    {
        return this.inUse;
    }
    public void setInUse(boolean status)
    {
        this.inUse = status;
    }
    public String getName()
    {
        return this.name;
    }
    public double getPrice()
    {
        return this.price;
    }
    public void setName(String aName)
    {
        if (aName != null)
            this.name = aName;
        
        else
            this.name = "none";
    }
    public void setPrice(double aPrice)
    {
        if (aPrice >= 0.0)
            this.price = aPrice;
        
        else
            this.price = 0.0;
    }
    public String toString()
    {
        return "Name: "+this.name+" Price: "+this.price;
    }
    public boolean equals(Prize aPrize)
    {
        return aPrize != null &&
            this.name.equalsIgnoreCase(aPrize.getName()) &&
            this.price == aPrize.getPrice();
    }
}
