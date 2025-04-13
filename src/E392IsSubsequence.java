public class E392IsSubsequence {

    public static void main(String[] args) {
        String s = "b";
        String t = "abc";
        boolean result = isSubsequence(s, t);

        System.out.println(result);
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }

        int sIdx = 0;

        for (int tIdx = 0; tIdx < t.length(); tIdx++) {
            if (sIdx == s.length()) {
                break;
            }

            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx += 1;
            }
        }

        return sIdx == s.length();
    }

}
