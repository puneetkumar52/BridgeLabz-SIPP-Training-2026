public class CallStack {
    private static class Frame {
        String functionName;
        Frame next;
        Frame(String name, Frame next) {
            this.functionName = name;
            this.next = next;
        }
    }

    private Frame top = null;

    public void push(String functionName) {
        top = new Frame(functionName, top);
    }

    public String pop() {
        if (isEmpty()) throw new RuntimeException("No active call");
        String name = top.functionName;
        top = top.next;
        return name;
    }

    public String peek() {
        if (isEmpty()) throw new RuntimeException("Empty stack");
        return top.functionName;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        CallStack stack = new CallStack();
        stack.push("main");
        stack.push("foo");
        System.out.println(stack.peek()); 
        System.out.println(stack.pop());  
    }
}
