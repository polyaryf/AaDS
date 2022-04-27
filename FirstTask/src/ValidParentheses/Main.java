package ValidParentheses;

import java.util.HashMap;
import java.util.Stack;


public class Main {
    public static boolean isValid(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        Stack st = new Stack();

        mp.put('(', 1);
        mp.put('{', 2);
        mp.put('[', 3);

        mp.put(')', -1);
        mp.put('}', -2);
        mp.put(']', -3);

        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (mp.get(symbol) > 0) {
                st.push(symbol);
                if (st.isEmpty()) return false;
            } else {
                int val = mp.get(st.peek());
                if (val + mp.get(symbol) != 0) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        if(st.empty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "(())";
        System.out.println(isValid(s));
    }
}
