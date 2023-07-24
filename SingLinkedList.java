import java.net.http.HttpRequest;

/**
 * ClassName: LinkList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 尚硅谷-宋红康
 * @Create 2023/6/24 22:06
 * @Version 1.0
 */
public class SingLinkedList {
//    public static void main(String[] args) {
//        //测试
//        //创建结点
//        HeroNode hero1 = new HeroNode(1, "及时雨", "松江");
//        HeroNode hero2 = new HeroNode(2, "玉麒麟", "卢俊义");
//        HeroNode hero3 = new HeroNode(3, "智多星", "无用");
//        HeroNode hero4 = new HeroNode(4, "豹子头", "林冲");
//        //创建链表
////        SingLinkList singLinkList = new SingLinkList();
////        singLinkList.add(hero1);
////        singLinkList.add(hero2);
////        singLinkList.add(hero3);
////        singLinkList.add(hero4);
////
////        singLinkList.printNode();
//        System.out.println();
//
//        SingLinkList singLinkList2 = new SingLinkList();
//        singLinkList2.add2(hero1);
//        singLinkList2.add2(hero4);
//        singLinkList2.add2(hero2);
//        singLinkList2.add2(hero3);
//
//        singLinkList2.printNode();
//        System.out.println("修改后~~~~~");
//
//        //修改
//        HeroNode newNode = new HeroNode(2,"小尾巴","yuqil~");
//        singLinkList2.update(newNode);
//        singLinkList2.printNode();
//        //删除
//        System.out.println("删除后");
//        singLinkList2.delete(1);
//        singLinkList2.printNode();
//
//    }

}

//定义一个heroNode，每个heroNode就是一个结点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个结点

    //构造器
    public HeroNode(int nHo, String hName, String hNickName) {
        this.no = nHo;
        this.name = hName;
        this.nickName = hNickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';
    }
}
    //定义一个SingleLinkList 进行管理
    class SingLinkList{
        //先初始化一个头结点，头结点不动。
        private HeroNode head = new HeroNode(0,"","");
        public HeroNode getHead(){
            return head;//返回头结点
        }
        //添加结点
        public void add(HeroNode newnode){
            //当不考虑编号的顺序时，找到当前链表的最后结点，将最后结点的Next域指向新的
            //辅助指针temp
            HeroNode temp = head;
            //遍历找到最后
            while(true){
                //当temp.next==null,temp表示最后了
                if(temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            //跳出while,temp指向的是最后
            temp.next = newnode;
        }
        //第二种添加
        public void add2(HeroNode heronode){
            HeroNode temp = head;//头结点不能动，添加辅助结点
            //我们找的temp是位于添加位置的前一个结点，否则添加不了
            boolean flag = false;//标志添加的编号是否存在。
            while(true){
                if(temp.next == null){
                    break;
                }
                if(temp.next.no  > heronode.no){
                    break;
                }else if(temp.next.no == heronode.no){
                    flag = true;//编号存在
                  break;
                }
                temp = temp.next;
            }
            if(flag){
                //编号存在
                System.out.println("准备插入的数据" + heronode.no+" 已经存在\n");
            }else{
                //插入temp后面
                heronode.next = temp.next;
                temp.next = heronode;
            }


        }


        //修改:根据编号来修改，但编号不能改
        //1.根据newNode的no来修改
//        public void update(HeroNode newNode){
//            if(head.next == null){
//                System.out.println("链表为空");
//                return;
//            }
//            //修改
//            //辅助变量
//            HeroNode temp = head.next;
//            boolean flag = false;
//            while(true){
//                if(temp == null){
//                    break;//最后了
//
//                }
//                if(temp.no == newNode.no){
//                    //找到
//                    flag = true;
//                    break;
//                }
//                temp = temp.next;
//            }
//            //根据flag判断是否找到修改的结点
//            if(flag){
//                temp.name = newNode.name;
//                temp.nickName = newNode.nickName;
//            }else{
//                System.out.println("未找到 编号"+ newNode.no +"的结点");
//            }
//
//        }
        public void update(HeroNode newNode){
            if(head.next == null){
                System.out.println("链表为空");
                return;
            }
            //修改
            //辅助变量
            HeroNode temp = head;
            boolean flag = false;
            while(true){
                if(temp.next == null){
                    break;//最后了

                }
                if(temp.no == newNode.no){
                    //找到
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //根据flag判断是否找到修改的结点
            if(flag){
                temp.name = newNode.name;
                temp.nickName = newNode.nickName;
            }else{
                System.out.println("未找到 编号"+ newNode.no +"的结点");
            }

        }

        //删除
        //1.head不动，建立temp结点
        //2.利用temp.next.no和需要比较的结点.no
        public void delete(int no){
            HeroNode temp = head;
            boolean flag =false;
            while(true){
                if(temp.next == null){
                    break;
                }
                if(temp.next.no == no){
                    //找到了待删除结点的前一个temp
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                temp.next = temp.next.next;
            }else{
                System.out.printf("要删除的结点 %d 不存在\n",no);
            }

        }
        //遍历[打印]
        public void printNode(){
            if(head.next == null){
                System.out.println("空链表");
                return;
            }
            HeroNode temp = head.next;
            while(true){
                if(temp == null){
                    break;
                }
                System.out.println(temp.toString());
                temp = temp.next;
            }

        }

    }

