package Medium;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(path);
        if (path.charAt(path.length() - 1) != '/') sb.append('/');
        int i = sb.indexOf("/");
        int start = i + 1;
        while (i != -1) {
            i = sb.indexOf("/", start);
            if (i > 0) {
                String folder = sb.substring(start, i);
                start = i + 1;
                if (folder.equals("..") && !stack.isEmpty()) stack.pop();
                else if (!folder.equals("..")) stack.add(folder);
            }
            while (start < path.length() && sb.charAt(start) == '/') start++;
        }
        String[] folders = new String[stack.size()];
        for(i = stack.size() - 1; i >= 0; i--) folders[i] = stack.pop();
        sb.setLength(0);
        sb.append("/");
        for (String word: folders) {
            sb.append(word); sb.append("/");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        new SimplifyPath().simplifyPath("/home//foo");
    }
}
