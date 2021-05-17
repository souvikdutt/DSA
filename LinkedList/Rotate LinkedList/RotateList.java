class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        int n = 1;
        ListNode temp = head;
        
        while(temp.next!=null) {
            n++;
            temp = temp.next;
        }
        
        temp.next = head;
        k = n - (k%n);
        while(k-- > 0) temp=temp.next;
        
        head = temp.next;
        temp.next = null;
        
        return head;
    }
}