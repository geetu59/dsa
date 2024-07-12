package recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        //tail recursive: when parent fn has nothing to do after child fn execution call completes
        System.out.println(fact(5, 1));
    }

    private static int fact(int n, int k) {
        if (n == 0 || n == 1) return k;
        return fact(n - 1, k * n);
    }

    private static int factorial(int n) {
        //if n=0, then it'll give stack overflow and hence n=0 case needs to be considered, we can ignore n==1 i.e. if (n == 0) return 1; is sufficient
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}
