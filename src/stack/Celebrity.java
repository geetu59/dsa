package stack;

import java.util.Stack;

/*A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
Return the index of the celebrity, if there is no celebrity return -1. a[i][i]=0 always. a[i][j]=1, means ith person knows jth person.
Sol 1: O(N*N)
Sol 2: O(N)*/
public class Celebrity {
    public static void main(String[] args) {
        int M[][] = {
                {0, 1, 1},
                {0, 0, 0},
                {0, 1, 0},
        };
        System.out.println(celebrity1(M, 3));
        System.out.println(celebrity2(M, 3));
    }

    private static int celebrity2(int[][] M, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        } //push all indexes in stack
        while (stack.size() > 1) { // pop 2 elements out of stack
            int person1 = stack.pop();
            int person2 = stack.pop();
            if (M[person1][person2] == 1) { //means p1 knows p2 and hence p1 cannot be celebrity
                stack.push(person2);
            } else { //p1 doesnt know p2, p2 cant be celebrity becaz celebrity is known by all
                stack.push(person1);
            }
        }
        int desiredCeleb = stack.pop();
        boolean isCeleb = true;
        for (int i = 0; i < n; i++) {
            if (i != desiredCeleb && (M[i][desiredCeleb] != 1 || M[desiredCeleb][i] != 0)) {
                //in desiredCeleb row, all elements should be 0(as it should not know anyone) and in desiredCeleb col, all elements should be 1(all should know him)
                isCeleb = false;
            }
        }
        return isCeleb ? desiredCeleb : -1;
    }

    static int celebrity1(int M[][], int n) {
        for (int i = 0; i < n; i++) {
            boolean knowsSomeone = false;
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) { // if ith person knows jth person, then ith person cannot be celebrity. As celebrity will not know anyone
                    knowsSomeone = true;
                    break;
                }
            }
            //if knowsSomeone=false that means ith person doesn't know anyone. But we have to make sure that other people knows ith person.
            //So, we will check ith col, if it's 0 that means other people dont know him
            if (!knowsSomeone) {
                boolean isCeleb = true;
                for (int k = 0; k < n; k++) {
                    if (i != k && M[k][i] == 0) {
                        isCeleb = false;
                        break;
                    }
                }
                if (isCeleb) return i;
            }
        }
        return -1;
    }
}
