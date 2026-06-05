// // APPROACH 1 => USING LOWER AND UPPER BOUND CONCEPT
// public class firstandlastoccurence {
//     //Lower BOUND
//     public static int Lower_bound(int[] arr, int target) {
//         int low = 0, high = arr.length - 1, ans = arr.length;

//         while (low <= high) {
//             int mid = low + (high - low) / 2;

//             if (arr[mid] >= target) {
//                 ans = mid;
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }

//         return ans;
//     }

//     //Upper Bound
//     public static int Upper_bound(int[] arr, int target) {
//         int low = 0, high = arr.length - 1, ans = arr.length;

//         while (low <= high) {
//             int mid = low + (high - low) / 2;

//             if (arr[mid] > target) {
//                 ans = mid;
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }

//         return ans;
//     }

//     public static int[] Solution(int[] arr, int n, int target) {
//         int lb = Lower_bound(arr, target);
//         int ub = Upper_bound(arr, target);

//         if (lb == n || arr[lb] != target) {
//             return new int[]{-1, -1};
//         }

//         return new int[]{lb, ub - 1};
//     }

//     public static void main(String[] args) {

//         int[] arr = {2, 4, 4, 4, 6, 8, 8};
//         int target = 4;

//         int[] ans = Solution(arr, arr.length, target);

//         System.out.println("First Occurrence: " + ans[0]);
//         System.out.println("Last Occurrence: " + ans[1]);
//     }
// }


//Approch 2 = Direct BS
public class firstandlastoccurence {

    //First Occurence
    public static int firstOcc(int[] arr, int target) {

        int low = 0, high = arr.length - 1, occurence = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target){
                occurence = mid;
                high = mid-1; //Check more for the smallest integer
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;            
            }

        }

        return occurence;
    }

    //Last Occurence
    public static int lastOcc(int[] arr, int target) {

        int low = 0, high = arr.length - 1, occurence = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target){
                occurence = mid;
                low = mid+1; //Check more for the smallest integer
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;            
            }
        }

        return occurence;
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, 4, 4, 6, 8, 8};
        int target = 4;

        System.out.println("First Occurrence: " + firstOcc(arr, target));
        System.out.println("Last Occurrence: " + lastOcc(arr, target));
    }
}