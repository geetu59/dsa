package recursion;
/*Sum of n natural nos
* theta(N) time and space(having fn call in stack is considered as aux space)*/
public class SumOfNaturalNos {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }

    private static int sum(int n) {
        if (n == 0) return 0;
        return n + sum(n - 1);
    }
}
