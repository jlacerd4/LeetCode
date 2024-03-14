// problem: https://leetcode.com/problems/add-two-numbers/

package addTwoNumbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode();

        addTwoNumbersAux(l1, l2, newNode, 0);

        return newNode;
    }

    private void addTwoNumbersAux(ListNode l1, ListNode l2, ListNode summingUpNode, int remainder){
        if(l1 == null && l2 == null) return;
        if(l1 == null) {l1 = new ListNode(0);}
        if(l2 == null) {l2 = new ListNode(0);}

        int sumVal = l1.val + l2.val + remainder;
        int correctedVal = sumVal % 10;
        int newRemainder = (int) sumVal / 10;

        ListNode newNode = new ListNode();

        summingUpNode.val = correctedVal;
        summingUpNode.next = newNode;

        addTwoNumbersAux(l1.next, l2.next, newNode, newRemainder);
    }
}