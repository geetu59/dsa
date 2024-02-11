package linkedlist.singlell;

import java.util.HashMap;

/*Given a ll with next node and random node, creating a clone of this list means whatever operations perform on any of the list shouldnt effect other
 * Sol 1: theta(n) time and space using hashmap, search and insert takes constant time in hashmap
 * Sol 2: theta(n) time O(1) space create clone nodes after the actual node in same list, do things in same split and then get it*/
public class ClonellWithRandomPtr {
    public static void main(String[] args) {
        RandomNode head = new RandomNode(10);
        RandomNode node1 = new RandomNode(5);
        RandomNode node2 = new RandomNode(20);
        RandomNode node3 = new RandomNode(15);
        RandomNode tail = new RandomNode(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = tail;
        head.random = node2;
        node1.random = node3;
        node2.random = head;
        node3.random = node2;
        tail.random = node3;

        //SOl 1:
        RandomNode node = clonell(head);

        //SOl 2:
        RandomNode randomNode = cloneLinkedList(head);
    }

    private static RandomNode cloneLinkedList(RandomNode head) {
        //Step 1: Insert cloned node after each node
        RandomNode curr = head;
        while (curr != null) {
            RandomNode clone = new RandomNode(curr.data);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }
        //Step 2: Set random of cloned nodes, we cant do it as part of first step becaz we need to first create nodes to set random
        curr = head;
        while (curr != null) {
            curr.next.random = curr.random == null ? null : curr.random.next; //curr's random may not point to any other node
            curr = curr.next.next;
        }
        //Step 3: Segregate present and cloned nodes
        curr = head;
        RandomNode head2 = head.next;
        RandomNode clone = head.next;
        //need not to put clone condition as clone will be present after curr
        while (curr != null) {
            curr.next = curr.next.next; //curr.next is cloned node, it'll always be there and hence no null check
            clone.next = clone.next == null ? null : clone.next.next;
            curr = curr.next;
            clone = clone.next;
        }
        return head2;
    }

    private static RandomNode clonell(RandomNode head) {
        //Store node of ll as key and create new nodes of new list as value
        HashMap<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode curr = head;
        while (curr != null) {
            map.put(curr, new RandomNode(curr.data));
        }
        //traverse the list and first get the replica of new node, node.next would be curr.next and node.random would be curr.random
        curr = head;
        while (curr != null) {
            RandomNode clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}

class RandomNode {
    int data;
    RandomNode next;
    RandomNode random;

    public RandomNode(int data) {
        this.data = data;
    }
}
