public class lab5 {
    public static void selectionSort(float[] arr) {
        int n = arr.length;
        
        // Проходимо по кожному елементу масиву
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            
            // Знаходимо максимальний елемент у решті масиву
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            
            // Міняємо місцями поточний елемент та максимальний
            float temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void insertionSort(float[] arr) {
        int n = arr.length;
        
        
        // Проходимо по кожному елементу масиву
        for (int i = 1; i < n; i++) {
            float key = arr[i];
            int j = i - 1;
            
            // Переміщаємо елементи масиву, які більші за ключ, на одну позицію вправо
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Вставляємо ключ у правильне місце
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        float[] arr = {4.5f, 2.2f, 9.1f, 7.3f, 3.6f};
        float[] arr0 = {4.6f, 2.4f, 9.8f, 7.18f, 3.67f};

        System.out.println("Масив до сортування:");
        for (float num : arr) {
            System.out.print(num + " ");
        }

        selectionSort(arr);

        System.out.println("\nМасив після сортування:");
        for (float num : arr) {
            System.out.print(num + " " );
        }

        System.out.print("\n\n");

        System.out.println("Масив до сортування:");
        for (float num : arr0) {
            System.out.print(num + " ");
        }

        insertionSort(arr0);

        System.out.println("\nМасив після сортування:");
        for (float num : arr0) {
            System.out.print(num + " ");
        }
    }
}
