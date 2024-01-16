/*
 * Written by Ian Kruger
 */
public class Process 
{
    private String name;
    private double completeionTime;

    public Process(String aName, double aTime)
    {
        this.setName(aName);
        this.setCompletionTime(aTime);
    }

    public Process() // second initializer if the user does not input anything
    {
        this.init();
    }
    
    private void init()
    {
        this.name = "none";
        this.completeionTime = 0.0;
    }

    public String getName() //accessor
    {
        return this.name;
    }

    public double getCompletionTime() //accessor
    {
        return this.completeionTime;
    }

    public void setName(String aName) //mutator
    {
        if(aName==null)
            return;
        this.name = aName;
    }

    public void setCompletionTime(double aTime) //mutator
    {
        if(aTime < 0)
            return;
        this.completeionTime = aTime;
    }

    public String toString()
    {
        return "Process Name: "+ this.name+"/tCompletion Time: "+this.completeionTime;
    }
    
}
