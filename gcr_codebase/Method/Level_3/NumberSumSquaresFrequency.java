public class NumberSumSquaresFrequency {
    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }

    public static int sumSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, 2);
        return sum;
    }

    public static boolean isHarshad(int num, int[] digits) {
        int sum = sumDigits(digits);
        return num % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int d : digits) freq[d][1]++;
        return freq;
    }

    public static void main(String[] args) {
        int num = 21;
        int[] digits = NumberChecker.storeDigits(num);
        System.out.println("Sum of digits = " + sumDigits(digits));
        System.out.println("Sum of squares = " + sumSquares(digits));
        System.out.println("Harshad? " + isHarshad(num, digits));
        int[][] freq = digitFrequency(digits);
        for (int[] row : freq) if (row[1] > 0)
            System.out.println("Digit " + row[0] + " occurs " + row[1] + " times");
    }
}
