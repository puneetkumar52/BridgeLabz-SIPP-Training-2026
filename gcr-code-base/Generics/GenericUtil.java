public class GenericUtils {
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) return null;
        T max = arr[0];
        for (T item : arr) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
}
