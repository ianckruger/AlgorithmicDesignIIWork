/*
 * Written by Ian Kruger
 */

public class ProcessScheduler 
{
    
    QueueI<Process> processes;
    Process currentProcess;
    
    public ProcessScheduler() //initialize the LLQueue so it actually works ... (i've forgetting this twice now)
    {
        processes = new LLQueue<Process>(); 
    }
    

    public Process getCurrentProcess()
    {
        return this.currentProcess;
    }

    public void addProcess(Process aProcess)
    {
        if (currentProcess == null)
            currentProcess = aProcess; // checks if there is no current process aka the list is empty before adding it to the list
        else
            processes.enqueue(aProcess);
    }

    public void runNextProcess()
    {
        currentProcess = processes.dequeue(); // dequeues the head of the LL to run the process
    }

    public void cancelCurrentProcess()
    {
        if (currentProcess != null)
        {
            processes.enqueue(currentProcess); // adds the current process back into the queue
            currentProcess = processes.dequeue(); // puts the next item in queue into the current process
        }
    }

    public void printProcessQueue()
    {
        processes.print();
    }

}
