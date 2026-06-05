class Recurssive_approach{
    public static int Solution(int[] arr, int low, int high, int target){

        if(low > high)  return -1; //BASE CASE for recurssion

        int mid= low+(high-low)/2;
        
        if(arr[mid] == target) return mid;

        else if(target > arr[mid]){
            return Solution(arr, mid+1, high, target);
        }else{
            return Solution(arr, low, mid-1, target);
        }
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        int ans = Solution(arr, 0, arr.length - 1, target);

        if(ans == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index: " + ans);
        }
    }   
}