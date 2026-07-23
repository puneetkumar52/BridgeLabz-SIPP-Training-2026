import java.util.*;

public class AttendanceRanking {
    public static int[] topKAttendance(int[] employeeIds, int[] attendance, int K) {
        int n = employeeIds.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) -> {
            if (attendance[b] != attendance[a]) {
                return attendance[b] - attendance[a]; 
            } else {
                return employeeIds[a] - employeeIds[b]; 
            }
        });

        int[] result = new int[K];
        for (int i = 0; i < K; i++) {
            result[i] = employeeIds[indices[i]];
        }
        return result;
    }
}
