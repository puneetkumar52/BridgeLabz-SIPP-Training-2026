//A warehouse stores item quantities in an array. Find the max, min,
//total stock, and detect duplicates. Extend: rotate the stock array by
//k positions (simulate daily shift handover), and transpose a 2D shelf
//grid.
import java.util.*;

public class WareHouse{
 public static void main(String[] args){
     Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int[] stock = new int[n];
		for(int i=0;i<n;i++) {
			stock[i]= sc.nextInt();
		}
		findMinMax(stock);
     totalStock(stock    );
     System.out.println("Enter item to search:");
     searchItem(stock, sc.nextInt());
     findDuplicate(stock);

     int[] roted = rotateArray(stock, 2);
     System.out.println("Rotated Array: " + Arrays.toString(roted));
     for (int i=0; i<roted.length; i++) {
         stock[i] = roted[i];
     }
     int[][] shelf ={
         {1,2,3},
         {4,5,6}
     };
     sc.close();   
 }

 public static int[] rotateArray(int[] arr, int k) {
     int n = arr.length;
     int[] result = new int[n];
     for (int i=0; i<n; i++) {
         int newIndex = (i + k) % n;
         result[newIndex] = arr[i];
     }
     return result;
 }

 public static void transpose(int[][] matrix) {
     int rows = matrix.length;
     int cols = matrix[0].length;
     int[][] transposed = new int[cols][rows];
     for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++) {
             transposed[j][i] = matrix[i][j];
         }
     }
     System.out.println("Transposed Matrix:");
     for (int i=0; i<cols; i++) {
         System.out.println(Arrays.toString(transposed[i]));
     }
 }

 public static void findDuplicate(int[] arr) {
    System.out.println("Duplicate items in stock:");
     for(int i=0; i<arr.length; i++) {
         for(int j=i+1; j<arr.length; j++) {
             if(arr[i] == arr[j]) {
                 System.out.println(arr[i]);
                 break;
             }
         }
     }
 }

 public static void totalStock(int[] arr) {
     int total = 0;
     for (int num : arr) {
         total += num;
     }
     System.out.println("Total Stock: " + total);
 }

 public static void searchItem(int[] arr, int item) {
     boolean isFound = false;
     for (int i=0; i<arr.length; i++) {
         if (arr[i] == item) {
             System.out.println("Item found at index " + i);
             isFound = true;
             break;
         }
     }
     if (!isFound) {
         System.out.println("Item " + item + " not found in stock.");
     }
 }
 public static void findMinMax(int[] arr) {
     int min = Integer.MAX_VALUE;
     int max = Integer.MIN_VALUE;
     for (int num : arr) {
         if (num < min) {
             min = num;
         }
         if (num > max) {
             max = num;
         }
     }
     System.out.println("Min: " + min);
     System.out.println("Max: " + max);
 }
}