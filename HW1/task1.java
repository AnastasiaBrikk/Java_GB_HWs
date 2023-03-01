package HW1;
import java.util.Scanner;

//Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)
public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите натуральное число: ");
        int n = sc.nextInt();
        sc.close();
        int sum = 0;
        int factorial = 1;
        int count = 1;
        while (count <= n) {
            sum += count;
            factorial *= count;
            count++;
        }
        System.out.println("Сумма от 1 до числа = " + sum);
        System.out.println("Факториал числа = " + factorial);

    }
}