package linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {

        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "XXXX");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        singleLinkedList.list();
        System.out.println();

        HeroNode hero5 = new HeroNode(3, "吴用", "智多星");
        singleLinkedList.update(hero5);
        singleLinkedList.list();

    }


}


class SingleLinkedList {

    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

//    public void add(HeroNode heroNode) {
//
//        HeroNode temp = head;
//        while (true) {
//            //找到链表的最后
//            if (temp.next == null) {
//                break;
//            }
//            //如果没有找到最后, 将将 temp 后移
//            temp = temp.next;
//        }
//        //当退出 while 循环时，temp 就指向了链表的最后 //将最后这个节点的 next 指向 新的节点
//        temp.next = heroNode;
//
//    }

    //有序插入英雄
    public void addByOrder(HeroNode heroNode) {

        HeroNode temp = head;
        boolean flag = false; // flag 标志添加的编号是否存在，默认为 false

        while (true) {

            if (temp.next == null) {
                break;
            }

            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }

            temp = temp.next; //后移，遍历当前链表
        }

        //判断 flag 的值
        if (flag) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp 的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }


    }

    public void update(HeroNode heroNode) {
        HeroNode temp;
        boolean flag = false;


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
        } else { //没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.no);
        }


    }

    public void delete(int no) {


        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        boolean flag = false;
        HeroNode temp = head.next;

        while (true) {

            if (temp.next == null) { //已经到链表的最后
                break;
            }

            if (temp.no == no) {
                flag = true;
                break;
            }

            temp = temp.next;

            //判断 flag
            if (flag) { //找到可以删除
                temp.next = temp.next.next;
            } else {
                System.out.printf("要删除的 %d 节点不存在\n", no);
            }


        }

    }

    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp); //将 temp 后移， 一定小心
            temp = temp.next;
        }
    }


    public void updateLinkedList(HeroNode heroNode){

        HeroNode temp;
        boolean flag = false;

        if (head.next == null){
            System.out.println("链表为空！");
            return;
        }

        temp = head.next;

        while (true){

            if (temp.next == null){
                break;
            }

            if (temp.no == heroNode.no){
                flag = true;
                break;
            }

            temp = temp.next;


        }

        if (flag){
            temp.nickname = heroNode.nickname;
            temp.name = heroNode.name;
        }else {
            System.out.printf("要更新的 %d 节点不存在\n", heroNode.no);
        }




    }


}


//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }




}
