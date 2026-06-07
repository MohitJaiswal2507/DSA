public class Search_in_rotated_sorted_array1 {

    public static int SearchinArr(int[] arr , int target){

        int low = 0 , high = arr.length - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(arr[mid] == target) return mid;

            //Checking in Left Sorted array
            if(arr[low] <= arr[mid]){

                if(arr[low] <= target && target <= arr[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

            //Checking in Right Sorted array
            else{

                if(arr[high] >= target && target >= arr[mid]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int target = 3;

        int search = SearchinArr(arr, target);

        if(search == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index: " + search);
        }
    }
}