/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class CloneLinkedList {
    public Node copyRandomList(Node head) {
        //Add copy of each node after each one (Make deep copy of each node)
        Node iter = head;
        Node front = head;
        while(iter!=null) {
            front = iter.next;
            Node copy = new Node(iter.val);
            copy.next = front;
            iter.next = copy;
            iter = front;
        }

        //Link random pointer at the copy nodes
        iter = head;
        while(iter!=null) {
            if(iter.random!=null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        //Detach copy list from the original list
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy = pseudoHead;
        
        while(iter!=null) {
            front = iter.next.next;
            copy.next = iter.next;
            iter.next = front;
            iter = iter.next;
            copy = copy.next;
        }
        return pseudoHead.next;
    }
}