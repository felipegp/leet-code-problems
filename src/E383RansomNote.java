import java.util.HashMap;
import java.util.Map;

public class E383RansomNote {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        boolean result = canConstruct(ransomNote, magazine);

        System.out.println(result);
    }

    private static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> magazineMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            var count = magazineMap.getOrDefault(c, 0);
            magazineMap.put(c, count + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            var count = magazineMap.getOrDefault(c, 0);

            if (count == 0) {
                return false;
            }

            magazineMap.put(c, count - 1);
        }

        return true;
    }
}
