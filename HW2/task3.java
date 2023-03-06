// Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение)
import java.util.Scanner;
public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст на проверку");
        String str = sc.nextLine();
        sc.close();

        System.out.println(palindrom(str));
    }    
    public static boolean palindrom(String str) {
            for (int i =0; i < str.length()/ 2; i++) {
                if (str.charAt(i) == str.charAt(str.length() - 1 -i)) {
                    continue;
                }
                else {
                    return false;
                }
            }
            return true;
        }

    
}