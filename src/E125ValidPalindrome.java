public class E125ValidPalindrome {

    public static void main(String[] args) {
        String input = " ";
        boolean result = isPalindrome(input);

        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        char[] inverse = new char[s.length()];
        char[] input = s.toCharArray();
        int j = 0;

        for (int i = input.length - 1; i >= 0; i--) {
            inverse[j] = input[i];
            j++;
        }

        return new String(inverse).equals(s);
    }

}
