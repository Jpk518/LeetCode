public class LinkedListDesign {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println(list.get(0)); // -1
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtHead(6);
        System.out.println(list.get(0)); // 6
        System.out.println(list.get(1)); // 3
        System.out.println(list.get(2)); // 4
    }
}

// Note: Does not handle indexing negative values
class LinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size; // Handles indexes greater than current size by using in conjunction with conditional

    public int get(int index) {
        if (index >= size) return -1;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        Node prev = head;
        head = new Node(val);
        head.next = prev;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node current = head;
        size++;
        if (head == null) {
            head = newNode;
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        size--;
        // Handle 0th position
        if (index == 0) {
            head = head.next;
        }
        // Handle nth > 0 positon
        Node current = head;
        int prevIndex = index -1;
        for (int i = 0; i < prevIndex; i++) {
            current = current.next;
        }
        current.next = current.next.next; // Reallocate pointer to index node to the node after it
    }
}
