import java.util.Arrays;
import java.util.Random;

public class RemoveDupsWithArraySorting
{
    public static int[] removeDuplicates(int[] in)
    {
        // Sort the array
        Arrays.sort(in);
        int ndistict = 0, j;

        // Traverse through the array
        for(int i = 0; i < in.length; i = j) {
            // Get the next index
            j = i + 1;
            // Increment ndistict for distict element
            ++ndistict;

            // Compare current element with next element
            // If equal replace the value with MIN_VALUE
            while(j < in.length && in[i] == in[j]) {
                in[j] = Integer.MIN_VALUE;
                ++j;
            }
        }

        // Create array with ndistict size
        int[] out = new int[ndistict];
        int k = 0;

        // Copy elements other than MIN_VALUE
        for(int i = 0; i < in.length; ++i) {
            if(in[i] != Integer.MIN_VALUE)
                out[k++] = in[i];
        }
        return out;
    }

    public static void run(int n)
    {
        int[] in = new int[n];

        Random r = new Random();
        for (int i = 0; i < in.length; ++i)
            in[i] =  r.nextInt(2 * n) + 1;

        long start = System.currentTimeMillis();
        int[] out = removeDuplicates(in);
        long end = System.currentTimeMillis();

        System.out.println("Array size - " + n + ", Time: " + (end - start) / 1000.0 + " Seconds"); 
    }

    public static void main(String[] args)
    {
        System.out.println("\n\n### Remove duplicates using array sorting");
        // Test for 1 Lakh
        run(100000);

        // Test for 10 Lakh
        run(1000000);

        // Test for 1 Crore
        run(10000000);

        // Test for 10 Crore
        run(100000000);
        System.out.println("### Done\n\n");
    }
}
