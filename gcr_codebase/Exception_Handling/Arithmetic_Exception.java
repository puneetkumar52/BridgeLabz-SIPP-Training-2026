public class Arithmetic_Exception {
    // public static void main(String[] args) {
        // int a = 9;
        // int b = 0;

        // try {
        //     int c = a / b;
        //     System.out.println(c);
        // } 
        // catch (ArithmeticException e) {
        //     System.out.println("Arithmetic Exception Occurred: " + e);
        // }

        static void method1() {
            try{
                ProductService.calculateTotal();
            }
            catch (fileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        static void method2() {
            Scanner sc = new Scanner(System.in);
            try{
                int x= sc.nextInt();
            }
            finally{
                scan.close();
            }
            System.out.println("Method");
        }
    }
}