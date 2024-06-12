package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(8));
    }

    private static int fibonacci(int n) {
//        if (n==0) return 0;
//        if (n==1) return 1;
        if (n==0 || n==1) return n; //just optimised way beside of writing 2 ifs
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
