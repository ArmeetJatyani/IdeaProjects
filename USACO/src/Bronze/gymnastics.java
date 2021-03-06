/*
ID: xarmeetx
LANG: JAVA
TASK: gymnastics
*/

package Bronze;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class gymnastics
{
    public static int[][] matches;
    public static int consistentPairs;
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("C:\\Users\\Armeet Singh Jatyani\\Documents\\Development\\IdeaProjects\\USACO\\src\\Bronze\\gymnastics.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\Armeet Singh Jatyani\\Documents\\Development\\IdeaProjects\\USACO\\src\\Bronze\\gymnastics.out"))));

//        Scanner scanner = new Scanner(new File("gymnastics.in"));
//        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("gymnastics.out"))));

        //number of matches and cows playing
        int MATCHES = scanner.nextInt();
        int COWS = scanner.nextInt();

        //read all matches
        matches = new int[MATCHES][COWS];
        for (int i = 0; i < MATCHES; i++)
        {
            for (int j = 0; j < COWS; j++)
            {
                //read in
                matches[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < COWS; i++)
        {
            for (int j = 0; j < COWS; j++)
            {
                boolean isConsistentPair = true;
                for (int match = 1; match < matches.length; match++)
                {
                    if (!isInFront(match, matches[0][i], matches[0][j]))
                    {
                        isConsistentPair=false;
                        break;
                    }
                    //System.out.print("cow1: " + matches[match][i] + "   cow2: " + matches[match][j]);
                    //System.out.println();
                }
                if(isConsistentPair)
                {
                    consistentPairs++;
                }
            }
        }
        printWriter.println(consistentPairs);
        printWriter.close();

    }

    public static boolean isInFront(int match, int cow1, int cow2)
    {
        if (indexOf(matches[match], cow1) < indexOf(matches[match], cow2))
        {
            return true;
        }
        return false;
    }

    public static int indexOf(int[] array, int cow)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == cow)
            {
                //return index
                return i;
            }
        }

        //not found
        return -1;
    }
}
