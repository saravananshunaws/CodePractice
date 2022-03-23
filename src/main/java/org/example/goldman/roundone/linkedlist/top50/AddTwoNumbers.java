package org.example.goldman.roundone.linkedlist.top50;

public class AddTwoNumbers {

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;
        ListNode head = null, curr = null;
        int carry = 0;
        while(l1Curr != null){
            int val1 = l1Curr.val;
            int val2 = l2Curr.val;

            int sum = carry + val1 + val2;
            carry = sum / 10;
            if(head == null){
                head = new ListNode(sum % 10);
                curr = head;
            }else{
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
            }
            l1Curr = l1Curr.next;
            l2Curr = l2Curr.next;
        }
        return null;
    }
}
