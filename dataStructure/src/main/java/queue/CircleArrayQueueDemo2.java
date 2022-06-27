package queue;

public class CircleArrayQueueDemo2 {

    public static void main(String[] args) {

        CircleArrayQueueDemo2 arrayQueueDemo = new CircleArrayQueueDemo2(8);
//        arrayQueueDemo.isEmpty();
//        arrayQueueDemo.isFull();
        arrayQueueDemo.addCircleArrayQueue(1);
        arrayQueueDemo.addCircleArrayQueue(2);
        arrayQueueDemo.addCircleArrayQueue(3);
        arrayQueueDemo.addCircleArrayQueue(4);
        arrayQueueDemo.addCircleArrayQueue(5);
        arrayQueueDemo.addCircleArrayQueue(6);
        int i = arrayQueueDemo.takeCircleArrayQueue();
        int i1 = arrayQueueDemo.takeCircleArrayQueue();
//        System.out.println(i1);
        arrayQueueDemo.addCircleArrayQueue(7);
        arrayQueueDemo.addCircleArrayQueue(8);
        arrayQueueDemo.addCircleArrayQueue(9);
        arrayQueueDemo.show();
        arrayQueueDemo.addCircleArrayQueue(10);
        System.out.println();
        arrayQueueDemo.show();
        arrayQueueDemo.addCircleArrayQueue(10);

    }

    private int front;
    private int rear;
    private int maxSize;
    private int size;
    int[] CircleArrayQueueDemo2;

    public CircleArrayQueueDemo2(int maxSize){
        this.maxSize = maxSize;
        CircleArrayQueueDemo2 = new int[maxSize];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull(){
        return size>= maxSize;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addCircleArrayQueue(int nu){

        if (isFull()){
            System.out.println("队列已满！");
            return;
        }
        CircleArrayQueueDemo2[rear] = nu;

        if (rear == maxSize -1){
            rear = 0;
        }else {
            rear++;
        }

        size++;
    }

    public int takeCircleArrayQueue(){

        if (isEmpty()){
            throw new RuntimeException("队列已空！");
        }

        int value = CircleArrayQueueDemo2[front];
        //边界情况
        if (front == maxSize - 1) {
            front = 0;
        }
        size--;
        front++;
        return value;
    }

    public void show(){
        for (int i = front; i < front+size; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, CircleArrayQueueDemo2[i % maxSize]);
        }
    }


}
