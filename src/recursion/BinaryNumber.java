package recursion;

/*Print binary representation of number*/
public class BinaryNumber {
    public static void main(String[] args) {
        binary(13);
    }

    private static void binary(int n) {
        if (n == 0) return;
        binary(n / 2);
        System.out.print(n % 2);
    }
}
