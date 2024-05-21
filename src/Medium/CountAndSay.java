package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountAndSay {
    private String getFreq(String s) {
        if (s.length() == 1) return "11";
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0, i = 0;
        for (i = 0; i <= chars.length; i++) {
            if (i == chars.length) {
                sb.append(count); sb.append(chars[i - 1]);
                break;
            }
            if (i == 0) count = 1;
            else if (chars[i] == chars[i - 1]) count++;
            else {
                sb.append(count);sb.append(chars[i - 1]);
                count = 1;
            }
        }
//        if (i - 2 > 0 && chars[i - 1] != chars[i - 2]) {
//            sb.append(1);sb.append(chars[i - 1]);
//        }
        return sb.toString();
    }

    public String countAndSay(int n) {
        String prev = "1";
        for (int i = 2; i <= n; i++)
            prev = getFreq(prev);
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }
}
