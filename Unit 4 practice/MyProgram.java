public class MyProgram 
{
    public static void main(String[] args) 
    {
        // use the main method to test your code
        int[] arr1 = {1, 4, 2, 5, -4};
        int[] arr2 = {-5, 5, 3, 7, 8};
        System.out.println(isAlternating(arr1));
        System.out.println(isAlternating(arr2));
        String[] sentences = {"How are you?", "You're doing great!", "That's not yours!"};
        String word = "you";
        String[] returnedArr = sentencesContainingWord(sentences, word);
        for(int i = 0; i < returnedArr.length; i++)
        {
            System.out.print(returnedArr[i] + " ");
        }
        System.out.println("");
        int[] slopes = {1, 2, 3, 4};
        int[] yInt = {1, 2, 3, 4};
        Line[] newArr = populateLinesArray(slopes, yInt);
        for(int i = 0; i < newArr.length; i++)
        {
            System.out.print(newArr[i] + " ");
        }
        System.out.println("");
    }
    
    /*
     *  Returns true if arr is alternating, false otherwise.
     *
     *  An array is alternating if every element except for the first and last
     *  is either greater than both elements it's next to, or less than both 
     *  elements it's next to.
     *
     *  Examples:
     *    [1, 4, 2, 5, -4] --> true
     *    [-5, 5, 3, 7, 8] --> false, 7 < 8 and 7 > 3
     */
    public static boolean isAlternating(int[] arr) 
    {
        for(int i = 0; i < arr.length - 2; i++)
        {
            if(!(arr[i] < arr[i+1] && arr[i+1] > arr[i+2]) && !(arr[i] > arr[i+1] && arr[i+1] < arr[i+2]))
            {
                return false;  
            }
        }
        return true;
    }
    
    /*
     *  Returns an array of Strings that contains every String in sentences that
     *  contains the given word as a substring.
     *
     *  Examples:
     *      ["How are you?", "You're doing great!", "That's not yours!"], "you"
     *      would return
     *      ["How are you?", "That's not yours!"]
     *      Note that "you" is a substring of "That's not yours!" but is not a
     *      standalone word. Also note that "You're doing great!" is not included
     *      because of the capital y.
     */
    public static String[] sentencesContainingWord(String[] sentences, String word) 
    {
        int length = word.length();
        int count = 0;
        String[] wordCount = new String[sentences.length];
        for(int i = 0; i < sentences.length; i++)
        {
            for(int j = 0; j < (sentences[i].length() - word.length() + 1); j++)
            {
                if(sentences[i].substring(j, j+length).indexOf(word) != -1)
                {
                    wordCount[count] = sentences[i];
                    count++;
                }
            }
        }
        String[] words = new String[count];
        int count2 = 0;
        for(int r = 0; r < wordCount.length; r++)
        {
           if(wordCount[r] != null)
           {
               words[count2] = wordCount[r];
               count2++;
           }
        }
        return words;
    }
    
    /*
     *  Returns an array of Lines with the given slopes and y_intercepts.
     *
     *  Precondition: slopes.length == y_intercepts.length
     *  The Line constructor takes two int parameters: a slope
     *  and a y-intercept value IN THAT ORDER.
     */
    public static Line[] populateLinesArray(int[] slopes, int[] y_intercepts) 
    {
        Line newArr[] = new Line[slopes.length];
        for(int i = 0; i < slopes.length; i++)
        {
            Line newLine = new Line(slopes[i],y_intercepts[i]);
            newArr[i] = newLine;
        }
        return newArr;    
    }
    
    /*
     *  Returns the average y-coordinate of the given lines with the given
     *  x-coordinate.
     *
     *  The Line class contains method getY() which should be used
     *  for this method.
     *
     *  Examples:
     *      3, [y = 3x + 2, y = 5x + 1, y = x - 9]
     *      returns
     *      7.0 since ((3(3) + 2) + (5(3) + 1) + (3 - 9)) / 3 = 7
     */
    public static double averageYCoordinate(int x, Line[] lines) 
    {
        double average = 0;
        for(int i = 0; i < lines.length; i++)
        {
            average += lines[i].getY(x);
        }
        return average / lines.length;
    }
}