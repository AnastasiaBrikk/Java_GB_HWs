import java.util.LinkedList;
import java.util.Scanner;

public class ex4_3 {
    public static void main(String[] args) {
        LinkedList<Double> res = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        res.add(sc.nextDouble());
        sc.nextLine();

        while(true) {
            System.out.print("Введите операцию (+, -, *, /, Cancel): ");
            String oper = sc.nextLine();

            if ("".equals(oper)) break;
            else if ("Cancel".equals(oper) || "cancel".equals(oper)) {
                res.removeFirst();
                if (res.size() == 0) res.add(0.0);
                }
            else {
                System.out.print("Введите второе число: ");
                double secNumber = sc.nextDouble();

                process(res, oper, secNumber);
                sc.nextLine();
                }

            System.out.println("Результат: " + res.getFirst());
        }

        sc.close();
    }

    public static void process(LinkedList<Double> list, String oper, double num) {
        switch (oper) {
            case "+":
                list.add(0, list.getFirst() + num);
                break;
            
            case "-":
                list.add(0, list.getFirst() - num);
                break;

            case "*":
                list.add(0, list.getFirst() * num);
                break;
            
            case "/":
                if (num == 0) {
                    System.out.println("Деление на ноль, ошибка");
                    break;
                }
                list.add(0, list.getFirst() / num);
                break;
            
            default:
                System.out.println("Что-то пошло не так..");
        }
    }
}