package findprefixesapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class FindPrefixesApp {

    public static String[] parseFile(String strpath) { // функция чтения с разивкой по строкам файла (разделитель - перевод строки)
        Path path = Paths.get(strpath);
        try (Stream<String> lines = Files.lines(path)) {
            ArrayList<String> result = new ArrayList<String>();
            lines.forEach(s -> {
                StringTokenizer token = new StringTokenizer(s, "\n");
                while (token.hasMoreTokens()) {
                    result.add(token.nextToken());
                }
            });
            return (String[]) result.toArray(new String[result.size()]);
        } catch (IOException ex) {
            // ...
        }
        return null;
    }

    public static void main(String[] args) {

//////////////////////////////// проверка тест кейса
        String[] words = parseFile("src\\findprefixesapp\\test_cases.txt"); // тестируем тест кейс
        int sizeSampleArray = Integer.parseInt(words[0]) + 1; // число строк в тесте                
        String[] SampleArray = new String[sizeSampleArray]; // заполняем массив строк из файла тест кейса
        for (int i = 0; i < sizeSampleArray - 1; i++) {
            SampleArray[i] = words[i + 1].replaceAll("[^A-z]", ""); // отбрасываем результат теста
//            System.out.println("i- " + i + " " + SampleArray[i]);
        }

        FindPrefixes fp = new FindPrefixes(SampleArray[0]);  // проверка 0 - 20 строки из теста
        fp.FindPrefixes();
        fp.OUT();

//////////////////////////////////////////
        FindPrefixes fp1 = new FindPrefixes("coconut");
        fp1.FindPrefixes();
        fp1.OUT();

    }

}
