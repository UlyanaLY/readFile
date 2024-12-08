import java.io.*;
import java.util.Set;

import static java.lang.Character.isUpperCase;

public class Main {
    public static void main(String[] args) {
        var inputFilePath = "resources/text.txt";
        var outputFilePath = "resources/output.txt";

        File file = new File(".");
        System.out.println(file.getAbsolutePath());

        var vowelsAmount = 0;
        var consonantsAmount = 0;

        var vowels = Set.of('а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я',
                'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я');

        try (var reader = new BufferedReader(new FileReader(inputFilePath));
             var writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            int character;
            while ((character = reader.read()) != -1) {
                var currentChar = (char) character;
                if (vowels.contains(currentChar)) {
                    vowelsAmount++;
                    if (isUpperCase(currentChar)) {
                        writer.write('A');
                    } else {
                        writer.write('a');
                    }
                } else if (Character.isLetter(currentChar)) {
                    consonantsAmount++;
                    if (isUpperCase(currentChar)) {
                        writer.write('М');
                    } else {
                        writer.write('м');
                    }
                } else {
                    writer.write(currentChar);
                }
            }

            writer.write("\nКоличество гласных букв: " + vowelsAmount + " \nКоличество согласных букв: " + consonantsAmount);

            System.out.println("Все замены выполнены. Результат сохранён: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Ошибка при обработке файла: " + e.getMessage());
        }
    }
}
