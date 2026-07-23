public class Heapify {
    void buildHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, n);
        }
    }

    void siftDown(int[] arr, int i, int size) {
        int smallest = i;
        int left = 2 * i + 1, right = 2 * i + 2;
        if (left < size && arr[left] < arr[smallest]) smallest = left;
        if (right < size && arr[right] < arr[smallest]) smallest = right;
        if (smallest != i) {
            int tmp = arr[i]; arr[i] = arr[smallest]; arr[smallest] = tmp;
            siftDown(arr, smallest, size);
        }
    }
}
