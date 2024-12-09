public class MasterLab3 {
    // завдання 4
    // Функція для обчислення суми за заданою формулою, де a і b - параметри, k - кількість ітерацій
    public static double sSum4(double a, double b, int k) {
        // Перевірка, чи k не більше 30
        if (k > 30) {
            throw new IllegalArgumentException("k повинно бути більше рівне 30"); // виводить помилку, якщо k більше 30
        }
        
        double sum = 0.0; // змінна для збереження результату суми
        // Цикл для обчислення суми за формулою
        for (int i = 1; i <= k; i++) {
            sum += Math.sqrt(a * i * Math.sqrt(b / i)); // додаємо кожний елемент до суми
        }
        
        return sum; // повертаємо результат
    }

    
    // завдання 6
    // Функція для обчислення значення за залежністю від t і i
    public static double x(double t, int i) {
        switch (i) { // Вибірка залежно від значення i

        case 1:
            return Math.sqrt(t); // корінь квадратний з t
        case 2:
            return 1 / Math.sqrt(t); // обернений корінь квадратний з t
        default:
            // Якщо i не рівне 1 або 2, виконується інша операція
            double sum = 0; // змінна для збереження результату
            // Цикл для обчислення суми
            for (int k = 1; k <= i; k++) {
                sum += k * t; // додаємо кожний елемент до суми
            }
            return sum; // повертаємо результат суми
        }
    }

    // завдання 13
    // Функція для обчислення суми ряду, де epsilon - точність для зупинки
    public static double sum13(double epsilon) {
        double sum = 0; // змінна для збереження результату
        double factorial = 1; // змінна для обчислення факторіала
        int i = 1; // змінна для лічильника ітерацій

        while (true) { // безкінечний цикл, поки не досягнемо потрібної точності
            double term = Math.pow(-1, i) / factorial; // обчислюємо кожен член ряду
            sum += term; // додаємо його до суми

            if (Math.abs(term) < epsilon) { // перевірка, чи досягнута точність
                break; // якщо так, виходимо з циклу
            }

            factorial *= i; // обчислюємо наступний факторіал
            i++; // збільшуємо лічильник ітерацій
        }

        return sum; // повертаємо результат суми
    }
    public static void main(String[] args) {
        double a = 2.0; 
        double b = 3.0; 
        int k = 30;     
        
        double result0 = sSum4(a, b, k);
        System.out.println("Сума ряду : " + result0 + "\n");

        System.out.println(x(4, 1));   
        System.out.println(x(9, 2));   
        System.out.println(x(3, 4) + "\n");
        
        double epsilon = 0.02; 
        double result = sum13(epsilon);
        System.out.println("Сума ряду: " + result);
    }
}