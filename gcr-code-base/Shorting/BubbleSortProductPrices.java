import java.util.*;

public class BubbleSortProductPrices {
    public static void bubbleSort(int[] prices) {
        int n = prices.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (prices[j] > prices[j + 1]) {
                    int temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextInt();
        }
        bubbleSort(prices);
        System.out.println(Arrays.toString(prices));
    }
}
