import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        // Define the input array and the target value (key)
        int[] collection = {72, 12, 23, 5, 2, 16, 8, 91, 38, 56};
        int key = 23;

        // Sort the input array to make it suitable for binary search
        Arrays.sort(collection);

        // Perform the recursive binary search on the sorted array
        // Starting the search from the first index (0) to the last index (collection.length - 1)
        int index = recursiveBinarySearch(collection, key, 0, collection.length - 1);

        // Display the result to the user
        if (index != -1) {
            // If the target value is found, print its index
            System.out.println("The target value " + key + " is found at index: " + index);
        } else {
            // If the target value is not found, print a message indicating so
            System.out.println("The target value " + key + " is not present in the array.");
        }
    }

    /**
     * Implements the recursive binary search algorithm.
     *
     * @param collection The sorted array in which to search for the key.
     * @param key The target integer value to search for in the collection.
     * @param low The lower bound index of the current search range.
     * @param high The upper bound index of the current search range.
     * @return The index of the key if found; otherwise, returns -1.
     */
    public static int recursiveBinarySearch(int[] collection, int key, int low, int high) {
        // Base case: If the range is empty (low > high), the key is not found, so return -1
        if (low > high) {
            return -1;
        }

        // Calculate the middle index of the current search range
        int mid = low + (high - low) / 2;

        // Check if the middle element of the array is the target key
        if (collection[mid] == key) {
            // If the middle element matches the key, return the middle index
            return mid;
        }

        // If the middle element is greater than the target key,
        // search the left half of the array (low to mid - 1)
        if (collection[mid] > key) {
            return recursiveBinarySearch(collection, key, low, mid - 1);
        } else {
            // Otherwise, search the right half of the array (mid + 1 to high)
            return recursiveBinarySearch(collection, key, mid + 1, high);
        }
    }
}
