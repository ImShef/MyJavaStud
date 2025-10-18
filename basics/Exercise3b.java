public class Exercise3b {
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
 class Exercise3b {
        int x = 5;
        while (x > 1) {
            x = x - 1;
            if (x < 3) {
                System.out.println("маленький икс");
            }
    }
}
без метода этот код ничего сделать не сможет.
исправленный код выше
 */