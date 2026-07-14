import java.util.*;

public class Shorting {
    public static void main(String[] args) {
        int[] scores = {64, 25, 12, 22, 11};
        System.out.println("Original Scores: " + Arrays.toString(scores));

        // Bubble Sort
        int[] bubbleArr = scores.clone();
        BubbleSort.bubbleSort(bubbleArr);
        System.out.println("Bubble Sorted: " + Arrays.toString(bubbleArr));

        // Insertion Sort
        int[] insertionArr = scores.clone();
        InsertionSort.insertionSort(insertionArr);
        System.out.println("Insertion Sorted: " + Arrays.toString(insertionArr));

        // Selection Sort
        int[] selectionArr = scores.clone();
        SelectionSort.selectionSort(selectionArr);
        System.out.println("Selection Sorted: " + Arrays.toString(selectionArr));

        // Top-3 medalists
        Arrays.sort(scores);
        System.out.println("Top-3 Medalists: " + scores[scores.length-1] + ", "
                + scores[scores.length-2] + ", " + scores[scores.length-3]);

        // Employee Attendance Ranking
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int K = 3;
        int[] topEmployees = AttendanceRanking.topKAttendance(employeeIds, attendance, K);
        System.out.println("Top " + K + " Employees by Attendance: " + Arrays.toString(topEmployees));
    }
}
