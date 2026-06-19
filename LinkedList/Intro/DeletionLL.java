package Intro;
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

public class DeletionLL {

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

    public static void printLL(Node head){
        
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node removeHead(Node head){
        if(head == null) return head;
        head = head.next;
        return head;
    } 

    private static Node removeTail(Node head){
        if(head == null || head.next == null) return null; //Edge case if linked list is [null] or [12]->null

        Node temp = head;
        //Going to the 2nd last element 
        while(temp.next.next != null){
            temp = temp.next;
        } 
        temp.next = null; // 2nd last ko nuullptr dedo
        return head;
    }
    
    private static Node removeKthNode(Node head, int k){
        if(head == null) return null;

        if(k==1) {
            // Node temp = head;
            head = head.next;
            return head;
        }

        int cnt=0 ; Node temp = head ; Node prev = null; 
        while(temp != null){
            cnt++;
            if(cnt == k){
                prev.next = prev.next.next;
                break;
        }
            prev = temp;
            temp = temp.next;
        }

        if(k > cnt) return null; // suppose 5 dediya tab null dedena
        
        return head;
    }
    

    private static Node removeElNode(Node head , int el){
        if(head == null) return null;

        if(head.data == el){
            
            head = head.next;
            return head;
        }

        Node temp = head;
        Node prev = null;
        
        while(temp != null){
            if(temp.data == el){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;//first save then update temp
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

        head = removeHead(head);
        printLL(head);
        System.out.print("Head after deletion " + head.data);

        head = removeTail(head);
        printLL(head);
        System.out.print("Head after Tail deletion " + head.data);

        System.out.print("LL after deletion of kth element => ");
        head = removeKthNode(head, 4);
        printLL(head);

        int el = 5;
        System.out.printf("LL after deletion of %dth element => ",el);
        head = removeElNode(head, el);
        printLL(head);

    }
}
