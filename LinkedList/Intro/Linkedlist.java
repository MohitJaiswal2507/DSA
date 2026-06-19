package Intro;
class Node{
    int data;
    Node next;

    //Default contructor
    Node(int data1){
        this.data = data1;
        this.next = null;
    }

    //parametrised constructo
    Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }

}

public class Linkedlist {

    private static Node ArrtoLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1 ; i<arr.length ; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    } 

    private static int lengthofLL(Node head){
        int cnt = 0;
        Node temp = head;
        System.out.println();

        while(temp != null){
            temp = temp.next;
            cnt++;
        }
        return cnt;

    }

    private static boolean checkifPresent(Node head, int val){
        Node temp = head;
        while(temp != null){
            if(temp.data == val) return true;
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10,12,17,23,45};

        Node x = new Node(arr[3]);
        System.out.println("Array 3 address at "+x);
        System.out.println("Array 3 at "+x.data);
        System.out.println("Array 3 next pointing to "+x.next);

        //Array to Linked List conversion
        Node head = ArrtoLL(arr);
        System.out.println("Arr to LL conversion head "+head.data);

        //Traversal
        Node temp = head;
        System.out.print("Linked list to arr => ");
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        //Length of LL
        System.out.print("Length of LL => "+lengthofLL(head));
        System.out.println();

        //Checking in LL
        System.out.println("Is 23 present in LL => "+checkifPresent(head, 23));
        System.out.println("Is 69 present in LL => "+checkifPresent(head, 69));


    }
}
