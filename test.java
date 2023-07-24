/**
 * ClassName: test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 尚硅谷-宋红康
 * @Create 2023/6/26 16:56
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "及时雨", "松江");
        HeroNode hero2 = new HeroNode(2, "玉麒麟", "卢俊义");
        HeroNode hero3 = new HeroNode(3, "智多星", "无用");
        HeroNode hero4 = new HeroNode(4, "豹子头", "林冲");
        SingLinkList singLinkList2 = new SingLinkList();
        singLinkList2.add2(hero1);
        singLinkList2.add2(hero4);
        singLinkList2.add2(hero2);
        singLinkList2.add2(hero3);
        singLinkList2.printNode();
        System.out.println("测试逆序打印~~~");
        linkList_test.reversePrint(singLinkList2.getHead());
//        System.out.println("++++++++原来的链表");
//        System.out.println("反转单链表");
//        linkList_test.reversetList(singLinkList2.getHead());
//        singLinkList2.printNode();


//        System.out.println(linkList_test.getLength(singLinkList2.getHead()));
//        HeroNode cur = linkList_test.findIndexNode(singLinkList2.getHead(),1);
//        System.out.println("cur"+cur);


    }
}
