package recursion;
/*Find n to the power p, O(p) time and space*/
public class PowerOfANumber {
    public static void main(String[] args) {
        System.out.println(power(11, 11));
    }

    static long power(int n, int p) {
        if (p == 0) return 1;
        return n * power(n, p - 1);
    }
}
