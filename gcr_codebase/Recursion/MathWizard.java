/*
Build a 'Math Wizard' utility class: isPrime(n), factorial(n) using
iteration, fibonacci(n), gcd(a,b), lcm(a,b), and power(base, exp).
Overload factorial to also accept double. Demonstrate scope
differences between local and instance variables.

if(n<=1) return false;


*/

public class MathWizard {

    public static void main(String[] args) {
        MathWizard wizard = new MathWizard();

        System.out.println("Is 7 prime? " + wizard.isPrime(7));
        System.out.println("Factorial of 5: " + wizard.factorial(5));
        System.out.println("Factorial of 5.0: " + wizard.factorial(5.0));
        System.out.println("Fibonacci of 6: " + wizard.fibonacci(6));  
        System.out.println("GCD of 6 and 10: "+ gcd(6,10));
        System.out.println("Lcm of 6 and 10: "+lcm(6,10));
        System.out.println("Power base = 2 and exp = 4: "+power(2,4));   
    }

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        return fibonacciHelper(n, a, b);
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public double power(double base, int exp) {
        double result = 1.0;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

}    