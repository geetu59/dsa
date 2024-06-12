package recursion;

/*Power of a number is reverse of the number, then find power of the number
 * Time and space: O(logn)
 * We are implementing it using Modular exponential method*/
public class PowerOfNumbers {
    public static void main(String[] args) {
        System.out.println(power(12, 21));
    }

    private static long power(int n, int r) {
        long mod = 1000000007;
        //only creating this var to make n from int to long
        long pow = n;
        long result = 1;
        /*if power is > 0 then we check if it is in even or odd
         * Eg: 6^128 -> (6*6)^64 -> (36*36)^32 and so on, so what we do is, we are diving exponent by 2 in every step and
         * hence it is r/2. And we multiply the number with the number eg: we'd 6, we multiplied it by 6, then we'd 36, we multiplied
         * it by 36 and so on, so we are doing that and mod so that it is printable. If we have odd power, let's say 6^5, then we can break
         * it to 6^4 and 6.*/
        while (r > 0) {
            if (r % 2 == 1) result = (result * pow) % mod;
            pow = (pow * pow) % mod;
            r = r / 2;
        }
        return result;
    }
}
