package my.algo.linkedlist;

public class DeleteNode {

    public static void main(String args[]){
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);

        System.out.println(h);

        Solution s = new Solution();
        //s.deleteNode();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution {
    public void deleteNode(ListNode node) {

    }
}