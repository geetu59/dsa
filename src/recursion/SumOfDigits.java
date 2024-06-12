package recursion;
/*Sum of digits of a no
* Eg: 123, 1+2+3*/
public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(123 ));
    }

    private static int sumOfDigits(int n) {
        if (n==0) return 0;
        return n%10 + sumOfDigits(n/10);
    }
}
