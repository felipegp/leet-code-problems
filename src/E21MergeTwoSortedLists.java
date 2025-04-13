public class E21MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(4);
        ListNode node4 = new ListNode(2, node5);
        ListNode list1 = new ListNode(1, node4);

        ListNode node2 = new ListNode(4);
        ListNode node1 = new ListNode(3, node2);
        ListNode list2 = new ListNode(1, node1);

        ListNode result = mergeTwoLists(list1, list2);

        StringBuilder resultStr = new StringBuilder();

        while (result != null) {
            resultStr.append(result.val);

            if (result.next != null) {
                resultStr.append(",");
            }

            result = result.next;
        }

        System.out.println(resultStr);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = null;
        ListNode mergedHead = null;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                merged = pointToNext(merged, list2);
                list2 = list2.next;
            } else if (list2 == null) {
                merged = pointToNext(merged, list1);
                list1 = list1.next;
            } else {
                if (list1.val < list2.val) {
                    merged = pointToNext(merged, list1);
                    list1 = list1.next;
                } else {
                    merged = pointToNext(merged, list2);
                    list2 = list2.next;
                }
            }

            if (mergedHead == null) {
                mergedHead = merged;
            }
        }

        return mergedHead;
    }

    private static ListNode pointToNext(ListNode merged, ListNode node) {
        if (merged == null) {
            merged = node;
        } else {
            merged.next = node;
            merged = merged.next;
        }

        return merged;
    }
}
