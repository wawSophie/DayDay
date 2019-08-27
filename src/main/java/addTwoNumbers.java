
/**
 * Author:Sophie
 * Created: 2019/8/27
 */

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */

/**
 * 思路：整体思路，需要判断，哪个链表较长（>=），在较长的链表上进行修改，最后返回较长链表
 *      具体思路：1、判断两个链表哪个较长，定义较长链表为longlist，较短链表为shortlist，结果为result（=longlist）；
 *              2、遍历较短链表，定义本位值和进位值，本位值等于两链表当前结点之和+jw取余10，jw等于两链表当前结点之和+jw模10
 *              循环，直到短链表遍历结束
 *              3、去看长链表当前是否为null，也就是是否遍历结束，如果没结束，则本位值为长链表当前结点值+jw取余10，jw值为长链表当前链表结点值+jw模10
 *              循环，直到长链表结束
 *              4、到这里时，判断jw值是否为0，若不为0，则说明有进位，需要new新节点，将长链表的最后一个结点指向新节点，结束
 *              所以在此之前需要定义一个pre表示前结点的值
 */
public class addTwoNumbers {
    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int jw=0,bw=0,temp=0;
            ListNode longList=l1;
            ListNode shortList=l2;
            ListNode result=longList;
            ListNode pre=null;
            while (l2!=null){
                if (l1==null){
                    ListNode templist=longList;
                    longList=shortList;
                    shortList=templist;
                    result=longList;
                    break;
                }
                l1=l1.next;
                l2=l2.next;
            }
            while(shortList!=null){
                bw=(longList.val+shortList.val+jw)%10;
                temp=(longList.val+shortList.val+jw)/10;
                longList.val=bw;
                jw=temp;
                pre=longList;
                longList=longList.next;
                shortList=shortList.next;
            }
            while(longList!=null){
                bw=(longList.val+jw)%10;
                temp=(longList.val+jw)/10;
                longList.val=bw;
                jw=temp;
                pre=longList;
                longList=longList.next;
            }
            if (jw!=0){
                ListNode node1=new ListNode(jw);
                pre.next=node1;
            }
            return result;
        }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(9);
        ListNode listNode2=new ListNode(9);
        listNode.next=listNode2;
        ListNode listNode1=new ListNode(1);
        ListNode re=addTwoNumbers(listNode1,listNode);
        while (re!=null){
            System.out.print(re.val+",");
            re=re.next;
        }
    }
    }

