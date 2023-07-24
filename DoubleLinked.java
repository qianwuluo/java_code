/**
 * ClassName: DoubleLinked
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 尚硅谷-宋红康
 * @Create 2023/7/4 22:27
 * @Version 1.0
 */
public class DoubleLinked {
    public static void main(String[] args) {

    }

    //创建双向链表的类
    class HeroNode2 {
        public int no;
        public String name;
        public String nickName;
        public HeroNode2 pre;
        public HeroNode2 next;//指向下一个结点

        //构造器
        public HeroNode2(int nHo, String hName, String hNickName) {
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

    class DoubleLinkedList {
        private HeroNode2 head = new HeroNode2(0, "", "");

        public HeroNode2 getHead() {
            return head;//返回头结点
        }

        //遍历双向链表
        public void printNode() {
            if (head.next == null) {
                System.out.println("空链表");
                return;
            }
            HeroNode2 temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp.toString());
                temp = temp.next;
            }

        }

        //添加
        public void add(HeroNode2 newnode) {
            //当不考虑编号的顺序时，找到当前链表的最后结点，将最后结点的Next域指向新的
            //辅助指针temp
            HeroNode2 temp = head;
            //遍历找到最后
            while (true) {
                //当temp.next==null,temp表示最后了
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            //跳出while,temp指向的是最后
            temp.next = newnode;
            newnode.pre = temp;

        }
        //修改:和单链表几乎一样，只是结点的类型改成了，heronode2
        public void update(HeroNode2 newNode){
            if(head.next == null){
                System.out.println("链表为空");
                return;
            }
            //修改
            //辅助变量
            HeroNode2 temp = head;
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
        //删除：可以直接找到要删除的结点，找到后自我删除即可
        public void delete(int no){
            //判断当前链表是否为空:
            if(head.next == null){
                System.out.println("链表为空，禁止删除");
                return;
            }
            HeroNode2 temp = head.next;
            boolean flag =false;//是否有这个结点
            while(true){
                if(temp == null){
                    break;
                }
                if(temp.no == no){
                    //找到了待删除结点的前一个temp
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                temp.pre.next = temp.next;
                if(temp.next != null) {
                    temp.next.pre = temp.pre;//有风险，如果是最后的结点，就必须要执行这一句，否则会出现空指针
                }
            }else{
                System.out.printf("要删除的结点 %d 不存在\n",no);
            }

        }
    }
}
