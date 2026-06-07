public class Search_in_rotated_sorted_array2 {

    public static int SearchinArr2(int[] arr , int target){

        int low = 0 , high = arr.length - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(arr[mid] == target) return mid;

            // [9,9,2,8,9,9,9,9] = Shrink karna hoga if low=mid=high
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
            }

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

        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;

        int ans = SearchinArr2(arr, target);

        if(ans == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index: " + ans);
        }
    }
}