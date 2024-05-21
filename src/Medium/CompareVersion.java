package Medium;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.min(v1.length, v2.length);
        int i, j;
        for (i = 0, j = 0; i < len && j < len; i++, j++) {
            int num1 = Integer.parseInt(v1[i]);
            int num2 = Integer.parseInt(v2[j]);
            if (num1 < num2) return -1;
            else if (num1 > num2) return 1;
        }
        while (i < v1.length)
            if (Integer.parseInt(v1[i++]) != 0) return 1;
        while (j < v2.length)
            if (Integer.parseInt(v2[j++]) != 0) return -1;
        return 0;
    }

}
