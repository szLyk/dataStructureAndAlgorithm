package queue;


//构造环形队列
public class CircleArrayQueueDemo1 {

    public static void main(String[] args) {

        CircleArrayQueueDemo1 circleArrayQueueDemo = new CircleArrayQueueDemo1(6);
        circleArrayQueueDemo.addCircleArrayQueue(1);
        circleArrayQueueDemo.addCircleArrayQueue(2);
        circleArrayQueueDemo.addCircleArrayQueue(3);
        circleArrayQueueDemo.addCircleArrayQueue(4);
        circleArrayQueueDemo.addCircleArrayQueue(5);
        circleArrayQueueDemo.addCircleArrayQueue(6);
        circleArrayQueueDemo.addCircleArrayQueue(7);

        int i = circleArrayQueueDemo.takeCircleArrayQueue();
        System.out.println(i);
        circleArrayQueueDemo.addCircleArrayQueue(8);

        circleArrayQueueDemo.show();



    }

    int maxSize;
    int front;
    int rear;
    int[] CircleArrayQueue;

    public CircleArrayQueueDemo1(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        CircleArrayQueue = new int[maxSize];
    }

    //判断环形数组是否已经满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }


    public void addCircleArrayQueue(int nu) {

        if (isFull()) {
            System.out.println("队列已满！");
            return;
        }
        this.CircleArrayQueue[rear] = nu;
        rear = (rear + 1) % maxSize;
    }


    public int takeCircleArrayQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空！");
        }

        int value = CircleArrayQueue[front];

        front = (front + 1) % maxSize;

        return value;
    }

    // 求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }


    public void show(){
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, CircleArrayQueue[i % maxSize]);
        }
    }


}
