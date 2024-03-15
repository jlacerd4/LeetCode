// problem: https://leetcode.com/problems/add-two-numbers/

package addTwoNumbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode();

        addTwoNumbersAux(l1, l2, newNode, 0);

        return newNode;
    }

    private void addTwoNumbersAux(ListNode l1, ListNode l2, ListNode summingUpNode, int remainder){
        if(l1 == null && l2 == null) {
            if (remainder > 0) {
                summingUpNode.val = remainder;
            }
            return;
        }
        if(l1 == null) {l1 = new ListNode(0);}
        if(l2 == null) {l2 = new ListNode(0);}
    
        int sumVal = l1.val + l2.val + remainder;
        int correctedVal = sumVal % 10;
        int newRemainder = sumVal / 10;
    
        summingUpNode.val = correctedVal;
    
        if(l1.next != null || l2.next != null || newRemainder > 0) {
            summingUpNode.next = new ListNode();
            addTwoNumbersAux(l1.next, l2.next, summingUpNode.next, newRemainder);
        }
    }
}