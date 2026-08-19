public class HIstorialNavegacion {
    public Node<String> top;
    public int size;

    public HIstorialNavegacion() {
        this.top = null;
        this.size = 0;
    }

    public void visitarPagina(String url) {
        Node<String> newNode = new Node<>(url);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public String borrarUltimaPagina() {
        if (top == null) {
            return null;
        }
        String url = top.data;
        top = top.next;
        size--;
        return url;
    }

    public String mostrarUltima() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public String mostrarHistorial() {
        StringBuilder historial = new StringBuilder();
        Node<String> current = top;
        while (current != null) {
            historial.append(current.data).append("\n");
            current = current.next;
        }
        return historial.toString();
    }
}
