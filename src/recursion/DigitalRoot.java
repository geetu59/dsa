package recursion;

/*DigitalRoot of a number is the recursive sum of its digits until we get a single digit number.
 * Eg: n = 99999, 9+9+9+9=45, 4+5, 9 is output*/
public class DigitalRoot {
    public static void main(String[] args) {
        System.out.println(digitalRoot(9999));
    }

    private static int digitalRoot(int n) {
        if (n < 10) return n;
        //internal call will give you sum of digits on n and external call will give you further sum of sum if sum was more than one digit
        return digitalRoot(n % 10 + digitalRoot(n / 10));
    }
}
