// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами), результат после каждой итерации запишите в лог-файl.

import java.util.logging.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

//* Реализуйте алгоритм сортировки пузырьком числового массива (введён вами), результат после каждой итерации запишите в лог-файл.

public class task1 {
    public static void main(String[] args) throws IOException {
        // Создаем новый логгер
        Logger logger = Logger.getLogger(task1.class.getName());

        // Получение пути до файла логов
        String currentPath = Paths.get("")
                                  .toAbsolutePath()
                                  .toString();

        String logsPath = currentPath + "\\logs.txt";
       
        // Обработчики для логгера
        FileHandler fh = new FileHandler(logsPath);
        logger.addHandler(fh);

        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        // Исходный массив
        int[] sortArray = new int[] {12, 10, 4, 5, 3, 1, 2};
        System.out.println(Arrays.toString(sortArray));

        // Итоговый массив
        bubbleSort(sortArray, logger);
        System.out.println(Arrays.toString(sortArray));
    }

    public static void bubbleSort(int[] array, Logger logger) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    logger.info(Arrays.toString(array));
                }
            }
        }
    }
}