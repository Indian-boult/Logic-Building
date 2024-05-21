/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;

        ListNode ptr = head;
        while(head != null){
            if(ptr.val == val){
                if(ptr.next == null)
                    return ptr.next;
                ptr = ptr.next;
            }
            else if(head.next == null){
                if(head.val == val)
                    return head.next;
                break;
            }
            else if(head.next.val == val){
                if(head.next.next == null){
                    head.next = null;
                    break;
                }
                while(head.next.next != null){
                    if(head.next.next.val != val)
                        break;
                    head.next = head.next.next;
                }
                head.next = head.next.next;
            }
            head = head.next;
        }
        return ptr;
    }
}