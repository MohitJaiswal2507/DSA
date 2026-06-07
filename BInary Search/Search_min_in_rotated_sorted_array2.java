public class Search_min_in_rotated_sorted_array2 {

    public static int SearchinArr2(int[] arr){

        int low = 0 , high = arr.length - 1, ans = Integer.MAX_VALUE;

        while(low <= high){

            int mid = low + (high - low) / 2;

            // [9,9,2,8,9,9,9,9] = Shrink karna hoga if low=mid=high
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                ans = Math.min(ans, arr[mid]);
                low++;
                high--;
                continue;
            }

            // If search space is already Sorted then lowest value is min
            if(arr[low] < arr[high]){
                ans = Math.min(ans, arr[low]);
                break;
            }

            //Checking in Left Sorted array
            if(arr[low] <= arr[mid]){//LEFT part
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }else{//RIGHT PART
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {3, 3, 1, 3};

        int ans = SearchinArr2(arr);

        System.out.println("Minimum Element: " + ans);
    }
}