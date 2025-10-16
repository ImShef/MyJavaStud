public class CycleWhile {
    public static void main (String[] args) {
        int x = 1;
        System.out.println("Перед началом цикла");
        while (x < 4) {
            System.out.println("Внутри цикла");
            System.out.println("Значение x равно " + x);
            x = x + 1;
        }
        System.out.println("После окончания цикла");
    }
}
/*В коде реализован цикл While и как она работает
 * Вывод в консоле должен быть таким:
 * Перед началом цикла
 * Внутри цикла
 * Значние x равно 1
 * Внутри цикла 
 * Значение x равно 2
 * Внутри цикла 
 * Значение x равно 3
 * После окончания цикла
 */