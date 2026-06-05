public class countoccinSortedarray {

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

        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;

        int first = firstOcc(arr, target);
        int last = lastOcc(arr, target);
        int val = ((last-first)+1);;

        if(first == -1 && last == -1){
            System.out.println("Error");
        }else{
            System.out.println("Total Occurence of "+target+" is "+val);
        }
        
    }
}
