package Medium;

import java.util.Arrays;

public class ShortestUncommonSubstring {
    public String[] shortestSubstrings(String[] arr) {
        String[] answer = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = "";
            for (int j = 0; j < arr[i].length(); j++) {
                for (int k = arr[i].length(); k >= j + 1; k--) {
                    String current = arr[i].substring(j, k);
                    boolean isPresent = false;
                    for (int p = 0; p < arr.length; p++) {
                        if (p == i) continue;
                        if (arr[p].contains(current)) {
                            isPresent = true;
                            break;
                        }
                    }
                    if (!isPresent) {
                        if (answer[i].isEmpty() || answer[i].length() > current.length())
                            answer[i] = current;
                        else if (answer[i].length() == current.length() && answer[i].compareTo(current) > 0)
                            answer[i] = current;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShortestUncommonSubstring().shortestSubstrings(new String[]
                {"gfnt","xn","mdz","yfmr","fi","wwncn","hkdy"})));
    }
}
