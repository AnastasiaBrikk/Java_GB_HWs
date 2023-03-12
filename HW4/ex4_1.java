import java.util.LinkedList;

// Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.

public class ex4_1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("hi");
        list.add("wine");
        list.add("sun");
        list.add("3");
        list.add("love10");
        list.add("24");
        
        
        System.out.println(reverse(list));


    }
    public static LinkedList<String> reverse(LinkedList<String> list) {
        LinkedList<String> newList = new LinkedList<>();
        int size = list.size();
        while(newList.size() < size) {
            newList.addFirst(list.pop());
        }
        
        return newList;
    }
}