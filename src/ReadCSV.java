import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ReadCSV {
    ArrayList<String[]> fileByValue;

    //конструктор класса - инициализация списка
    ReadCSV() {
        fileByValue = new ArrayList<>();
    }

    //Чтение содержимого файла
    ArrayList<String[]> readFile(String path) {
        fileByValue.clear();
        String fileContents = "";
        try {
            fileContents = Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл не находится в нужной директории.");
        }
        //делим по строкам
        String[] fileByLines = fileContents.split("\\n");
        for (int i = 1; i < fileByLines.length; i++) {
            //делим по словам
            String[] lineByWord = fileByLines[i].split(",");
            for (int j = 0; j < lineByWord.length; j++) {
                //обрезаем пробелы чтобы при парсинге строк не получить ошибку
                lineByWord[j] = lineByWord[j].trim();
            }
            fileByValue.add(lineByWord);
        }
        return fileByValue;
    }
}
