import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Prav {
    public static void main(String[] args) {
        String inputFile = "inputFile.java"; // Путь к исходному файлу с кодом
        String outputFile = "outputFile.java"; // Путь к файлу, в который будет записан код без комментариев

        try {
            // Чтение исходного файла
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder codeBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                codeBuilder.append(line).append(System.lineSeparator());
            }
            reader.close();

            // Удаление комментариев
            String codeWithoutComments = removeComments(codeBuilder.toString());

            // Запись кода без комментариев в новый файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(codeWithoutComments);
            writer.close();

            System.out.println("Комментарии успешно удалены. Код записан в файл: " + outputFile);
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файлов: " + e.getMessage());
        }
    }

    private static String removeComments(String code) {
        // Удаление однострочных комментариев
        code = code.replaceAll("//.*", "");

        // Удаление многострочных комментариев
        code = code.replaceAll("/\\*.*?\\*/", "");

        return code;
    }
}
