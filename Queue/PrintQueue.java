import java.util.ArrayDeque;
import java.util.Deque;

class PrintQueue {
    private Deque<Integer> printQueue = new ArrayDeque<>();

    void submitJob(int jobId) {
        printQueue.addLast(jobId); 
    }

    void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId); 
    }

    int printNextJob() {
        return printQueue.removeFirst(); 
    }
}
