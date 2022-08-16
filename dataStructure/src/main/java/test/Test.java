package test;


import java.util.*;

import static test.HuffmanZip.*;

public class Test {
    public static void main(String[] args) {
        String str = "i like java e ";
        /*将字符串转化成byte数组*/
        byte[] bytes = str.getBytes();
        byte[] zip = huffmanZip(bytes);
        System.out.println("压缩前"+Arrays.toString(bytes)); //压缩前：[105, 32, 108, 105, 107, 101, 32, 106, 97, 118, 97]
        System.out.println("压缩后"+Arrays.toString(zip)); //压缩后：[-10, 118, 42, -57, 0]
        byte[] unzip = unZip(huffmanCodeMap, zip);
        System.out.println("解压后"+Arrays.toString(unzip));
        System.out.println("原来的字符为"+new String(unzip));
    }

}

class Node implements Comparable<Node>{

    private Byte data;/*字母的ASCII码*/
    private int value;/*结点权值*/
    private Node left;/*左子结点*/
    private Node right;/*右子结点*/

    public Node(Byte data, int value) {
        this.data = data;
        this.value = value;
    }

//        getter and setter 方法


    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "[" + "data="+data+",value=" + value + ']';
    }

    @Override
    public int compareTo(Node node) {
        //表示从小到达排序
        return this.value - node.value;
    }
}



class HuffmanZip {

    /*将前缀码存储在Map<Byte,String>中*/
    static Map<Byte,String> huffmanCodeMap = new HashMap<>();
    /*在生成前缀码时需要拼接字符串 定义StringBuilder来存储叶子结点的路径*/
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        String str = "i like java";
        /*将字符串转化成byte数组*/
        byte[] bytes = str.getBytes();
        byte[] zip = huffmanZip(bytes);
        System.out.println("压缩前"+ Arrays.toString(bytes)); //压缩前：[105, 32, 108, 105, 107, 101, 32, 106, 97, 118, 97]
        System.out.println("压缩后"+Arrays.toString(zip)); //压缩后：[-10, 118, 42, -57, 0]
    }

    /**
     *封装方法
     * @param bytes 原始数据
     * @return 压缩后的数据
     */
    public static byte[] huffmanZip(byte[] bytes){
        /*初始化结点*/
        List<Node> nodes = getNodes(bytes);
        /*创建哈夫曼树*/
        Node root = createHuffmanTree(nodes);
        /*获取前缀码*/
        getCodeMap(root,"",builder);
        /*压缩*/
        byte[] zip = zip(bytes, huffmanCodeMap);
        return zip;
    }

    /**
     * 根据哈夫曼树生成前缀码编码原始数据 [105, 32, 108, 105, 107, 101, 32, 106, 97, 118, 97]
     * @param bytes 字符串转化后的数组(原始数据)
     * @Param huffmanCodeMap {32=101, 97=110, 101=000, 118=001, 105=111, 106=010, 107=011, 108=100}
     * @return 编码后的数据 [-10, 118, 42, -57, 0]
     */
    public static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodeMap){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(huffmanCodeMap.get(bytes[i]));
        }
        System.out.println(stringBuilder.toString());
        //stringBuilder：111101100111011000101010110001110
        int length;
        /*8位一组将111101100111011000101010110001110转化成byte数组*/
        if (stringBuilder.length() % 8 == 0) {
            /*二进制字符串长度刚好是8的倍数*/
            length = stringBuilder.length() / 8;
        }else {
            length = stringBuilder.length() / 8 + 1;
        }
        byte[] huffmanBytes = new byte[length+1];
        int index = 0;
        byte lastLength = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strBytes;
            if(i+8 > stringBuilder.length()){
                /*最后的几位二进制数（可能不满8位）*/
                strBytes = stringBuilder.substring(i);
                lastLength = (byte)strBytes.length();
            }else {
                strBytes = stringBuilder.substring(i,i+8);
                lastLength = 8;
            }
            /*八位一组将二进制数转化为byte：11110110(补码) -> -10*/
            huffmanBytes[index] = (byte)Integer.parseInt(strBytes,2);
            index++;
        }
        huffmanBytes[index] = lastLength;
        return huffmanBytes;
    }
    /**
     * 根据byte数组初始化Node并且将Node放入到List中
     */
    public static List<Node> getNodes(byte[] bytes){
        /*存放结点*/
        List<Node> nodes = new ArrayList<>();
        /*存放字母对应的ASCII码已经个数*/
        Map<Byte, Integer> countMap = new HashMap<>();
        for (int i = 0; i < bytes.length; i++) {
            Integer count = countMap.get(bytes[i]);
            if (count == null) {
                countMap.put(bytes[i],1);
            }else{
                countMap.put(bytes[i],count+1);
            }
        }
        Set<Byte> keys = countMap.keySet();
        Iterator<Byte> iterator = keys.iterator();
        /*初始化结点*/
        for (Byte key: keys) {
            nodes.add(new Node(key,countMap.get(key)));
        }

        /*
        遍历map的第二种方式
        for (Map.Entry<Byte,Integer> entry : countMap.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }*/
        return nodes;
    }

    /**
     * 创建哈夫曼树
     */
    public static Node createHuffmanTree(List<Node> nodes){
        while(nodes.size() >= 2){
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            /*构建二叉树*/
            Node parent = new Node(null,left.getValue()+right.getValue());
            parent.setLeft(left);
            parent.setRight(right);

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        /*返回哈夫曼树的根结点*/
        return nodes.get(0);
    }

    /**
     *  获取所有叶子结点的前缀码并放入到Map中
     */
    public static void getCodeMap(Node node,String code,StringBuilder builder){
        StringBuilder stringBuilder = new StringBuilder(builder);
        /*将code追加到stringBuilder*/
        stringBuilder.append(code);
        if (node != null) {
            if (node.getData() == null){/*非叶子结点*/
                /*向左递归*/
                getCodeMap(node.getLeft(),"0",stringBuilder);
                /*向右递归*/
                getCodeMap(node.getRight(),"1",stringBuilder);
            }else{/*叶子结点*/
                huffmanCodeMap.put(node.getData(),stringBuilder.toString());
            }
        }
    }

    /**
     * 解压缩
     * @param huffmanCodeMap {32=101, 97=110, 101=000, 118=001, 105=111, 106=010, 107=011, 108=100}
     * @param huffmanBytes [-10, 118, 42, -57, 0]
     * @return [105, 32, 108, 105, 107, 101, 32, 106, 97, 118, 97]
     */
    public static byte[] unZip(Map<Byte,String> huffmanCodeMap,byte[] huffmanBytes){
        StringBuilder stringBuilder = new StringBuilder();
        /*[-10, 118, 42, -57, 0] => 11110110 01110110 00101010 11000111 0*/
        for (int i = 0; i < huffmanBytes.length-1; i++) {
            byte b = huffmanBytes[i];
            /*判断是否为数组的最后一个元素*/
            boolean flag = (i == huffmanBytes.length-2);
            byte lastLength = huffmanBytes[huffmanBytes.length-1];
            stringBuilder.append(toBitString(!flag,b,lastLength));
        }
        System.out.println(stringBuilder.toString());
        Map<String,Byte> map = new HashMap<>();
        /*将huffmanCodeMap的key和value互换{32=101, 97=110, 101=000...} -> {101=32, 110=97, 000=101...}*/
        for (Map.Entry<Byte,String> entry : huffmanCodeMap.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while(flag){
                String key = stringBuilder.substring(i,i+count);
                b = map.get(key);
                if (b == null) {
                    /*没有匹配到*/
                    count++;
                }else{
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        /*将List中的数据放入到数组中*/
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }
    /**
     * 将byte数组转化成二进制的字符串：-10 -> 11110110(补码)
     * @param flag 判断是否需要补高位 true表示要补高位
     * @param b 要转化的byte
     * @return b对应的补码
     */
    public static String toBitString(boolean flag,byte b,byte lastLength){
        int temp = b;
        if(temp>=0){
            /*按位或 10000000|00000001 => 10000001*/
            temp |= 512;
        }
        /*将int类型的数组转化为二进制字符串（int转化后的字符串是32位 byte转化后的字符串位8位）*/
        String str = Integer.toBinaryString(temp);
        if(flag){
            /*取后8位*/
            return str.substring(str.length()-8);
        }else{
            String substring = str.substring(str.length() - lastLength);
            System.out.println(substring);
            return substring;
        }
    }

}


