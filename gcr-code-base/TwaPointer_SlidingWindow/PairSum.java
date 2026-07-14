public class PairSum {
    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0, right = transactions.length - 1;
        while (left < right) {
            int sum = transactions[left] + transactions[right];
            if (sum == target) return new int[]{transactions[left], transactions[right]};
            else if (sum < target) left++;
            else right--;
        }
        return new int[]{-1, -1}; // not found
    }

    public static void main(String[] args) {
        int[] tx = {10000, 15000, 20000, 30000, 34999};
        int target = 49999;
        System.out.println(Arrays.toString(findPairSum(tx, target)));
    }
}
