package recursion;

/*Find log of n with base 2. If number is not power of 2 then it'll given floor of logn
 * Eg: log17, 4 is the output
 * If you want to calculate log with any base, then beside of doing n/2, make it n/(base) you want.*/
public class LogWithBase2 {
    public static void main(String[] args) {
        System.out.println(log(17));
    }

    private static int log(int n) {
        if (n == 1) return 0;
        else return 1 + log(n / 2);
    }
}
