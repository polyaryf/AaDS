package HwTasks;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeLists1 {

    public class ListNode{
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) return null;

        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(head -> head.val));

        for(ListNode listNode : lists) {
            if (listNode != null)
                minHeap.offer(listNode);
        }

        ListNode head = null;
        ListNode current = null;

        while(!minHeap.isEmpty()){

            ListNode currentNode = minHeap.poll();

            if(currentNode.next != null) {
                minHeap.offer(currentNode.next);
            }
            if(head == null){
                head = new ListNode(currentNode.val);
                current = head;
            }
            else{
                current.next = new ListNode(currentNode.val);
                current = current.next;
            }
        }
        return head;
    }
}
