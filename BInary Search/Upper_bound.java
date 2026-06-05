//Lower BOUND => smallest index that is arr[index] > target
public class Upper_bound {
    public static int Solution(int[] arr , int target){
        int low = 0, high = arr.length - 1, ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 11;

        int ans = Solution(arr, target);

        System.out.println("Upper Bound Index = " + ans);
    }
}
