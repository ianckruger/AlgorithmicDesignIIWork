package Homeworks.Homework03;
/*
 * Written by Ian Kruger, CSCE146
 */
public class Task 
{
    private String name;
    private int priority;

    public Task() // object of Task
    {
        this.name = "none";
        this.priority = 0;
    }

    public Task(String aName, int aPrior)
    {
        this.setName(aName);
        this.setPriority(aPrior);
    }

    public void setName(String aName)
    {
        if (aName != null)
            this.name = aName;

        else
            this.name = "none";
    }

    public void setPriority(int aPrior)
    {
        if (aPrior >= 0 && aPrior <5)
            this.priority = aPrior;

        else
            this.priority = 0;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getPriority()
    {
        return this.priority;
    }

    public String toString() // to string is formatted like the inputted text file
    {
        return priority+"\t"+name+"\n";
    }

    public boolean equalsThis(Task aTask) // checks if the given Task object has the same values as the current Task object to avoid checking references by accident
    {
        if(aTask.getName().equalsIgnoreCase(name) &&
            aTask.getPriority() == priority)
            {
                return true;
            }
        return false;
    }

    
}
