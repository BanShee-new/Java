# _Репозиторий для сдачи домашних заданий по курсу Java от GeekBrains_ #

## Задания первого семинара: ##

1. Вычислить n-ое треугольне число (сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)

2. Вывести все простые числа от 1 до 1000

3. Реализовать простой калькулятор (+ - / *)

4. Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.

## Задания второго семинара: ##

1. Реализуйте алгоритм сортировки пузырьком числового массива (введён вами), результат после каждой итерации запишите в лог-файл

2. Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].

*Пример вывода:*
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.

3. Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение).

4. К калькулятору из предыдущего дз добавить логирование.

## Задания третьего семинара: ##

1. Пусть дан произвольный список целых чисел, удалить из него четные числа.

2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичнское из этого списка.

3. Реализовать алгоритм сортировки массива слиянием. (Дополнительное)

## Задания четвертого семинара: ##

1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.

2. Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.

3. В калькулятор добавьте возможность отменить последнюю операцию.

*Пример:*
>1 + 2
>ответ: 3


+
4
ответ:
7

Отмена
3
*
3

ответ:
9

** Дополнительно каскадная отмена - отмена нескольких операций **
