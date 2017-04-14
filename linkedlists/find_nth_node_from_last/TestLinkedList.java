
public class TestLinkedList
{
    public static void addFirst(ListNode head, Integer e)
    {
        // Create a temporary node
        ListNode tmp = new ListNode(e);

        // Assuming head is dummy node
        // Assign head next to temporary next
        tmp.next = head.next;

        // Assign temporary node to head next
        head.next = tmp;
    }

    public static ListNode getLastNode(ListNode head)
    {
        ListNode current;

        // Assuming head is dummy node
        // Traverse to the end of the list
        // $$$ Need to check current.next != null, to preserve the last node
        // $$$ If not, current will be moved to null
        for(current = head.next; current.next != null; current = current.next) {}

        return current;
    }

    public static void display(ListNode head)
    {
        ListNode current;

        // Assuming head is dummy node
        // Traverse to the end of the list
        for(current = head.next; current != null; current = current.next) {
            System.out.print(current + "->");
        }
        System.out.println();
    }
}
