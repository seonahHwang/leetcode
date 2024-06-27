package Milla.LinkedList;


/*
* Before solving this problem, We need to remove the nth node from the end of the list. Is that right?
* * Edge case
* : And let me check to make sure this problem, If the list has only one element, should I return null?
*
* Brainstorm
* I'm going to calculate the length of the list first, then identify the node to remove.
* Handle edge cases like removing the head ror the last node in the list.
*
* * 뒤에서 n번째인 원소를 제거해야하는 문제인데, 뒤에서부터 탐색을 할 수 없으니
 * 전체 길이를 구하고 거기서 n을 빼준 다음, 그 뺀 값 만큼 앞에서부터 탐색해서 원소를 찾고,
 * 삭제해야하므롤 이전의 원소의 next에 현재의 next 값을 넣어준다.
 *
* Plan
* Let me explain my plan.
* First, I'm going to calculate the length of the linked list.
* Second, Check if the head node needs to be removed.
* Third, Find the node just befroe the one th be romved.
* and remove the nth node from the end.
*
* TC : It will take O(n) time complexity. I'm going to go through entire list to find its length.
* SC : it going to be O(1). Becasue I'm not gonna use another linear data structure. I'll just use some Nodes.
*
* */
public class RemoveNodeFromEndofLinkedList {
    public static void main(String[] args) {
//        ListNode node = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5)))));
        ListNode node = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4))));
        //1,2,3,4,5,6,7,8,9,10, 7
//        ListNode node = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5,new ListNode(6,
//                new ListNode(7,new ListNode(8,new ListNode(9,new ListNode(10))))))))));
//        ListNode node = new ListNode(1,new ListNode(2));
//        ListNode node = new ListNode(5);

        ListNode node2 = removeNthFromEnd(node, 2);

        while (node2 != null){
            System.out.println(node2.val);
            node2 = node2.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode cur = head;
        ListNode res = cur;
        int len = 0;

        //calculate the length of the linked list
        while (fast != null){
            fast = fast.next;
            len++;
        }

        //If the length is equal to n, It means I need to remove the head node.
        //So just move on next node and return it.
        if(len == n){
            res = res.next;
            return res;
        }

        //Iterate to the node just before the one we weant to remove
        int curIdx = 1;
        while (cur != null){ //Traverse the list until the current node is null
            if(curIdx == len - n){ //check if the current index is the node before the one to be removed.
                // Remove the nth node from the end
                if(cur.next.next == null) cur.next = null; //if the next node is the last node, remove the last node by setting the next pointer to null
                else {
                    cur.next = cur.next.next; //link the currenet node to the node after the next
                }
                break;
            }
            cur = cur.next; //move to the next node
            curIdx++; //Increment the current index
        }

        return res;
    }
}
