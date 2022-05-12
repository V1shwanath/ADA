
// import java.util.LinkedList;
/**
 * Node
 */
class Node {

    int data;
    Node next;

    public  Node(int data) {
        this.data = data;

    }

}

/**
 * LinkedList
 */
class LinkedList {

    Node head;
    int size = 0;


    public void insert(int data) {

        Node node = new Node(data);
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
            size++;
        }

        else {
            Node tempNode = head;

            while (tempNode.next != null) {
                tempNode = tempNode.next;

            }
            tempNode.next = node;
            size++;

        }

    }

    public void show() {

        Node tempNode = head;
        while (tempNode.next != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.next;
        }
        System.out.println(tempNode.data);
        System.out.println(size);

    }
}

class calculator {

    public int add(int i, int j) {
        return i + j;

    }

}

/**
 * adv
 */

class adv extends calculator {

    // public int add(int i, int j) {
    // return i + j;

    // }
    public int sub(int i, int j) {
        return i - j;

    }

}

/**
 * veryAdv
 */

class veryAdv {

    public void multi(int i, int j) {
        System.out.println(i * j);
    }

}

public class inheritencedemo {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insert(5);
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.show();

        calculator obj = new calculator();

        adv a1 = new adv();

        veryAdv v1 = new veryAdv();

        int r1 = a1.add(20, 10);
        int r2 = a1.sub(20, 10);

        System.out.println(r1 + " " + r2);

    }
}
