
import java.util.Random;

public class FindKthFromEnd
{

    // Calculate the size of the list by,
    //     traversing the entire list (Time Complexity = n)
    // Then traverse to the position from
    //      start to the required positition (size - k)  (Time complexity = n)
    //
    // Time complexity O(2 * n) =~ O(n)
    public static ListNode findKthFromEnd1(ListNode head, int k)
    {
        int size = 0;
        ListNode current;

        // head node is dummy node
        // Calculate the size of list
        for(current = head.next; current != null; current = current.next)
            ++size;

        // head node is dummy node
        // Start from next node
        //
        // dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null
        // size = 5
        // 
        // k = 2, element = 3
        // size - k = 5 - 2 = 3
        //
        int i = 1;
        current = head.next;
        while (i++ <= (size - k)) {
            current = current.next;
        }

        return current;
    }


    // Create first and second pointers pointing to head node
    // Moved the second pointer to the kth position.
    // 
    // From there move first and second pointers by each step
    // till the seond pointer reaches end
    //
    // List: dummy -> 5 -> 4 -> 3 -> 2 -> 1 -> null
    // Pos : 0     -> 1 -> 2 -> 3 -> 4 -> 5 
    //
    // k = 2
    //
    // first = second = dummy
    // second = 2
    //
    // While loop 1: first = 1, second = 3
    // While loop 2: first = 2, second = 4
    // While loop 3: first = 3, second = 5
    // While loop 4: first = 4, second = null
    //
    public static ListNode findKthFromEnd2(ListNode head, int k)
    {
        ListNode first = head, second = head;

        // head node is dummy node
        // Take the second to the node with kth position from starting
        for(int i = 1; i <= k; i++) {
            second = second.next;
        }

        // Traverse list till the second pointer reaches to the end of the list
        // Move farword first pointer each time to second pointer moves farword
        while(second != null) {
            first = first.next;
            second = second.next;
        }

        return first;
    }


    public static void main(String[] args)
    {
        Random r = new Random(100);
        int n = Integer.parseInt(args[0]);

        ListNode head = new ListNode();
        for(int i = 1; i <= n; ++i) {
            TestLinkedList.addFirst(head, r.nextInt(n) + 1);
        }

        System.out.println("Data generation complete");
        TestLinkedList.display(head);

        //long start = System.currentTimeMills();
        ListNode res1 = FindKthFromEnd.findKthFromEnd1(head, 5);
        ListNode res2 = FindKthFromEnd.findKthFromEnd2(head, 5);
        System.out.println(res1);
        System.out.println(res2);
    }
}
