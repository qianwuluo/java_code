import java.util.Stack;

/**
 * ClassName: linkList_test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 尚硅谷-宋红康
 * @Create 2023/6/26 16:50
 * @Version 1.0
 */
public class linkList_test {
    //求链表结点
    //方法：获取单链表的有效结点，不包括头结点
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int len = 0;
        //辅助变量,不包括头结点
        HeroNode cur = head.next;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }
    //查找单链表的倒数第K个结点【新浪面试】
    /**
     * 编写方法接受head结点，同时接受一个index，
     * index:倒数第index结点
     * 遍历
     * 得到链表的长度，从链表第一个开始遍历（长度-index）个
     * 找到就返回
     */
    public static HeroNode findIndexNode(HeroNode head,int index){
        if(head.next == null){
            return null;
        }
        //遍历
        int size = getLength(head);
        //第二次,遍历size - index
        //先做index校验
        if(index <= 0 || index > size){
            System.out.println("数据有误");
            return null;
        }
        HeroNode temp = head.next;//跳过头结点,for 循环定位
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;

        }
        return temp;

    }

/**
 * 链表反转：
 *  1.先定义一个reverseHead = new HeroNode();
 *  2.从头到尾遍历，每遍历一个结点，就将其取出，并放在新的链表的最前边
 *  3.原来的head.next = reverseHead.next
 *
 */

public static void reversetList(HeroNode head){
    //当前链表为空，或者只有一个结点，直接返回
    if(head.next == null){
        return;
    }
    //定义一个赋值指针，遍历原来的链表
    HeroNode cur = head.next;
    HeroNode next = null;//指向当前结点[cur]的下一个结点
    HeroNode reverseHead= new HeroNode(0,"","");
    //遍历原来的链表，并将其取出，并放在新链表的最前端
    while(cur != null){
        next = cur.next;//暂时当前结点的下一个结点
        cur.next = reverseHead.next;//将cur的下一个结点指向新的链表的最前端
        reverseHead.next = cur;//将cur 连接到新的上
        cur=next;
    }
    //将head.next指向reverseHead.next
    head.next = reverseHead.next;

}
/**
 * 从头到尾打印单链表：
 * 1.从尾到头先进行反转，然后进行遍历
 * 2.利用栈
 *
 */
//使用栈的方式实现逆序打印：
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;//空链表
        }
        //创建一个栈，将各个结点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有结点压入栈中
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        //打印栈的结点
        while (stack.size() >0){
            System.out.println(stack.pop());
        }
    }

}
