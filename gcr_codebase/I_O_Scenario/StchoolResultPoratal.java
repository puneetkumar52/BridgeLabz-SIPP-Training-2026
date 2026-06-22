import java.io.*;
import java.util.*;

class SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = "students.txt";   // contains: Name Marks
        String outputFile = "report.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter fw = new FileWriter(outputFile, true)) { // append mode

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int total = 0, count = 0;

                for (int i = 1; i < parts.length; i++) {
                    total += Integer.parseInt(parts[i]);
                    count++;
                }
                double avg = (double) total / count;
                fw.write("Name: " + name + ", Average: " + avg + "\n");
            }
            System.out.println("Report card generated successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found. Please check the filename.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
