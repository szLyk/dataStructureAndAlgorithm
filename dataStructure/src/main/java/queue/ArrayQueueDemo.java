package queue;

import com.sun.jmx.remote.internal.ArrayQueue;

public class ArrayQueueDemo {

    public static void main(String[] args) {


    }

    int[] ArrayQueue;
    int front;
    int rear;
    int maxSize;


    //构造对象
    public ArrayQueueDemo(int size) {
        //定义指针  front：随着数据输出而改变; rear:随着数据输入而改变
        front = -1;
        rear = -1;
        maxSize = size;
        ArrayQueue = new int[size];

    }

    //添加队列的方法
    public void addQueue(int nu) {

        if (isFull()) {
            System.out.println("队列已满！");
            return;
        }
        rear++;
        this.ArrayQueue[rear] = nu;

    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //取出队列的方法
    public int takeQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列以空！");
        }
        front++;
        return ArrayQueue[front];
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < ArrayQueue.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, ArrayQueue[i]);
        }
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return ArrayQueue[front + 1];
    }

}
