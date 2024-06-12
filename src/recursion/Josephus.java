package recursion;

/*Josephus problem:
 * There are n people standing in a circle, we need to kill kth person in every iteration and we have to return position of survivor.
 * Eg: jos(5,3), index starts from 0, 2nd position person will be killed in first iteration, then 0th, 4th, 1st, so left one is 3rd and hence the output
 * Now we know, n decreases everytime i.e. in every iteration 1 person is killed and hence n decreases by 1, so recursive call will be jos(n-1,k) and
 * at the end, only 1 person is left, so we return 0 but what we need to keep in mind is that when making recursive calls, everytime value starts from 0,
 * meaning, initially we'd 5 people, so index is 0 1 2 3 4, one out of them is killed, then index is 0 1 2 3 even if person at 2nd position was killed,
 * we are not starting from 3rd position, we start from 0, so we have to try finding a relation.
 * jos(5,3) calls jos(4,3)
 * 3 is expected     0
 * 4                 1
 * 0                 2
 * 1                 3 This table basically shows that 0th person is actually 3rd person, 4th person in jos(5,3) call is 1st person in jos(4,3) call
 * So, we observe that whatever is the result we do (result+k)%n to get final output
 * Time: theta(n) T(n)=T(n-1)+c
 * Check Josephus problem video in Recursion sec of GFG for better understanding*/
public class Josephus {
    public static void main(String[] args) {
        //index start from 0
        System.out.println(josephus(5, 3));
        //index starts from 1
        System.out.println(jos(5, 3));
    }

    private static int jos(int n, int k) {
        return josephus(n, k) + 1;
    }

    private static int josephus(int n, int k) {
        if (n == 1) return 0;
        else return (josephus(n - 1, k) + k) % n;
    }
}
