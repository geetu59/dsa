package array;

import java.util.ArrayList;
import java.util.Vector;

public class ArrayImplementation {
    public static void main(String[] args) {
        int[] staticArray1 = new int[5];
        int n=10;
        int[] staticArray2 = new int[n];
        staticArray1[0]=1;
        staticArray1[1]=2;
        staticArray1[2]=3;
        staticArray1[3]=4;
        staticArray1[4]=5;
        for (int i = 0; i < staticArray1.length; i++) {
            System.out.println(staticArray1[i]);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        //ArrayList<Integer> arrayList = new ArrayList<>(5); //to tell initial size or you can even mention collection
        arrayList.add(1);
        arrayList.add(2);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }
        System.out.println(vector.capacity() + "   "+vector.size());
    }
}
