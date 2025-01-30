public class BinarySearchRotatedArray {
    
    public int search(int[] arr, int target, int rotationIndex){
        int n = arr.length;
        
        // If the rotation index is 0, the array is not rotated → Perform normal binary search
        if (rotationIndex == 0) {
            return binarySearch(arr, 0, n - 1, target);
        }

        // If target is in the left sorted portion (0 to rotationIndex-1)
        if (target >= arr[0] && target <= arr[rotationIndex - 1]) {
            return binarySearch(arr, 0, rotationIndex - 1, target);
        }

        // Otherwise, search in the right sorted portion (rotationIndex to n-1)
        return binarySearch(arr, rotationIndex, n - 1, target);
    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } 
            else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } 
            else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        BinarySearchRotatedArray searcher = new BinarySearchRotatedArray();
        
        int[] arr = {4, 5, 6, 7, 1, 2, 3}; // Rotated at index 4
        int rotationIndex = 4;
        
        System.out.println(searcher.search(arr, 6, rotationIndex)); // Output: 2
        System.out.println(searcher.search(arr, 1, rotationIndex)); // Output: 4
        System.out.println(searcher.search(arr, 9, rotationIndex)); // Output: -1 (not found)

       
    }
}
