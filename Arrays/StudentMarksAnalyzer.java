import java.util.*;
public class StudentMarksAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }
        int highestMarks = findHighest(marks);
        int lowestMarks = findLowest(marks);
        int averageMarks = findAverage(marks);
        int countAbove75 = countAbove75(marks);
        int[] aboveAverageMarks = GetAboveAverageMarks(marks, averageMarks);
        
        System.out.println("Highest Marks: " + highestMarks);
        System.out.println("Lowest Marks: " + lowestMarks);
        
        System.out.println("Number of students scoring above 75: " + countAbove75);
        System.out.println("Average Marks: " + averageMarks);
        System.out.println("Marks above average: " + Arrays.toString(aboveAverageMarks));

        
    }


    public static int findHighest(int[] marks) {
        int highest = marks[0];
        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }
        return highest;
    }

    public static int findLowest(int[] marks) {
        int lowest = marks[0];
        for (int mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }
        return lowest;
    }

    public static int findAverage(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public static int countAbove75(int[] marks) {
        int count = 0;
        for(int mark : marks) {
            if (mark > 75) {
                count++;
            }
        }
        return count;
    }

    public static int[] GetAboveAverageMarks(int[] marks, int average) {
        int count = 0;
        for (int mark : marks) {
            if (mark > average) {
                count++;
            }
        }
        int[] aboveAverageMarks = new int[count];
        int index = 0;
        for (int mark : marks) {
            if (mark > average) {
                aboveAverageMarks[index++] = mark;
            }
        }
        return aboveAverageMarks;
    }
}