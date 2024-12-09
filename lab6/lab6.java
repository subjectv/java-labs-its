package lab6;
public class lab6 {

    // Метод для перетворення цілого числа в бінарний рядок
    public static String intToBinaryString(int i) {
        // Використовуємо вбудований метод Integer.toBinaryString для конвертації числа в бінарний рядок
        return Integer.toBinaryString(i);
    }
    
    // Метод для перетворення слів у реченні на великі літери
    public static String toUppercaseWords(String sentence) {
        // Розділяємо речення на окремі слова за пробілами
        String[] words = sentence.split(" ");
        // Створюємо StringBuilder для ефективного з'єднання слів
        StringBuilder result = new StringBuilder();
    
        
        // Перебираємо всі слова
        for (String word : words) {
            // Якщо слово складається лише з літер (a-z або A-Z)
            if (word.matches("[a-zA-Z]+")) {
                // Перетворюємо слово на великі літери і додаємо до результату
                result.append(word.toUpperCase()).append(" ");
            } else {
                // Якщо слово містить інші символи, додаємо його без змін
                result.append(word).append(" ");
            }
        }
    
        // Повертаємо рядок без зайвих пробілів в кінці
        return result.toString().trim();
    }
    
        public static void main(String[] args) {
            int number = 21;
            String binaryString = intToBinaryString(number);
            System.out.println("Двійкове представлення числа " + number + ": " + binaryString);
    
            String input = "The user with the nickname koala757677 this month wrote 3 times more comments than the user with the nickname croco181dile920 4 months ago";
            String output = toUppercaseWords(input);
            System.out.println(output);
        }
    }
    