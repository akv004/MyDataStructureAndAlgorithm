package my.search;

public class BinarySearchTest {

	// Returns index of x if it is present in arr[l..r], else
    // return -1
    static int binarySearch(int arr[], int i, int r, int x)
    {
        if (r>=i)
        {
            int mid = i + (r - i)/2;
 
            // If the element is present at the middle itself
            if (arr[mid] == x)
               return mid;
 
            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, i, mid-1, x);
 
            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid+1, r, x);
        }
 
        // We reach here when element is not present in array
        return -1;
    }
    
 // Returns index of x if it is present in arr[], else
    // return -1
    static int binarySearchIterative(int arr[], int x)
    {
        int s = 0, r = arr.length - 1;
        while (s <= r)
        {
            int m = s+ (r-s)/2;
 
            // Check if x is present at mid
            if (arr[m] == x)
                return m;
 
            // If x greater, ignore left half
            if (arr[m] < x)
                s = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        // if we reach here, then element was not present
        return -1;
    }
	
	public static void main(String args[]){
		
		int [] arr = {1, 4, 6, 8, 9,11,34}; // 
		System.out.println(binarySearch(arr, 1, 7,11));
	}

}
