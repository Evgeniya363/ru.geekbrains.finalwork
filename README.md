### Приложение "Телефонная книга"


Консольное приложение запрашивает у пользователя в произвольном
порядке следующие данные, разделенные пробелом: 
<Фамилия Имя Отчество> <дата рождения> <номер телефона> <пол>. 
Введенная строка разбивается на отдельные "слова", 
которые приложение пробует распарсить в запрошенные поля, 
и, в случае успеха, сохраняет в текстовый файл, название которого 
совпадает с фамилией человека.

Данные однофамильцев сохраняются в один файл.

Модель описывает класс Human, структура которого 
соответствует запрашиваемым данным.

Для парсинга создан абстрактный класс Parser и наследники 
по количеству используемых типов. Для приведения 
строковых переменных к различным типам (парсинга) служит
публичный метод parseToClass, реализованный 
в классах-потомках, который при удачном преобразовании 
строки сохраняет 
значение в поле value и возвращает 
true, и false - в противном случае. 


Процедура обработки стартует в классе Service CreateHuman. 
Сначала данные проверяются на количество введенных параметров.
Если оно не соответствует заявленному, 
в вызывающий метод возвращается код ошибки.
В противном случае запускается одноименный метод класса Builder.


Обработка (парсинг) осуществляется 
в классе Builder. При успешном завершении метода CreateHuman создается 
экземпляр класса Human. При неудачном парсинге данные, не прошедшие 
проверку, добавляются в соответствующий список. На основании 
этого списка выбрасывается исключение ParseImpossibleException.
Также проверяется валидность введенной даты рождения; 
в случае несоблюдения условия выбрасывается исключение 
IllegalDateException.


Если экземпляр класса Human успешно создан, выполняется метод 
save класса TextFormat. В нем устанавливается список возможных
однофамильцев, осуществляется поиск данных человека в 
соответствующих фамилии файлах. В случае отсутствия записи
данные сохраняются в существующий файл или в новый, 
при отсутствии такового. При успешной записи метод возвращает true
и false - если запись уже существует. 
Если возникает исключение IOException, оно пробрасывается по стеку вызова.

Обработка исключений и значений, возвращаемых вызываемыми методами,
осуществляется в классе Presenter, информируя пользователя о 
результатах обработки данных.


