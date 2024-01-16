/*
 * Written by Ian Kruger, CSCE146
 */

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIOSolutions {
    //these will never change, so I declared them as constants
    public static final String DELIM = "\\s+"; // deliminates all white spaces, used for reading doc word by word
    public static final String DELIM1 = "\t"; // deliminates all tabs, used for specific cases where only \t seperations should be read
    public static final int BODY_FIELD_AMOUNT = 3; // used with DELIM1 to ensure that the line is formated correctly if its gonna be used
    public static final String REPLACER = "was"; 
    public static final String ORIGINAL = "is";

    public static void pastTense(String readFileName, String outputFileName )
    {
         try
        {
           
            Scanner fileScanner = new Scanner(new File(readFileName)); // reads the file
            FileWriter fileWriter = new FileWriter(outputFileName); // writes in the file
            while(fileScanner.hasNextLine()) 
            {
                String fileLine = fileScanner.nextLine();
            
                String[] splitLines = fileLine.split(DELIM);  // splits lines by any whitespaces


                for (String word : splitLines) // for each word in the split line
                {
                    if (word.equalsIgnoreCase(ORIGINAL)) // if this word  is "is" in any shape or form, 
                    {
                        word = REPLACER; // replace it with "was"
                    }
                    System.out.println(word + " "); // Prints out the word to the console
                    fileWriter.write(word + "\n"); // writes in the file the word with the ended space after
                }
                // to make things clearer
                System.out.println(); //goes to next line
                fileWriter.write("\n"); // goes to next line 
            }
            fileScanner.close();
            fileWriter.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /* for writing purposes
    public void writeTacoFile(String aName)
    {
        try
        {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
                fileWriter.println(aTaco.getName()+DELIM+aTaco.getLocation()+DELIM+aTaco.getPrice());
            fileWriter.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
*/

    public static double totalTubeVolume(String readTubeFile)
    {
        double total = 0.0; // total volume, cant be constant because it will change
        try
        {
           
            Scanner fileScanner = new Scanner(new File(readTubeFile));
            while(fileScanner.hasNextLine()) 
            {
                String fileLine = fileScanner.nextLine();
                String[] splitLines = fileLine.split(DELIM1); // splits line by any sort of \t
                if (splitLines.length == BODY_FIELD_AMOUNT) // if the line was formatted correctly, aka meant to be used,
                {
                    double height = Double.parseDouble(splitLines[2]); // get height
                    double radius = Double.parseDouble(splitLines[1]);//get radius
                    double tempVolume = Math.pow(radius, 2) * height * Math.PI; // caclulate volume
                    total += tempVolume; // add the volume to the total volume
                }
            }
            fileScanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return total;
    }

}
