import java.util.Collections;
import java.util.ArrayList;

public class Book_Allocation {

    public static int CountStudents(ArrayList<Integer> arr , int mid){

        int stud = 1 , pagesStd = 0;
        int n = arr.size();

        for(int pages = 0; pages < n ; pages++){

            if(pagesStd + arr.get(pages) <= mid){
                pagesStd += arr.get(pages);
            }else{
                stud++;
                pagesStd = arr.get(pages);
            }
        }

        return stud;
    }

    // arr => [25,46,28,49,24] n=5   m->no of students = 5;
    public static int Allocation(ArrayList<Integer> arr, int n, int m){

        if(m > n) return -1; // EDGE CASE

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        while(low <= high){

            int mid = low + (high - low) / 2;
            int no_of_stu = CountStudents(arr , mid);
            
            if(no_of_stu > m){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(25);
        arr.add(46);
        arr.add(28);
        arr.add(49);
        arr.add(24);

        int n = arr.size();
        int m = 4;

        int ans = Allocation(arr, n, m);

        System.out.println("Minimum pages allocated = " + ans); //ans = 71
    }
}