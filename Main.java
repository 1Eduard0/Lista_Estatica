public class Main {
    public static void main(String[] args) {
        StaticList<Integer> list = new StaticList<>(5); 

        try {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);

            list.remove(0);
            list.remove(2);

            list.add(6, 1);
            list.add(7, 0);

            System.out.println("------------------------------------------------------------------------");

            System.out.println("Elemento na posição 1: " + list.getData(1));
            System.out.println("Elemento na posição 3: " + list.getData(3));

            list.setData(8, 2);

            System.out.println("------------------------------------------------------------------------");

            System.out.println("Tamanho da lista: " + list.getSize());

            System.out.println("------------------------------------------------------------------------");

            System.out.println("Encontrando os valores da lista"); 
            list.find(7);
            list.find(3);

            System.out.println("------------------------------------------------------------------------");
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Lista está cheia? " + list.isFull());
        System.out.println("Lista está vazia? " + list.isEmpty());

        System.out.println("------------------------------------------------------------------------");

        System.out.println("Limpando a lista");
        list.clear();

        System.out.println("A lista está limpa? " + list.isEmpty());
    }
}