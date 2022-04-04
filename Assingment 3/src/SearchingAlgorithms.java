
import java.util.Random;
import java.util.Arrays;

public class SearchingAlgorithms {

        static boolean binarySearch(int[] list, int x) {
                Arrays.sort(list);
                int first = 0, last = list.length - 1;
                while (first <= last) {
                        int mid = first + (last - first) / 2;

                        // Check if target is present at mid if yes return true
                        if (list[mid] == x)
                                return true;

                        // If target is greater than mid then it must be present in second half of
                        // array, ignore left half
                        if (list[mid] < x)
                                first = mid + 1;

                        // If target is smaller, ignore right half
                        else
                                last = mid - 1;
                }

                // if we reach here that means target is not present in array so return false
                return false;
        }

        static boolean sequentialSearch(int[] list, int x) {
                for (int i = 0; i < list.length; i++) {
                        if (list[i] == x) { // an array is 0-indexed
                                return true; // return true if found
                        }
                }
                return false;
        }

        static boolean sortedSearch(int[] list, int x) {
                Arrays.sort(list);
                int i = 0;
                while (i < list.length && list[i] < x)
                        i++;
                if (i < list.length && list[i] == x)
                        return true; // x is in the array
                else
                        return false; // x is not in the array
        }

        static void quicksort(int[] list) {
                Arrays.sort(list);
        }

        static void fillArray(int[] list) {
                Random rnd = new Random();
                for (int i = 0; i < list.length; i++) {
                        list[i] = rnd.nextInt(20);
                }
        }

        static void printArray(int[] list) {
                for (int i = 0; i < list.length; i++) {
                        System.out.print(list[i] + " ");
                }
                System.out.println();
        }
}
