package recursion;
/*theta(n) time and space. Although fn does constant work, but called n times and since it's recursion n+1 values
 * goes on stack becaz of fn call, If we use tail recursion, then space would be O(1)*/
public class PrintNTo1 {
    public static void main(String[] args) {
        printNto1(5);
    }

    private static void printNto1(int n) {
        if (n==0) return;
        System.out.println(n);
        printNto1(n-1);
    }
}
