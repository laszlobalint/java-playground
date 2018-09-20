package problem014;

public class LongestCollatzSequence {
    private static long sequenceLen = 0;
    private static long startingNum = 0;

    public static void main(String[] args) {

        int num = 1000000;
        for (int i = 2; i <= num; i++) {
            int length = 1;
            long sequence = i;
            while (sequence != 1) {
                if ((sequence % 2) == 0) {
                    sequence = sequence / 2;
                } else {
                    sequence = sequence * 3 + 1;
                }
                length++;
            }
            if (length > sequenceLen) {
                sequenceLen = length;
                startingNum = i;
            }
        }
        System.out.println("The starting number " + startingNum + " produces a sequence of " + sequenceLen + ". ");
    }
}
