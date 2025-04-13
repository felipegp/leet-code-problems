import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntrevistaUpstart13 {

    public static void main(String[] args) {
        String input = "mg cs qms";
        String knownWord = "oi";

        String result = decrypt(input, knownWord);
        System.out.println(result);
    }

    private static String decrypt(String encrypted, String knowWord) {
        List<String> encryptWords =
                Arrays.stream(encrypted.split(" "))
                        .filter(s -> s.length() == knowWord.length()).collect(Collectors.toList());

        if (encryptWords.isEmpty()) {
            return "Invalid";
        }

        shuffleUp(encryptWords, 1);

        int count = 1;

        while (count <= 26) {
            if (encryptWords.contains(knowWord)) {
                List<String> encryptedList = new ArrayList<>();
                encryptedList.add(encrypted);
                shuffleUp(encryptedList, count);
                return encryptedList.get(0);
            } else {
                shuffleUp(encryptWords, 1);
                count++;
            }
        }

        return "Invalid";
    }

    private static void shuffleUp(List<String> wordList, int count) {
        for (int h = 0; h < wordList.size(); h++) {
            for (int i = 0; i < count; i++) {
                char[] input = wordList.get(h).toCharArray();

                for (int j = 0; j < input.length; j++) {
                    if (input[j] != ' ') {
                        if (input[j] == 'Z') {
                            input[j] = 'A';
                        } else if (input[j] == 'z') {
                            input[j] = 'a';
                        } else {
                            input[j]++;
                        }
                    }
                }

                wordList.set(h, new String(input));
            }
        }
    }
}
