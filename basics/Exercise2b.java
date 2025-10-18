public class Exercise2b {
    public static void main(String[] args) {
        int x = 5;
        while (x > 1) {
            x = x - 1;
            if (x < 3) {
                System.out.println("маленький икс");
            }
        }
    }
}

/* кривой код:
    public static void main(String[] args) {
        int x = 5;
        while (x > 1) {
            x = x - 1;
            if (x < 3) {
                System.out.println("маленький икс");
            }
        }
    }
}
без класса компилятор ничего не сделает, т.к. он не видит метод.
исправленный код выше
 */