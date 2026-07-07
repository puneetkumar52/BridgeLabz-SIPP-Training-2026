import java.util.*;

public class GenericsDemo {
    public static void main(String[] args) {
        // Pair
        Pair<String, Integer> p1 = new Pair<>("Age", 25);
        System.out.println("Pair: " + p1);

        // Stack
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack: " + stack);
        System.out.println("Popped: " + stack.pop());

        // findMax
        Integer[] nums = {10, 25, 7, 30};
        System.out.println("Max: " + GenericUtils.findMax(nums));

        // Repository
        Repository<String> repo = new Repository<>();
        repo.add("Entity1");
        repo.add("Entity2");
        System.out.println("Repository: " + repo.getAll());

        // Wildcard print
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        System.out.println("Printing list with wildcard:");
        Printer.printList(doubles);
    }
}
