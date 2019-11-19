package sorting;

import java.util.Arrays;

/**
 * Whaddup Witit
 * @author johng
 */
public class Sorting {

    public static void main(String[] args) {
        int[] arr = {3, 420, 69, 65, 23, 1, 54, 20, 19, 45};
        Arrays.sort(arr);
        System.out.println("Sorted Array --> " + Arrays.toString(arr));
        System.out.println("Found 69 at index: " + binarySearch(arr, 69));
    }
    
    public static int binarySearch(int[] arr, int target) {
        int min = 0;
        int max = arr.length-1;
        while (min <= max) {
            int mid = (min+max)/2;
            if (arr[mid] < target) {
                min = mid + 1;
            } 
            else if (arr[mid] > target) {
                max = mid-1;
            }
            else return mid;
        }
        return min;
    }
    
}
