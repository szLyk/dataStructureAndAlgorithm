package linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {

    }


}

class DoubleLinkedList {

    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    // 返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    public void add(HeroNode2 heroNode) {

        HeroNode2 temp;

        temp = head;


        while (true) {

            if (temp.next == null) {

                break;
            }

            temp = temp.next;

        }

        temp.next = heroNode;
        heroNode.pre = temp;


    }


    public void update(HeroNode2 heroNode) {

        boolean flag = false;
        HeroNode2 temp;

        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        temp = head.next;

        while (true) {

            if (temp == null) {
                break;
            }

            if (temp.no == heroNode.no) {

                flag = true;
                break;
            }

            temp = temp.next;

        }

        if (flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else { // 没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.no);
        }


    }

    public void delete(int no) {
        HeroNode2 temp;
        boolean flag = false;

        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        temp = head.next;

        while (true) {

            if (temp == null){
                break;
            }

            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }

        // 判断flag
        if (flag) { // 找到
            // 可以删除
            // temp.next = temp.next.next;[单向链表]
            temp.pre.next = temp.next;
            // 这里我们的代码有问题?
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }


    }


}


// 定义HeroNode2 ， 每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一个节点, 默认为null
    public HeroNode2 pre; // 指向前一个节点, 默认为null
    // 构造器

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}