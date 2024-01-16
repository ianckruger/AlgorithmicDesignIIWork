package Labs.Lab03;
/*
 * Written by Ian Kruger CSCE146
 */

public class GroceryItem { // this grocery item is used for the GroceryList code to provide functionality of a work grocery list with genuine items
    
    private String name;
    private double price;


    public GroceryItem()
    {
        this.name = "none";
        this.price = 0.0;
    }

    public GroceryItem(String aName, double aPrice) // the constructor of the actual item
    {
        this.setName(aName);
        this.setPrice(aPrice);
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
        if (aPrice >=0)
            this.price = aPrice;
        else
            this.price = 0.0;

    }
    public String getName()
    {
        return this.name;
    }

    public double getPrice()
    {
        return this.price;
    }

    public boolean equals(GroceryItem aItem) // simplified the code for comparing items into a seperate function that takes input of another item
    {
        return aItem != null &&
            this.name.equals(aItem.getName()) &&
            this.price == aItem.getPrice();
    }

    public String toString()
    {
        return "Name: "+this.name+" Price: "+this.price;
    }

}
