import java.util.*;

public class NextBusierDay {
    public static int[] nextBusierDay(int[] visitors) {
        int n = visitors.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>(); // indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && visitors[i] > visitors[stack.peek()]) {
                answer[stack.pop()] = visitors[i];
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] visitors = {100, 80, 90, 120};
        System.out.println(Arrays.toString(nextBusierDay(visitors)));
        // Output: [120, 90, 120, -1]
    }
}
