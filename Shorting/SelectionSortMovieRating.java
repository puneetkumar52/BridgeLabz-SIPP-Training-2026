import java.util.*;

public class SelectionSortMovieRating {
    public static void selectionSort(int[] ratings) {
        int n = ratings.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (ratings[j] < ratings[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = ratings[minIndex];
            ratings[minIndex] = ratings[i];
            ratings[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ratings = new int[N];
        for (int i = 0; i < N; i++) {
            ratings[i] = sc.nextInt();
        }
        selectionSort(ratings);
        System.out.println(Arrays.toString(ratings));
    }
}
