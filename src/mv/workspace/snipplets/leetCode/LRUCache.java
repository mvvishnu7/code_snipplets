package mv.workspace.snipplets.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    private Map<Integer, Node> hashTable;
    private int maxCapacity;
    private int currentCapacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        currentCapacity = 0;
        maxCapacity = capacity;
        hashTable = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = hashTable.get(key);

        if (node == null) return -1;

        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node;

        node = hashTable.get(key);

        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;

            currentCapacity++;
            checkCapacity();
            hashTable.put(key, node);
            attachAsHead(node);
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    private void checkCapacity() {
        if (currentCapacity > maxCapacity) {
            hashTable.remove(tail.prev.key);

            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
        }
    }

    private void moveToHead(Node node) {
        detachNode(node);
        attachAsHead(node);
    }

    private void attachAsHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    private void detachNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private class Node {
        int key;
        int value;

        Node prev;
        Node next;
    }
}
