import java.util.*;

public class DelieveryRoutes {
    void allRoutes(Map<Integer, List<Integer>> roads, int current, int target,
                   List<Integer> path, Set<Integer> visited, List<List<Integer>> allRoutes) {
        path.add(current);
        visited.add(current);

        if (current == target) {
            allRoutes.add(new ArrayList<>(path));
        } else {
            for (int next : roads.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    allRoutes(roads, next, target, path, visited, allRoutes);
                }
            }
        }

        path.remove(path.size() - 1); // backtrack
        visited.remove(current);      // backtrack
    }
}
