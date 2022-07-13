package hashtab;

import java.util.Arrays;

public class HashTabDemo {
    public static void main(String[] args) {


        EmpLinkedList empLinkedList = new EmpLinkedList(10);
        Emp emp1 = new Emp(10, "Jack");
        Emp emp6 = new Emp(100, "Black");
        Emp emp2 = new Emp(2, "Tom");
        Emp emp3 = new Emp(1000, "Mark");
        Emp emp4 = new Emp(19, "Mike");
        Emp emp5 = new Emp(119, "Amy");
        Emp emp7 = new Emp(119, "Air");
        Emp emp8 = new Emp(10, "Jim");

        empLinkedList.add(emp1);
        empLinkedList.add(emp2);
        empLinkedList.add(emp3);
        empLinkedList.add(emp4);
        empLinkedList.add(emp5);
        empLinkedList.add(emp6);
        empLinkedList.add(emp7);
        empLinkedList.add(emp8);

        empLinkedList.update(emp7);
        empLinkedList.update(emp8);
        empLinkedList.show();
    }
}


class Emp {
    int id;
    String name;
    Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

//写的有点繁琐 待优化
class EmpLinkedList {

    Emp[] list;
    int max;
    Emp temp;

    public EmpLinkedList(int max) {
        this.max = max;
        list = new Emp[max];
    }


    public void add(Emp node) {

        int point = (node.id % max);

        if (list[point] == null) {
            list[point] = node;
            return;
        }

        if (list[point].next == null) {

            if (list[point].id == node.id) {
                System.out.println("id:" + node.id + "已经存在！添加失败！");
                return;
            }

            list[point].next = node;
            return;
        }

        temp = list[point];

        if (isExist(temp.id, node.id)) {
            return;
        }

        while (temp.next != null) {
            temp = temp.next;

            if (isExist(temp.id, node.id)) {
                return;
            }
        }


        temp.next = node;
    }

    public void show() {

        for (int i = 0; i < list.length; i++) {
            temp = list[i];

            while (temp != null) {
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }
    }

    public Boolean isExist(int tempId, int id) {

        if (tempId == id) {
            System.out.println("id:" + id + "已经存在！添加失败！");
        }
        return tempId == id;
    }

    public void update(Emp emp) {

        int point = emp.id % 10;

        if (list[point] == null) {
            System.out.println("id:" + emp.id + "不存在！更新失败！");
            return;
        }

        if (list[point].id == emp.id) {
            list[point].name = emp.name;
            System.out.println("更新成功！" + emp.toString());
            return;
        }

        temp = list[point];

        while (temp.next != null) {

            if (temp.next.id == emp.id) {
                temp.next.name = emp.name;
                System.out.println("更新成功！" + emp.toString());
                return;
            }
            temp = temp.next;
        }

        System.out.println("id:" + emp.id + "不存在！更新失败！");

    }

    public void delete(int id) {
        int point = id % 10;

        if (list[point] == null) {
            System.out.println("id:" + id + "不存在！删除失败！");
            return;
        }

        temp = list[point];

        if (temp.id == id) {
            if (temp.next == null) {
                list[point] = null;
                System.out.println("id:" + id + "存在！删除成功！");
            } else {
                list[point] = temp.next;

            }
            return;
        }

        while (true) {

            if (temp.next != null) {
                

            }

        }


    }
}

