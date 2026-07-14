import java.util.*;

public class BubbleSortSwapCount {
    public static int bubbleSortWithCount(int[] nums) {
        int n = nums.length;
        int swapCount = 0;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapCount++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return swapCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int swaps = bubbleSortWithCount(nums);
        System.out.println("Sorted Array: " + Arrays.toString(nums));
        System.out.println("Total Swaps: " + swaps);
    }
}
