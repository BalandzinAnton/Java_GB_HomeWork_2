package HomeWork.HW2;
// К калькулятору из предыдущего дз добавить логирование.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Logger;

public class Home_Work_2_2 {
    public static Scanner numberA = new Scanner(System.in);
    public static Scanner numberB = new Scanner(System.in);
    public static Scanner result = new Scanner(System.in);


    public static void main(String[] args) {
        float resOut = 0;
        String operation = "";
        StringBuilder sb = new StringBuilder();
        while (true) {
            File myFile = new File("src/main/java/HomeWork/Text_HW_2_2.txt");
            System.out.print("Введите число 'A': ");
            float a = numberA.nextInt();
            System.out.print("Введите число 'B': ");
            float b = numberA.nextInt();
            String massage = "Выберите действие:\n 1 - сложить;\n 2 - отнять; \n 3 - умножить; \n 4 - разделить;";
            System.out.println(massage);
            int res = numberA.nextInt();
            if (res == 1) {
                resOut = a + b;
                operation = "+";
            }
            if (res == 2) {
                resOut = a - b;
                operation = "-";
            }
            if (res == 3) {
                resOut = a * b;
                operation = "*";
            }
            if (res == 4) {
                resOut = a / b;
                operation = "/";
            }

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));
                String lineSeparator = System.getProperty("line.separator");
                sb.append("a ").append(operation).append(" b").append(" = ").append(resOut);
                writer.write(String.valueOf(sb));
                sb.setLength(0);                      // очищаю StringBuilder
                writer.append('\n');
                writer.flush();
            } catch (Exception exception) {
                Logger logger = Logger.getAnonymousLogger();
                logger.warning("We wrote file");
            }

        }
    }
}
