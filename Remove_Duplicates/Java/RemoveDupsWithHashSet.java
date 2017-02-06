import java.util.Arrays;
import java.util.Random;
import java.util.HashSet;

public class RemoveDupsWithHashSet
{
    public static int[] removeDuplicates(int[] in)
    {
        // Create HashSet
        HashSet<Integer> hset = new HashSet<Integer>();

        // Add each element in the hset
        for(int i = 0; i < in.length; ++i)
            hset.add(in[i]);

        // Create array with hset length
        int[] out = new int[hset.size()];
        int k = 0;

        // Copy elements other than MIN_VALUE
        for(int i : hset)
            out[k++] = i;

        return out;
    }

    public static void run(int n)
    {
        int[] in = new int[n];

        Random r = new Random();
        for (int i = 0; i < in.length; ++i)
            in[i] =  r.nextInt(2 * n) + 1;

        //System.out.println(Arrays.toString(in));
        long start = System.currentTimeMillis();
        int[] out = removeDuplicates(in);
        long end = System.currentTimeMillis();
        //System.out.println(Arrays.toString(out));

        System.out.println("Array size - " + n + ", Time: " + (end - start) / 1000.0 + " Seconds"); 
    }

    public static void main(String[] args)
    {
        System.out.println("\n\n### Remove duplicates using Hash Set");
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
