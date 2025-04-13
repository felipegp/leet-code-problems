import java.util.ArrayList;
import java.util.List;

public class E876MiddleLinkedList {

    public static void main(String[] args) {

        ListNode node5 = new ListNode(6);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        ListNode result = middleNode(head);

        System.out.println(result);
    }

    private static ListNode middleNode(ListNode head) {
        List<ListNode> arrayCopy = new ArrayList();

        while (head != null) {
            arrayCopy.add(head);
            head = head.next;
        }

        return arrayCopy.get(arrayCopy.size() / 2);
    }
}

