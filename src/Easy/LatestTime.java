package Easy;

public class LatestTime {
    public String findLatestTime(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (i == 2) continue;
            if (sb.charAt(i) == '?') {
                if (i == 0) {
                    if (sb.charAt(1) == '?' || sb.charAt(1) - '0' <= 1)
                        sb.setCharAt(i, '1');
                    else sb.setCharAt(i, '0');
                }
                else if (i == 1) {
                    if (sb.charAt(0) == '1') sb.setCharAt(i, '1');
                    else sb.setCharAt(i, '9');
                }
                else if (i == 3) sb.setCharAt(i, '5');
                else sb.setCharAt(i, '9');
            }
        }
        return sb.toString();
    }
}
