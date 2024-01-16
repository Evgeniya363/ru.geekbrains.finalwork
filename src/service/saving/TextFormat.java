package service.saving;

import model.Human;
import service.Builder;
import service.exception.ParseImpossibleException;

import java.io.*;
import java.util.List;
import java.util.ListIterator;

/**
* Класс TextFormat описывает сохранение объекта Human* в текстовый файл
*/public class TextFormat implements Formatter {
    private final NameSakes nSakes = new NameSakes();
    private String fileName;
    private String path;

    /**
     * Метод выполняет поиск данных человека в файле
     * и записывает в случае отсутствия,
     * в случае успешной записи возвращает true
     * и false в противном случае
     * @param human объект класса Human
     * @return результат операции записи
     */
    public boolean save(Human human, String path) throws IOException {
        // Определяем список возможных однофамильцев
        this.path = path;
        List<String> namesakes = nSakes.nameSakes(human);
        File file = fileIfExist(namesakes);  // если файл однофамильцев существует,
                                             // используем его,
                                             // иначе создастся новый по фамилии
        try (FileWriter writer = new FileWriter(file, true);
                 FileReader fr = new FileReader(file);
                 BufferedReader reader = new BufferedReader(fr); ) {

            // Читаем построчно, парсим в Human, сравниваем,
            // в случае успеха прерываем выполнение
            String line = reader.readLine();
            while (line != null) {
                List<String> savedDataList = List.of(line.split(" "));
                try {
                    Human humanSaved = Builder.CreateHuman(savedDataList);
                    if (humanSaved.equals(human)) { // Данные уже содержатся в файле
                        reader.close();
                        fr.close();
                        writer.close();
                        return false;
                    }
                } catch (ParseImpossibleException e) {
                    // Данные в файле не соответствуют формату полей Human : пропускаем
                    // System.out.println("Не удалось распарсить строку " + savedDataList);
                }

                line = reader.readLine();
            }

            writer.append(human.toString());  // Записываем данные в файл
            writer.append("\n");
            return true;
        }

    }

    /**
     * Проверяет наличие файлов из списка, если файл найден
     * возвращает экземпляр класса File, указывающий на него
     * иначе - указывающй на первый файл списка
     * @param namesakes список имен файлов
     * @return экземпляр класса File
     */
    private File fileIfExist(List<String> namesakes) {

        fileName = path + namesakes.getFirst() + ".txt";  // Первая в списке фамилия текущего human
        File file;

        ListIterator<String> iterator = namesakes.listIterator(1);  //Проверяем
                                                    // наличие файла с 1-го однофамильца
        while (iterator.hasNext()) {
            String nFile = path + iterator.next() + ".txt";
            file = new File(nFile);
            if (file.isFile()) return file;
        }
        return new File(fileName);
    }

}
