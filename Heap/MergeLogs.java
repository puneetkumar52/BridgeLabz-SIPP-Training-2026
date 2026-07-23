import java.util.*;

class LogEntry {
    int timestamp;
    String message;
    LogEntry(int timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }
}

public class MergeLogs {
    List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> sources.get(a[0]).get(a[1]).timestamp -
                      sources.get(b[0]).get(b[1]).timestamp
        );

        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<LogEntry> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int src = top[0], idx = top[1];
            merged.add(sources.get(src).get(idx));
            if (idx + 1 < sources.get(src).size()) {
                minHeap.offer(new int[]{src, idx + 1});
            }
        }
        return merged;
    }
}
