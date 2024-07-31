import java.util.Scanner;

class LinkedListJava {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static void printLinkedList(){
        if(head == null){
            System.out.println("Linked List is Empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int data, int index){
        if(index == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        size++;
        while(i < index - 1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if(size == 0){
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        head = head.next;
        size--;
        if(size == 0){
            tail = null;
        }
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("Linked List is Empty.");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        Node prev = head;
        for(int i = 0; i < size - 2; i++){
            prev = prev.next;
        }
        int value = prev.next.data; //tail data
        prev.next = null;
        size--;
        return value;
    }

    //Iterative Search
    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int recSearch(int key){
        return helper(head, key);
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int index = helper(head.next, key);
        if(index == -1){
            return -1;
        }
        return index + 1;
    }

    public void reverseLinkedList(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        LinkedListJava ll = new LinkedListJava();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Add at Index");
            System.out.println("4. Remove First");
            System.out.println("5. Remove Last");
            System.out.println("6. Print Linked List");
            System.out.println("7. Iterative Search");
            System.out.println("8. Recursive Search");
            System.out.println("9. Reverse Linked List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to add first: ");
                    int dataFirst = sc.nextInt();
                    ll.addFirst(dataFirst);
                    break;
                case 2:
                    System.out.print("Enter data to add last: ");
                    int dataLast = sc.nextInt();
                    ll.addLast(dataLast);
                    break;
                case 3:
                    System.out.print("Enter data to add: ");
                    int data = sc.nextInt();
                    System.out.print("Enter index to add at: ");
                    int index = sc.nextInt();
                    ll.add(data, index);
                    break;
                case 4:
                    ll.removeFirst();
                    break;
                case 5:
                    ll.removeLast();
                    break;
                case 6:
                    printLinkedList();
                    break;
                case 7:
                    System.out.print("Enter key to search (iterative): ");
                    int keyItr = sc.nextInt();
                    int indexItr = ll.itrSearch(keyItr);
                    if(indexItr == -1){
                        System.out.println("Key: " + keyItr + " is not found");
                    } else {
                        System.out.println("Key: " + keyItr + " is found at index: " + indexItr);
                    }
                    break;
                case 8:
                    System.out.print("Enter key to search (recursive): ");
                    int keyRec = sc.nextInt();
                    int indexRec = ll.recSearch(keyRec);
                    if(indexRec == -1){
                        System.out.println("Key: " + keyRec + " is not found");
                    } else {
                        System.out.println("Key: " + keyRec + " is found at index: " + indexRec);
                    }
                    break;
                case 9:
                    ll.reverseLinkedList();
                    System.out.println("Linked List reversed");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again.");
                    break;
            }
        } while(choice != 0);
        sc.close();
    }
}
