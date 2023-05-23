import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ThrowsException {
        Scanner in = new Scanner(System.in);   //Активировать сканер ввода? ---Изучить получше---
        System.out.println("Введите задачу. Разделите числа и операцию пробелами.");   //Инструкция при запуске
        String input = in.nextLine();   //Ввод запроса
        String [] taskElements = input.split(" ");   // Разделить запрос в местах пробелов

        boolean calcError = false;   //Показатель наличия ошибок

        if (taskElements.length < 3) {
            throw new IllegalArgumentException("ОШИБКА! Задача должна быть следующего вида: число, оператор (+, -, /, *), число.");
        }   //Проверка, чтоб было не меньше 3 элементов

        if (taskElements.length > 3) {
            throw new IllegalArgumentException("ОШИБКА! Задача должна быть следующего вида: число, оператор (+, -, /, *), число.");
        }   //Проверка, чтоб было не больше 3 элементов

        double num1 = 0;   //Первое число
        double num2 = 0;   //Второе число


        // Начало страшной части с римскими цифрами


        byte roman = 0;   //Римские ли числа? 0 - нет; 1 - только одно; 2 - оба.

        String symbol1 = taskElements[0];
        String symbol2 = taskElements[2];

        switch (symbol1) {
            case "I" -> {
                taskElements[0] = String.valueOf(1);
                roman++;
            }
            case "II" -> {
                taskElements[0] = String.valueOf(2);
                roman++;
            }
            case "III" -> {
                taskElements[0] = String.valueOf(3);
                roman++;
            }
            case "IV" -> {
                taskElements[0] = String.valueOf(4);
                roman++;
            }
            case "V" -> {
                taskElements[0] = String.valueOf(5);
                roman++;
            }
            case "VI" -> {
                taskElements[0] = String.valueOf(6);
                roman++;
            }
            case "VII" -> {
                taskElements[0] = String.valueOf(7);
                roman++;
            }
            case "VIII" -> {
                taskElements[0] = String.valueOf(8);
                roman++;
            }
            case "IX" -> {
                taskElements[0] = String.valueOf(9);
                roman++;
            }
            case "X" -> {
                taskElements[0] = String.valueOf(10);
                roman++;
            }
        }   // Первое число римское?

        switch (symbol2) {
            case "I" -> {
                taskElements[2] = String.valueOf(1);
                roman++;
            }
            case "II" -> {
                taskElements[2] = String.valueOf(2);
                roman++;
            }
            case "III" -> {
                taskElements[2] = String.valueOf(3);
                roman++;
            }
            case "IV" -> {
                taskElements[2] = String.valueOf(4);
                roman++;
            }
            case "V" -> {
                taskElements[2] = String.valueOf(5);
                roman++;
            }
            case "VI" -> {
                taskElements[2] = String.valueOf(6);
                roman++;
            }
            case "VII" -> {
                taskElements[2] = String.valueOf(7);
                roman++;
            }
            case "VIII" -> {
                taskElements[2] = String.valueOf(8);
                roman++;
            }
            case "IX" -> {
                taskElements[2] = String.valueOf(9);
                roman++;
            }
            case "X" -> {
                taskElements[2] = String.valueOf(10);
                roman++;
            }
        }   // Второе число римское?

        if (roman == 1) {
            throw new ThrowsException("ОШИБКА! Оба числа должны быть либо арабскими либо римскими.");
        }   //Проверка, чтобы оба числа были целыми


        // Конец страшной части с римскими цифрами


        try {
            num1 = Double.parseDouble(taskElements[0]);
            num2 = Double.parseDouble(taskElements[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ОШИБКА! Калькулятор принимает только числа");
        }   //Проверка, являются ли введенные значения числами

        char operation = taskElements[1].charAt(0);   //Операция задачи

        if (num1 % 1 != 0 || num2 % 1 != 0) {
            throw new ThrowsException("ОШИБКА! Калькулятор умеет работать только с целыми числами.");
        }   //Проверка, чтобы оба числа были целыми

        if ( num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10 ) {
            throw new ThrowsException("ОШИБКА! Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
        }   //Проверка, чтобы оба числа были больше 0 и меньше 11

        String result = String.valueOf(calculator((byte) num1, operation, (byte) num2));   //Присвоить "result" результат работы "calculator"

        if (!calcError && roman != 2) {
             System.out.println(result);   //Вывести результат
        } else if (!calcError && roman == 2) {

            if ( Integer.parseInt(result) < 1 ) {
                throw new IllegalArgumentException("ОШИБКА! Результат римской вариации задачи не может быть меньше 1");
            }   //Проверка, чтоб римский результат был больше 0

            switch (result) {
                case "1" -> result = "I";
                case "2" -> result = "II";
                case "3" -> result = "III";
                case "4" -> result = "IV";
                case "5" -> result = "V";
                case "6" -> result = "VI";
                case "7" -> result = "VII";
                case "8" -> result = "VIII";
                case "9" -> result = "IX";
                case "10" -> result = "X";
                case "11" -> result = "XI";
                case "12" -> result = "XII";
                case "13" -> result = "XIII";
                case "14" -> result = "XIV";
                case "15" -> result = "XV";
                case "16" -> result = "XVI";
                case "17" -> result = "XVII";
                case "18" -> result = "XVIII";
                case "19" -> result = "XIX";
                case "20" -> result = "XX";
                case "21" -> result = "XXI";
                case "24" -> result = "XXIV";
                case "25" -> result = "XXV";
                case "27" -> result = "XXVII";
                case "28" -> result = "XXVIII";
                case "30" -> result = "XXX";
                case "32" -> result = "XXXII";
                case "35" -> result = "XXXV";
                case "36" -> result = "XXXVI";
                case "40" -> result = "XL";
                case "42" -> result = "XLII";
                case "45" -> result = "XLV";
                case "48" -> result = "XLVIII";
                case "49" -> result = "XLIX";
                case "50" -> result = "L";
                case "54" -> result = "LIV";
                case "56" -> result = "LVI";
                case "60" -> result = "LX";
                case "63" -> result = "LXIII";
                case "64" -> result = "LXIV";
                case "70" -> result = "LXX";
                case "72" -> result = "LXXII";
                case "80" -> result = "LXXX";
                case "81" -> result = "LXXXI";
                case "90" -> result = "XC";
                case "100" -> result = "C";
            }   // Переводим в римсий вариант арабское число

            System.out.println(result);   //Вывести результат в римском варианте

        }
        else throw new ThrowsException("Произошла ошибка");   //Если произошла ошибка


    }

    public static int calculator(byte num1, char operation, byte num2){

        return switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default ->
                    throw new IllegalArgumentException("ОШИБКА! Калькулятор должен принимать только операторы +, -, *, /.");
        };
    }    //Конец калькулятора

}