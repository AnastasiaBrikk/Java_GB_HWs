import java.util.Scanner;
import java.util.LinkedList;
// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
import java.util.Queue;

public class ex4_2 {
    public static void main(String[] args) {
        Queue<String> list = new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        System.out.println(list);
        
        while(true) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите: 1 - поместить элемент в конец очереди, 2 - получить и удалить из очереди первый элемент, 3 - получить первый элемент");
        String n = sc.next();
        if (n.equals("1")) {
            System.out.println("Введите элемент:");
            String elem = sc.next();
            enqueue(list, elem);
            System.out.println(list);
        } else if(n.equals("2")) {
            dequeue(list);
            System.out.println(list);
        } else if(n.equals("3")) {
            first(list);
        } else {
            System.out.println("Error");
        }
        sc.close();
    }    

    }
    public static void enqueue(Queue<String> list, String elem) {
        list.add(elem);
    }

    public static void dequeue(Queue<String> list) {
        System.out.println(list.remove());
    }

    public static void first(Queue<String> list) {
        System.out.println(list.element());
    }
}
