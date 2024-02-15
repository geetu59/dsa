package stack;

import java.util.ArrayList;
/*Undeflow overflow might not be handled properly, dynamic resizing issue is solved O(1) time*/
public class ArrayListStack {
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        ArrayListStack arrayListStack = new ArrayListStack();
        arrayListStack.push(1);
        arrayListStack.push(1);
        arrayListStack.push(1);
        System.out.println(arrayListStack.peek());
        arrayListStack.pop();
        System.out.println(arrayListStack.size());
        System.out.println(arrayListStack.isEmpty());
    }

    public void push(int x) {
        list.add(x);
    }

    public int peek() {
        return list.get(list.size() - 1);
    }

    public int pop() {
        int x = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return x;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
