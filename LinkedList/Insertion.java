class Node {
    int data;
    Node next;

    Node(int data1){
        this.data = data1;
        this.next = null;
    }

    Node(int data1 , Node next1){
        this.data = data1;
        this.next = next1;
    }
}


public class Insertion {

    public static void printLL(Node head){
        
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

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

    private static Node insertAthead(Node head, int val){

        // Node temp = new Node(val, head);

        // return temp;


        return new Node(val, head);
    }

    private static Node insertAtTail(Node head, int val){
        
        if(head == null) return null;
        
        Node temp = head;


        while(temp.next != null){
            temp = temp.next;
        }

        Node newNode = new Node(val, null);
        temp.next = newNode;
        return head;
    }

    private static Node insertAtkindex(Node head , int el , int k){
        if(head == null) {
            if(k == 1){
                return new Node(el);
            }else{
                return head;
            }
        }

        if(k == 1){
            return new Node (el , head);
        }

        int cnt = 0;
        Node temp = head;

        while(temp != null){
            cnt++;
            if(cnt == (k-1)){
                Node x = new Node(el, temp.next);
                temp.next = x;
                break;                
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node insertBeforeValue(Node head , int el , int val){
        if(head == null) return null;

        if(head.data == val){
            return new Node (el , head); 
        }

        Node temp = head;

        while(temp.next  != null){

            if(temp.next.data == val){
                Node x = new Node(el, temp.next);
                temp.next = x;
                break;                
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {

        int [] arr = {12,5,6,8};
        Node head =  ArrtoLL(arr);

        System.out.print("LL before deletion ");
        printLL(head);
        System.out.print("Head before deletion " + head.data);

        System.out.println();

        // System.out.print("LL after inserting element at head => ");
        // head = insertAthead(head , 100);
        // printLL(head);
        
        // System.out.print("LL after inserting element at tail => ");
        // head = insertAtTail(head , 1600);
        // printLL(head);

        // int k = 4;
        // System.out.printf("LL after inserting element at %dth position => ",k);
        // head = insertAtkindex(head , 169 , k);
        // printLL(head);

        int k = 6,el = 170;
        System.out.printf("LL after inserting element before the value %d  => ",k);
        head = insertBeforeValue(head , el , k);
        printLL(head);

        
    }
}
