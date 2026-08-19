public class LinkedList <T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private int listType;
    
    public LinkedList(int listType) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.listType = listType;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int getListType() {
        return listType;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return;
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T data = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return data;
    }

    public T dequeue() {
        return remove();
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        if (head == tail) {
            T data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }

        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }

        T data = tail.data;
        current.next = null;
        tail = current;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        if (index == 0) {
            return remove();
        }

        Node<T> previous = head;
        for (int i = 1; i < index; i++) {
            previous = previous.next;
        }

        T data = previous.next.data;
        if (previous.next == tail) {
            tail = previous;
        }
        previous.next = previous.next.next;
        size--;
        return data;
    }

    public String showList() {
        StringBuilder listString = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            listString.append(current.data).append("\n");
            current = current.next;
        }
        return listString.toString();
    }
}
