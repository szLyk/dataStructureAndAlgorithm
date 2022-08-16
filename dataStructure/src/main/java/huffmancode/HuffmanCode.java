package huffmancode;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String context = "i like like like java do you like a java and you";
        byte[] bytes = context.getBytes();
        byte[] zip = zip(bytes);

        String s = unZip(zip);
        System.out.println(s);


    }


    public static String toBitString(boolean isLast,byte b,int lastLength){
        int temp = b;

        if (b>=0){
            temp |= 512;
        }

        String s = Integer.toBinaryString(temp);
        String substring;

        if (isLast){
            substring = s.substring(s.length()-8);
        }else {
            substring = s.substring(s.length() - lastLength);

        }
        return substring;

    }

    public static String unZip(byte[] bytes){

        HashMap<String, Byte> stringByteHashMap = new HashMap<>();
        Iterator<Byte> iterator = huffmanCodes.keySet().iterator();
        while (iterator.hasNext()){
            Byte next = iterator.next();
            String s = huffmanCodes.get(next);
            stringByteHashMap.put(s,next);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bytes.length-1; i++) {

            byte intByte = bytes[i];
            boolean isLast = (i==bytes.length-2);

            sb.append(toBitString(!isLast, intByte, bytes[bytes.length-1]));
        }

        String temp = sb.toString();
        System.out.println("temp: "+temp);
        int count=0;
        String unzip = "";

        for (int i = 0; i <= temp.length();i++) {

            if (stringByteHashMap.containsKey(temp.substring(count,i))){
                Byte aByte = stringByteHashMap.get(temp.substring(count,i));
                char c = (char)aByte.byteValue();
                count = i;
                unzip += String.valueOf(c);
            }

        }





        return unzip;
    }


    public static byte[] zip(byte[] bytes){
        List<Node> nodeList = getNodeList(bytes);
        Node huffmanTree = createHuffmanTree(nodeList);
        getCodes(huffmanTree);
        return zip(huffmanCodes,bytes);
    }


    public static byte[] zip(Map<Byte,String> huffmanCodes,byte[] bytes){
        StringBuilder huffmanCodeStringBuilder = new StringBuilder();

        for (byte b:bytes){
            String s = huffmanCodes.get(b);
            huffmanCodeStringBuilder.append(s);
        }

        System.out.println("压缩后："+huffmanCodeStringBuilder);
        int len = huffmanCodeStringBuilder.length();
        byte[] bytesForHuffman;
        int index = 0;

        byte lastLength = 0;


        if (len % 8 ==0){
            bytesForHuffman = new byte[(len / 8)+1];
        }else {
            bytesForHuffman = new byte[(len / 8)+2];
            lastLength = (byte) (len % 8);
//            System.out.println("lastLength: "+lastLength);
        }

        String substring;


        for (int i=0;i<len;i+=8){
            if (i+8 > len){
                substring = huffmanCodeStringBuilder.substring(i);
//                System.out.println("最后一位: "+substring);

            }else {
                substring = huffmanCodeStringBuilder.substring(i,i+8);
            }

            bytesForHuffman[index] = (byte)Integer.parseInt(substring,2);
            index++;

        }

        bytesForHuffman[index] = lastLength;

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytesForHuffman.length-1; i++) {
            stringBuffer.append(bytesForHuffman[i]+"\t");
        }

        System.out.println("bytesForHuffman : "+stringBuffer);


        return bytesForHuffman;
    }


    //生成赫夫曼树对应的赫夫曼编码
    //思路:
    //1. 将赫夫曼编码表存放在 Map<Byte,String> 形式
    //   生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
    static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
    //2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    public static Map<Byte,String> getCodes(Node root){
        if (root == null){
            return null;
        }
        //处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        //处理root的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    public static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code 加入到 stringBuilder2
        stringBuilder2.append(code);
        if(node != null) { //如果node == null不处理
            //判断当前node 是叶子结点还是非叶子结点
            if(node.data == null) { //非叶子结点
                //递归处理
                //向左递归
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else { //说明是一个叶子结点
                //就表示找到某个叶子结点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }

    }

    //将数据转化为 byte数组
    public static List<Node> getNodeList(byte[] bytes){

        HashMap<Byte, Integer> byteIntegerHashMap = new HashMap<>();
        ArrayList<Node> nodes = new ArrayList<>();

        for (byte aByte : bytes) {
            byteIntegerHashMap.merge(aByte, 1, Integer::sum);
        }

        Iterator<Byte> iterator = byteIntegerHashMap.keySet().iterator();
        while (iterator.hasNext()){
            Byte next = iterator.next();
            nodes.add(new Node(next,byteIntegerHashMap.get(next)));
//            System.out.println(next+":"+byteIntegerHashMap.get(next));
        }

        return nodes;
    }


    public static Node createHuffmanTree(List<Node> nodeList){

        while (nodeList.size()>1){
            Collections.sort(nodeList);

            Node left = nodeList.get(0);
            Node right = nodeList.get(1);

//            System.out.println("l: "+left);
//            System.out.println("r: "+right);

            Node node = new Node(null, left.weight + right.weight);
            node.left = left;
            node.right = right;

//            System.out.println(node);

            nodeList.remove(left);
            nodeList.remove(right);

            nodeList.add(node);

        }

        Node node = nodeList.get(0);


        return node;
    }


}



//创建Node ,待数据和权值
class Node implements Comparable<Node>  {
    Byte data; // 存放数据(字符)本身，比如'a' => 97 ' ' => 32
    int weight; //权值, 表示字符出现的次数
    Node left;//
    Node right;
    public Node(Byte data, int weight) {

        this.data = data;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.weight - o.weight;
    }

    public String toString() {
        return "Node [data = " + data + " weight=" + weight + "]";
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
}
