package Easy;

public class LatestTime {
    public String findLatestTime(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (i == 2) continue; // skipping the index containing ':'
            // if value is missing then
            if (sb.charAt(i) == '?') {
                // if at the first index check if the next index <= 1 and assign value
                if (i == 0) {
                    if (sb.charAt(1) == '?' || sb.charAt(1) - '0' <= 1)
                        sb.setCharAt(i, '1');
                    else sb.setCharAt(i, '0');
                }
                // check previous index and assign values accordingly
                else if (i == 1) {
                    if (sb.charAt(0) == '1') sb.setCharAt(i, '1');
                    else sb.setCharAt(i, '9');
                }
                // assign 5 as no other option exists
                else if (i == 3) sb.setCharAt(i, '5');
                // assign 4 as no other option exists
                else sb.setCharAt(i, '9');
            }
        }
        return sb.toString();
    }
}
