public class StaticList<T> {
    private T[] data;
    private int size;

    public StaticList(int size) {
        data = (T[]) new Object[size];
        this.size = 0;
    }

    public void add(T value) {
        if (isFull()) {
            throw new IllegalArgumentException("A lista está cheia e o valor: " + value + " não foi adicionado");
        }
        data[size++] = value;
        System.out.println("Adicionado: " + value);
        printList();
    }

    public void add(T value, int pos) {
        if (isFull()) {
            throw new IllegalArgumentException("A lista está cheia e o valor: " + value + " não foi adicionado");
        }
        if (pos < 0 || pos > size) {
            throw new IllegalArgumentException("Posição inválida: " + pos);
        }
        for (int i = size; i > pos; i--) {
            data[i] = data[i - 1];
        }
        data[pos] = value;
        size++;
        System.out.println("Adicionado " + value + " na posição " + pos);
        printList();
    }

    public T remove(int pos) {
        if (isEmpty()) {
            System.out.println("A lista está vazia");
            return null;
        }
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Posição inválida: " + pos);
        }
        T value = data[pos];
        data[pos] = null;

        for (int i = pos; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        System.out.println("Removido: " + value + " da posição " + pos);
        printList();
        return value;
    }
    
    public void clear() {
        this.size = 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void setData(T value, int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Posição inválida: " + pos);
        }
        data[pos] = value;
        System.out.println("Mudando o valor na posição " + pos + " para: " + value);
        printList();
    }

    public T getData(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Posição inválida: " + pos);
        }
        return data[pos];
    }

    public int getSize() {
        return size;
    }

    public int find(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                System.out.println("Valor " + value + " encontrado na posição: " + i);
                return i;
            }
        }
        System.out.println("Valor " + value + " não encontrado.");
        return -1;
    }

    public void printList() {
        System.out.print("Lista atual: ");
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                System.out.print(data[i]);
                if (i < size - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
