import java.util.*;

public class AttendanceTracker {
    private HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    public void markAttendance(String subject, String student) {
        attendance.putIfAbsent(subject, new ArrayList<>());
        ArrayList<String> students = attendance.get(subject);

        if (students.contains(student)) {
            System.out.println("Duplicate entry: " + student + " already marked in " + subject);
        } else {
            students.add(student);
            System.out.println("Marked: " + student + " in " + subject);
        }
    }

    public void display() {
        for (String subject : attendance.keySet()) {
            ArrayList<String> students = attendance.get(subject);
            System.out.println("Subject: " + subject);
            for (String s : students) System.out.println("- " + s);
            System.out.println("Total students: " + students.size());
        }
    }

    public static void main(String[] args) {
        AttendanceTracker tracker = new AttendanceTracker();
        tracker.markAttendance("Math", "Alice");
        tracker.markAttendance("Math", "Bob");
        tracker.markAttendance("Science", "Alice");
        tracker.markAttendance("Math", "Alice"); // duplicate
        tracker.display();
    }
}
