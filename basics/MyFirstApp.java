public class MyFirstApp{
    public static void main (String[] args){
        System.out.println("Я управляю");
        System.out.print("миром");
    }
}
/* для того чтобы запустить код надо его скомпилировать.
1 Действие: javac MyFirstApp.java
2 Действие: java MyFirstApp (с class не сработает, т.к. JVM уже ищет .class)
Вывод в консоле должен быть таким:
Я управляю
миром
*/