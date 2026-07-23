import java.util.*;

public class BuildSystem {
    boolean hasCircularDependency(Map<Integer, List<Integer>> tasks, int n) {
        int[] state = new int[n]; 
        for (int v = 0; v < n; v++) {
            if (state[v] == 0) {
                if (dfsCycleCheck(tasks, v, state)) return true;
            }
        }
        return false;
    }

    boolean dfsCycleCheck(Map<Integer, List<Integer>> tasks, int node, int[] state) {
        state[node] = 1; // GRAY
        for (int dep : tasks.getOrDefault(node, Collections.emptyList())) {
            if (state[dep] == 1) return true; 
            if (state[dep] == 0 && dfsCycleCheck(tasks, dep, state)) return true;
        }
        state[node] = 2; 
        return false;
    }
}
