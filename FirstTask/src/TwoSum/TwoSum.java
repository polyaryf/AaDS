package TwoSum;


public class TwoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder firstDigit = listNodeToString(l1);
        StringBuilder secondDigit = listNodeToString(l2);
        StringBuilder sum = sumString(firstDigit,secondDigit);
        ListNode result = new ListNode();
        ListNode head = result;
        sum = sum.reverse();
        for (int i = 0; i < sum.length() ; i++) {
            if(i == sum.length() - 1){
                result.val = sum.charAt(i) - '0';
                result.next = null;
                break;
            }
            result.val = sum.charAt(i) - '0';
            result.next= new ListNode();
            result = result.next;
        }
        return head;
    }

    public static StringBuilder sumString(StringBuilder s1, StringBuilder s2){
        StringBuilder sum = new StringBuilder();
        makeSameLength(s1,s2);
        s1 = s1.reverse();
        s2 = s2.reverse();
        Integer curVal = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            curVal += ((s1.charAt(i) - '0') + (s2.charAt(i) - '0'));
            if(i == s1.length() - 1 && curVal >= 10){
                sum.append(toString(curVal).charAt(1));
                sum.append(1);
                curVal = 1;
            }else if(curVal >= 10){
                sum.append(curVal % 10);
                curVal = 1;
            }else {
                sum.append(curVal);
                curVal = 0;
            }
        }
        sum = sum.reverse();
        return sum;
    }


    public static void makeSameLength(StringBuilder s1, StringBuilder s2){
        if (s1.length() == s2.length()) {
            return;
        }else if(s1.length() > s2.length()){
            int difference = s1.length() - s2.length();
            for (int i = 0; i < difference; i++) {
                s2.append('0');
            }
        }else{
            int difference = s2.length() - s1.length();
            for (int i = 0; i < difference ; i++) {
                s1.append('0');
            }
        }
    }


    public static StringBuilder listNodeToString(ListNode l){
        boolean flag = true;
        StringBuilder digit = new StringBuilder();
        while (flag) {
            if(l.next != null){
                digit.append(l.val);
                l = l.next;
            }else {
                digit.append(l.val);
                flag = false;
            }
        }
        return digit;
    }

    public static String toString(int val) {
        String s = String.valueOf(val);
        return  s;
    }
}



