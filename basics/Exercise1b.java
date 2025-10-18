public class Exercise1b {
    public static void main(String[] args) {
        int x = 1;
        while (x < 10) {
            x = x + 1;
            if (x > 3) {
                System.out.println("большой икс");
            }
        }
    }
}

/* кривой код:
        public class Exercise1b {
            public static void main(String[] args) {
                int x = 1;
                while (x < 10) {
                    if (x > 3) {
                        System.out.println("большой икс");
                    }
                }
            }
        }

компиляция произойдет успешно, но этот код ничего не сделает.
исправленный код не в комментариях.
*/
