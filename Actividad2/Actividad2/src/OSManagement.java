public class OSManagement {
    public Node<String> top;
    public int size;

    public OSManagement() {
        this.top = null;
        this.size = 0;
    }

    public void addCommand(String command) {
        Node<String> newNode = new Node<>(command);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void addText(String txt) {
        Node<String> newNode = new Node<>(txt);
        newNode.next = top;
        top = newNode;
        size++;        
    }

    public String removeText() {
        if (top == null) {
            return null;
        }
        String command = top.data;
        top = top.next;
        size--;
        return command;
    }

    public String peekText() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public String peekLastCommand() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public String showCommandHistory() {
        StringBuilder history = new StringBuilder();
        Node<String> current = top;
        while (current != null) {
            history.append(current.data).append("\n");
            current = current.next;
        }
        return history.toString();
    }

}
