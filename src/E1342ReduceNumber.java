public class E1342ReduceNumber {
    public static void main(String[] args) {
        int input = 0;
        int result = stepsToReduce(input);

        System.out.println(result);
    }

    private static int stepsToReduce(int input) {
        int steps = 0;

        while (input != 0) {
            input = input % 2 == 0 ? input / 2 : input - 1;
            steps++;
        }

        return steps;
    }

}
