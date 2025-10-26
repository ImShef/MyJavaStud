import java.util.*;

public class LogicSets {
    public static void main(String[] args) {
        // Исходный список чисел
        List<Integer> numbers = Arrays.asList(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30);
        
        // Получаем множества через метод orig
        ResultSets result = orig(numbers);
        Set<Integer> evenSet = result.even; // B = Множетсво четных числел
        Set<Integer> multSet = result.mult; // C = Множество чисел, кратных 5
        Set<Integer> primeSet = result.prime; // D = Множество простых чисел

        // Создаем доп.множества через отрицания
        Set<Integer> nonEven = createNonEven(numbers); // !B = Множество нечетных чисел
        Set<Integer> nonMult = createNonMult(numbers); // !C = Множество чисел некратных 5
        Set<Integer> nonPrime = createNonPrime(numbers); // !D = Множество составных чисел
        
        // Универсум для операций
        Set<Integer> universe = new HashSet<>(numbers);

        // Выполняем логические операции
        System.out.println("A: " + numbers);
        System.out.println("Заданы предикаты на множестве A:");
        System.out.println("B(X): 'число X - четное'");
        System.out.println("C(X): 'число X - кратное пяти'");
        System.out.println("D(X): 'число X - простое'");
        System.out.println("B: " + evenSet);
        System.out.println("C: " + multSet);
        System.out.println("D: " + primeSet);
        System.out.println("notB: " + nonEven);
        System.out.println("notC: " + nonMult);
        System.out.println("notD: " + nonPrime);
        System.out.println("B and not C: " + sorted(logicAnd(evenSet, nonMult)));
        System.out.println("not B and not D: " + sorted(logicAnd(nonEven, nonPrime)));
        System.out.println("C or D: " + sorted(logicOr(multSet, primeSet)));
        System.out.println("B <-> D: " + sorted(logicEq(evenSet, primeSet, universe)));
        System.out.println("not C -> B: " + sorted(logicImp(nonMult, evenSet, universe)));
    }

    // Проверка числа на простоту
    static boolean isPrime(int n) {
        if (n < 2) return false;           // Числа меньше 2 не простые
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;  // Если нашли делитель - не простое
        }
        return true;                       // Делителей нет - число простое
    }

    // Класс для возврата трех множеств
    static class ResultSets {
        Set<Integer> even;
        Set<Integer> mult;
        Set<Integer> prime;
    }

    // Разбиение чисел на множества
    static ResultSets orig(List<Integer> numbers) {
        ResultSets result = new ResultSets();
        result.even = new HashSet<>();
        result.mult = new HashSet<>();
        result.prime = new HashSet<>();

        for (int num : numbers) {
            if (num % 2 == 0) result.even.add(num);
            if (num % 5 == 0) result.mult.add(num);
            if (isPrime(num)) result.prime.add(num);
        }
        return result;
    }

    // Создание множества нечетных чисел
    static Set<Integer> createNonEven(List<Integer> nums) {
        Set<Integer> result = new HashSet<>();
        for (int num : nums) {
            if (num % 2 != 0) result.add(num);
        }
        return result;
    }

    // Создание множества чисел не кратных 5
    static Set<Integer> createNonMult(List<Integer> nums) {
        Set<Integer> result = new HashSet<>();
        for (int num : nums) {
            if (num % 5 != 0) result.add(num);
        }
        return result;
    }

    // Создание множества составных чисел
    static Set<Integer> createNonPrime(List<Integer> nums) {
        Set<Integer> result = new HashSet<>();
        for (int num : nums) {
            if (!isPrime(num)) result.add(num);
        }
        return result;
    }

    // Логическое И (пересечение)
    static Set<Integer> logicAnd(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2); // Оставляет только общие элементы
        return result;
    }

    // Логическое ИЛИ (объединение)
    static Set<Integer> logicOr(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2); // Добавляет все элементы из обоих множеств
        return result;
    }

    // Логическая импликация (A → B = ¬A ∨ B)
    static Set<Integer> logicImp(Set<Integer> set1, Set<Integer> set2, Set<Integer> universe) {
        Set<Integer> notA = new HashSet<>(universe);
        notA.removeAll(set1); // Дополнение A (все что НЕ в A)
        return logicOr(notA, set2); // notA ∪ B
    }

    // Логическая эквивалентность (A ⇔ B = (A → B) ∧ (B → A))
    static Set<Integer> logicEq(Set<Integer> set1, Set<Integer> set2, Set<Integer> universe) { // Universe - все элементы numbers множества
        Set<Integer> aImpB = logicImp(set1, set2, universe);  // A → B
        Set<Integer> bImpA = logicImp(set2, set1, universe);  // B → A  
        return logicAnd(aImpB, bImpA);  // (A → B) ∧ (B → A)
    }

    // Вспомогательный метод для сортировки результата
    static List<Integer> sorted(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}