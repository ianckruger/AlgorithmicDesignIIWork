package Labs.CSCE146Lab1;
/*
 * Written by Ian Kruger; CSCE 146
 */
public class WordHelper {
    


    // COUNTING THE VOWELS AND SORTING THEM

    public static String[] sortByVowels(String[] array)
	{
        System.out.println("Starting vowel search");
        String[] temp = new String[array.length]; //empty String array that is same length as the input array

        for (int i=0;i<array.length;i++) // used to create copy of array
        {
            temp[i] = array[i];
            //System.out.println(temp[i]); Was used for debugging
        }

        System.out.println("Starting vowel bubble swap"); // Used for debugging

        boolean hasSwapped = true;
        while(hasSwapped)
        {
            hasSwapped = false;
            for(int i=0;i<temp.length-1;i++)
            {
                int vowel1 = vowelCount(temp[i]);
                int vowel2 = vowelCount(temp[i+1]);
                if(vowel1> vowel2) // swaps the position of the words if the vowel count is more than the one in front of it ( vowel 2 is an index ahead of vowel 1)
                {
                    String tempword = temp[i]; 
                    temp[i] = temp[i + 1];
                    temp[i + 1] = tempword; // Fixed the swap here
                    hasSwapped = true;
                }
            }
        }
        
        return temp;
        
	}

    public static int vowelCount(String word) // method used to compare values. Was within the original code at first, but decided it was easier as a seperate method
    {
        int vowelCount = 0; // counts the vowels
        String lowercaseWord = word.toLowerCase(); // accounting for uppercase letters
        for (int i = 0; i<word.length();i++) // iterates through the string
            {
                char c = lowercaseWord.charAt(i);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c =='y') // if the character is _ or _ or _... etc vowel, increase the count
                {
                    vowelCount ++;
                }
            }  
        return vowelCount;
    }



// COUNTING THE CONSONANTS AND SORTING THEM

// COUNTING

    public static int consonantCount(String word) // method used to compare values. Was within the original code at first, but decided it was easier as a seperate method
    {
        int conCount = 0;
        String lowercaseWord = word.toLowerCase(); // accounting for uppercase letters
        for (int i = 0; i<word.length();i++) // iterates through the string
            {
                char c = lowercaseWord.charAt(i);
                if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c !='y') // To increase count, the character has to NOT be ALL of these vowels
                {
                    conCount ++;
                }
            }  
        return conCount;
    }

    // SORTING CONSONANTS

    public static String[] sortByConsonants(String[] array)
    {
        System.out.println("Starting consonant search");
        String[] temp = new String[array.length]; 

        for (int i=0;i<array.length;i++) // used to create copy of array
        {
            temp[i] = array[i];
            //System.out.println(temp[i]); Was used for debugging
        }

        System.out.println("Starting cons bubble swap"); // Used for debugging

        boolean hasSwapped = true;
        while(hasSwapped)
        {
            hasSwapped = false;
            for(int i=0;i<temp.length-1;i++)
            {
                int cons1 = consonantCount(temp[i]);
                int cons2 = consonantCount(temp[i+1]);
                if(cons1> cons2)
                {
                    String tempword = temp[i];
                    temp[i] = temp[i + 1];
                    temp[i + 1] = tempword; // Fixed the swap here
                    hasSwapped = true;
                }
            }
        }
        
        return temp;
    }



    // FINDING THE LENGTH AND SORTING THEM


    public static int lengthCount(String word) // method used to iterate through a word and count the number of letters
    {
        int length = 0;
        for (int i = 0; i<word.length();i++) // iterates through the string
            {
                length ++;
            }  
        return length;
    }

    public static String[] sortByLength(String[] array) 
    {
        System.out.println("Starting length count");
        String[] temp = new String[array.length]; 

        for (int i=0;i<array.length;i++) // used to create copy of array
        {
            temp[i] = array[i];
            //System.out.println(temp[i]); Was used for debugging
        }

        System.out.println("Starting length bubble swap"); // Used for debugging

        boolean hasSwapped = true;
        while(hasSwapped)
        {
            hasSwapped = false;
            for(int i=0;i<temp.length-1;i++)
            {
                int cons1 = lengthCount(temp[i]);
                int cons2 = lengthCount(temp[i+1]);
                if(cons1> cons2)
                {
                    String tempword = temp[i];
                    temp[i] = temp[i + 1];
                    temp[i + 1] = tempword; // Fixed the swap here
                    hasSwapped = true;
                }
            }
        }
        
        return temp;
    }

}
