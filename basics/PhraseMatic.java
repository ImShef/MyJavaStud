import java.util.Scanner;

public class PhraseMatic {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = 1;
        while (x == 1) {
                String[] wordListOne = {"круглосуточный", "трех-звенный",
            "30000-футовый", "взаимный", "обоюдный выйгрыш", "фронтэнд",
            "на основе веб-тенхнологий", "проникающий", "умный",
            "шесть сигм", "метод критического пути", "динамичный"};

                String[] wordListTwo = {"уполномоченный", "трудный",
            "чистый продукт", "ориентированный", "центральный",
            "распледеленый", "кластеризованный", "фирменный",
            "нестандартный ум", "позиционированный", "сетевой",
            "сфокурсированный", "использованный с выгодой", "выровненный",
            "нацеленный на", "общий", "совместный", "ускоренный"};

                String[] wordListThree = {"процесс", "пункт разгрузки",
            "выход из положения", "тип структуры", "талант", "подход",
            "уровень завоеванного внимания", "портал", "период времени",
            "обзор", "образец", "пункт следования"};

            int oneLenght = wordListOne.length;
            int twoLenght = wordListTwo.length;
            int threeLenght = wordListThree.length;

            int rand1 = (int) (Math.random() * oneLenght);
            int rand2 = (int) (Math.random() * twoLenght);
            int rand3 = (int) (Math.random() * threeLenght);

            String phrase = wordListOne[rand1] + " " + 
            wordListTwo[rand2] + " " + wordListThree[rand3];
            
            System.out.println("Всё, что нам нужно, - это " + phrase);

            System.out.println("Хотите попробовать еще раз?");
            System.out.println("1.Да");
            System.out.println("2.Нет");
            System.out.print("Пиши: ");
            
            try {
                int sc = scanner.nextInt();
                switch (sc) {
                case 1:
                    System.out.println("Сейчас начнем заново)");
                    continue;
                case 2:
                    System.out.println("Спасибо за использование программы!");
                    System.exit(0);
                default:
                    System.out.println("Неизвестная команда, введи 1 или 2");
                }
            }
            catch (Exception e) {
                System.out.println("Это не число. введи 1 или 2");
                System.out.println("Буду считать что ты ввел 1)");
                scanner.nextLine();
            }    
        }
        scanner.close();
    }
}
