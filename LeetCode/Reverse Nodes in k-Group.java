
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class Solution {
	public static ListNode reverseKGroup(ListNode head, int k) {
		int size = 0;
		ListNode cur = head, next = head.next, prev = null, before = null, prevBefore;
		boolean flag = false;
		// o(size)
		while (cur != null) {
			size++;
			cur = cur.next;
		}

		cur = head;
		// o((size/k)*k)=o(size)
		for (int i = 0; i + k <= size; i += k) {
			prevBefore = before;
			before = cur;
			for (int j = 0; j < k; j++) {
				next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
				if (j == k - 1 && !flag) {
					head = prev;
					flag = true;
				}
				if (j == k - 1 && i != 0)
					prevBefore.next = prev;

			}
		}
		if (size % k != 0)
			before.next = cur;
		else
			before.next = null;

		return head;
	}
}
