package HomeWork.HW2;
// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.logging.Logger;

public class Home_Work_2_1 {
    public static void main(String[] args) {
        int[] array = {9, 3, 4, 5, 4, 6, 7, 8, 7, 6, 5, 4, 3, 2};
        sort(array);
    }

    public static void sort(int[] array) {
        File myFile = new File("src/main/java/HomeWork/Text_HW_2_1.txt");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
            String text = Arrays.toString(array);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));
                String lineSeparator = System.getProperty("line.separator");
                writer.write(text);
                writer.append('\n');
                writer.close();
            } catch (Exception exception) {
                Logger logger = Logger.getAnonymousLogger();
                logger.warning("We wrote file");
            }
        }
    }
}
