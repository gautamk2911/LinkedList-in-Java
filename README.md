```markdown
# Linked List Implementation in Java

This repository showcases a comprehensive implementation of linked lists in Java, including various operations like insertion, deletion, traversal, and searching.

```
## 📋 Features

- **Dynamic Size:** Automatically adjusts as nodes are added or removed.
- **Efficient Operations:** Fast insertion and deletion without shifting elements.
- **Types Supported:** Singly Linked List, Doubly Linked List, Circular Linked List, and Circular Doubly Linked List.


## 🛠️ Operations


- **Insertion:** Add nodes at the beginning, end, or any position.
- **Deletion:** Remove nodes from the beginning, end, or any position.
- **Traversal:** Visit each node to process data.
- **Searching:** Find nodes using iterative and recursive methods.
- **Reversal:** Reverse the entire list.


## 📦 Usage Example
#### java
```

public static void main(String[] args) {
    LinkedListJava ll = new LinkedListJava();
    ll.addFirst(111);
    ll.addFirst(555);
    ll.printLinkedList();
    
    ll.addLast(222);
    ll.addLast(333);
    ll.printLinkedList();
    
    ll.add(666, 2);
    ll.add(777, 4);
    ll.printLinkedList();
    
    ll.removeFirst();
    ll.printLinkedList();
    
    ll.removeLast();
    ll.printLinkedList();
    
    int key = 777;
    int index = ll.itrSearch(key);
    System.out.println(index != -1 ? "Key found at index: " + index : "Key not found");
    
    key = 666;
    index = ll.recSearch(key);
    System.out.println(index != -1 ? "Key found at index: " + index : "Key not found");
    
    ll.reverseLinkedList();
    ll.printLinkedList();
}
```

## ✅ Advantages

- **Dynamic Adjustment:** Grows and shrinks as needed.
- **Ease of Modification:** Efficient insertion and deletion.

## ⚠️ Disadvantages

- **Memory Overhead:** Requires extra memory for node references.
- **Sequential Access:** Slower access time compared to arrays.

## 📜 License

```
Feel free to explore, use, and contribute! 🚀
