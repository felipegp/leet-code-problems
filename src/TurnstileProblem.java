import java.util.*;

public class TurnstileProblem {

    /*

    Find the time for each person, when they can pass the turnstile 4 rules:
    - If NOT used in the sec before: Preference on 1=exit
    - If used as EXIT in the sec before: Preference on 1
    - If used as ENTRY in the sec before: Preference on 0
    - If multiple people arrive at the same time: Index is relevant"

    [0, 0, 1, 5] time when they come to turnstile
    [0, 1, 1, 0] 1=exit, 0=enter
    output: [2, 0, 1, 5]  T0: 1, T1: 2, T2: 0, T5: 3

    */

    public static void main(String[] args) {
        var times = new int[]{0, 0, 1, 5};
        var directions = new int[]{0, 1, 1, 0};

        var result = turnstile(times, directions);

        System.out.println(Arrays.toString(result));
    }

    private static int[] turnstile(int[] times, int[] directions) {
        Map<Integer, Integer> result = new HashMap<>();
        Map<Integer, List<Integer>> timeMap;
        int currentTime = 0;

        while (result.size() != times.length) {
            timeMap = generateTimeMap(times);

            var idsAtTime = timeMap.get(currentTime);

            if (idsAtTime != null) {
                var preferableDir = getPreferableDir(result, currentTime, directions);
                var preferablePerson = getPreferablePerson(preferableDir, idsAtTime, directions);

                result.put(currentTime, preferablePerson);
                times[preferablePerson] = currentTime;

                addPlusOneForRemainingIdx(idsAtTime, currentTime, times, preferablePerson);
            }

            currentTime++;
        }

        return resultMapToArray(result);
    }

    private static void addPlusOneForRemainingIdx(List<Integer> idxAtTime, int currentTime, int[] times, int preferableIdx) {
        for (int i : idxAtTime) {
            if (i != preferableIdx) {
                times[i] = currentTime + 1;
            }
        }
    }

    private static int[] resultMapToArray(Map<Integer, Integer> result) {
        int[] resultArray = new int[result.size()];

        result.forEach((time, idx) -> {
            resultArray[idx] = time;
        });

        return resultArray;
    }

    private static int getPreferablePerson(int dir, List<Integer> idx, int[] directions) {
        int id = -1;

        for (int i : idx) {
            var idxDir = directions[i];

            if (id == -1) {
                id = i;
            } else if (idxDir == dir) {
                id = i;
                break;
            }
        }

        return id;
    }

    private static int getPreferableDir(Map<Integer, Integer> result, int currentTime, int[] directions) {
        var lastUsed = result.get(currentTime - 1);

        if (currentTime == 0 || lastUsed == null) {
            return 1;
        }

        var lastDir = directions[lastUsed];

        if (lastDir == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private static Map<Integer, List<Integer>> generateTimeMap(int[] times) {
        Map<Integer, List<Integer>> timeMap = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            var idsAtTime = timeMap.getOrDefault(times[i], new ArrayList<>());
            idsAtTime.add(i);
            timeMap.put(times[i], idsAtTime);
        }

        return timeMap;
    }
}
