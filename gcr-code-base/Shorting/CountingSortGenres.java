import java.util.*;

public class CountingSortGenres {
    public static void countingSort(int[] arr, int maxVal) {
        int[] count = new int[maxVal + 1];
        for (int num : arr) count[num]++;
        int index = 0;
        for (int i = 1; i <= maxVal; i++) {
            while (count[i]-- > 0) arr[index++] = i;
        }
    }

    public static void main(String[] args) {
        int[] genres = {5, 1, 3, 2, 5, 4, 1};
        countingSort(genres, 20);
        System.out.println(Arrays.toString(genres));
    }
}
