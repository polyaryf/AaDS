package HwTasks;

public class MergeLists2 {

    public class ListNode {
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

    public boolean hasValue(Integer val) {
        return val != null ? true : false;
    }

    public ListNode MergeKLists(ListNode[] lists) {

    ListNode[] marker = new ListNode[lists.length];
    ListNode newHead = null;
    ListNode lastAdded = null;

    for(int i = 0; i < lists.length; i++) {
        marker[i] = lists[i];
    }

    while(true) {

        Integer minValue = null;
        Integer index = null;

        for(int i = 0; i < marker.length; i++) {
            if(marker[i] != null) {
                if(hasValue(minValue)) {
                    if(marker[i].val < minValue.intValue()) {
                        minValue = marker[i].val;
                        index = i;
                    }
                } else {
                    minValue = marker[i].val;
                    index = i;
                }
            }
        }

        if(!hasValue(minValue)) {
            break;
        }

        if(newHead == null) {
            newHead = new ListNode(marker[index].val);
            lastAdded = newHead;
        } else {
            lastAdded.next = new ListNode(marker[index].val);
            lastAdded = lastAdded.next;
        }

        marker[index] = marker[index].next;
    }
    return newHead;
    }
}
