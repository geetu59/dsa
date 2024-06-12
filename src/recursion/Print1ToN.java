package recursion;

/*theta(n) time and space. Although fn does constant work, but called n times and since it's recursion n+1 values
 * goes on stack becaz of fn call*/
public class Print1ToN {
    public static void main(String[] args) {
        print1ToN(5);
    }

    private static void print1ToN(int n) {
        if (n == 0) return;
        print1ToN(n - 1);
        System.out.println(n);
    }
}
