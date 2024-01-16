package Labs.lab06;
/*
 * Written By Ian Kruger, CSCE 146
 */

public class searchAndSort // search and sort except i realized sorting is much easier within the LL class
{
    private static final char stop1 = 's';
    private static final char stop2 = 'o';
    private static final char stop3 = 'r';
    private static final char stop4 = 't';
    

    public static int linearSearchForSORT(String a) // searchs for the word sort by iterating lineraly through the list
    {
        if(a.length()<4)// return 0 if the word is less then the length of the word sort ( avoids null pointer exception)
            return 0;
        int counter = 0;
        for (int j = 0; j < a.length()-1; j++) // for each character in the string passed through
        {
            char c = a.charAt(j);
            if (Character.toLowerCase(c)==stop1) //if the character is S, check the following character to see if its O
            {
                c = a.charAt(j+1);
                if (Character.toLowerCase(c)==stop2) // if the next character is T, check the following character to see of ots R
                {
                    c = a.charAt(j+2);
                    if(Character.toLowerCase(c)==stop3)// if the next character is r, check the following character to see of ots t
                    {
                        c = a.charAt(j+3);
                        if(Character.toLowerCase(c)==stop4) // if it is T, then the word is sort, increase the counter and move forward
                            counter+=1;
                    }
                
                }
            }
        }

        return counter;
    }
}
