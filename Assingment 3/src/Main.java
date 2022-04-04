
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

        public static void main(String[] args) {
                String outputFilename = "output.csv";
                PrintWriter output = null;

                // opening handle for csv file
                try {
                        output = new PrintWriter(new FileWriter(outputFilename));
                } catch (IOException ex) {
                        System.exit(1);
                }

                Random rnd = new Random();

                // search runs for 5000 times
                int n = 5000;
                for (int i = 1; i < n; i++) {

                        // creating search key value randomly using nextInt()
                        int key = rnd.nextInt();

                        // generating array of values randomly using nextInt()
                        int[] array = new int[i * 10];

                        SearchingAlgorithms.fillArray(array);

                        output.print(array.length + ",");

                        int sorted_list[] = new int[array.length];
                        System.arraycopy(array, 0, sorted_list, 0, array.length);

                        // calling binary search method
                        long startTime = System.nanoTime();
                        SearchingAlgorithms.binarySearch(sorted_list, key);
                        long endTime = System.nanoTime();
                        long durationInNano = (endTime - startTime);
                        // posting execution time into csv file
                        output.print(durationInNano + ",");

                        // calling sequential search method
                        startTime = System.nanoTime();
                        SearchingAlgorithms.sequentialSearch(array, key);
                        endTime = System.nanoTime();
                        durationInNano = (endTime - startTime);
                        // posting execution time into csv file
                        output.print(durationInNano + ",");

                        // calling sorted search method
                        startTime = System.nanoTime();
                        SearchingAlgorithms.sortedSearch(sorted_list, key);
                        endTime = System.nanoTime();
                        durationInNano = (endTime - startTime);

                        // posting execution time into csv file
                        output.print(durationInNano + ",");

                        output.println();
                        output.flush();

                }
        }
}