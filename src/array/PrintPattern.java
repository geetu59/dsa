package array;

import java.util.ArrayList;
import java.util.List;

public class PrintPattern {
    public static void main(String[] args) {
        System.out.println(pattern(16));
    }

    private static List<Integer> pattern(int n) {
        int t = n;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        int i = 0;
        while (n > 0) {
            list.add(n -= 5);
            i++;
        }
        while (list.get(i)!=t){
            list.add(n += 5);
            i++;
        }
        return list;
    }
}
