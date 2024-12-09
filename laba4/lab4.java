public class lab4 {

    public static int findProductOfModules(int[] arr) {
        int maxNegative = Integer.MIN_VALUE;  // найбільший від’ємний елемент
        int minEven = Integer.MAX_VALUE;      // найменший парний елемент

        for (int num : arr) {
            if (num < 0 && num > maxNegative) {
                maxNegative = num; // знаходимо найбільший від’ємний
            }
            if (num % 2 == 0 && num < minEven) {
                minEven = num; // знаходимо найменший парний
            }
        }

        
        if (maxNegative == Integer.MIN_VALUE || minEven == Integer.MAX_VALUE) {
            return -1; // якщо не знайдено від’ємних або парних елементів
        }

        return Math.abs(maxNegative) * Math.abs(minEven); // добуток модулів

    }

    public static int findMaxByIndexMultipleOf7(int[] arr) {
        int maxElement = Integer.MIN_VALUE; // ініціалізуємо мінімальним можливим значенням

        for (int i = 0; i < arr.length; i++) {
            if (i % 7 == 0) { // перевірка, чи індекс кратний 7
                if (Math.abs(arr[i]) > Math.abs(maxElement)) {
                    maxElement = arr[i]; // знаходимо максимальний за модулем
                }
            }
        }

        return maxElement;
    }

    public static int[] formArrayC(int[] A, int[] B) {
        int n = A.length; // довжина масивів A та B
        int[] C = new int[2 * n]; // створення масиву C довжиною 2*n

        // Заповнення масиву C поперемінно елементами масивів A та B
        for (int i = 0; i < n; i++) {
            C[2 * i] = A[i];     // елементи з A на парних індексах
            C[2 * i + 1] = B[i]; // елементи з B на непарних індексах
        }

        return C;
    }

    public static void main(String[] args) {
        int[] testArr = {-2, 3, -5, 7, -9, 11, -13, 15, -20, 24, -28}; 

        int result = findProductOfModules(testArr);

        if (result != -1) {
            System.out.println("Добуток модулів найбільшого від’ємного та найменшого парного елементів: " + result + "\n");
        } else {
            System.out.println("Не знайдено від’ємних або парних елементів.\n");
        }

        int[] arr = {-5, 3, -7, 8, 2, -4, 10, -15, 0, -25, 12, 8, -3, -2, 7}; 

        int result0 = findMaxByIndexMultipleOf7(arr);
        
        if (result0 != Integer.MIN_VALUE) {
            System.out.println("Максимальний за модулем елемент, індекс якого кратний 7: " + result0 + "\n");
        } else {
            System.out.println("Не знайдено елементів з індексом, кратним 7.\n");
        }

        int[] A = {1, 3, 5}; // масив A
        int[] B = {2, 4, 6}; // масив B

        int[] C = formArrayC(A, B);
        
        // Виведення масиву C
        System.out.print("Масив C: ");
        for (int i : C) {
            System.out.print(i + " ");
        }
    }
}
