package HW1;
import java.util.Scanner;

//Реализовать простой калькулятор (+ - / *)
public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        Integer a = sc.nextInt();

        System.out.println("Введите знак: ");
        String oper = sc.next();
        char var = oper.charAt(0);
        
        System.out.println("Введите второе число: ");
        int b = sc.nextInt();
        sc.close();
        char plus = '+', min = '-', mul = '*', del = '/';
        if (var == plus) System.out.println(a + b);
        
        if (var == min) System.out.println(a - b);
        
        if (var == mul) System.out.println(a * b);
        
        if (var == del) System.out.println(a / b);
        }
}
