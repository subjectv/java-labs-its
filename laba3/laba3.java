// 4 6 13
//завдання 4
class lab3 {
    public static double sSum4(double a, double b, int k) {
        if (k > 30) {
            throw new IllegalArgumentException("k повинно бути більше рівне 30");
        }
        
        double sum = 0.0;
        for (int i = 1; i <= k; i++) {
            sum += Math.sqrt(a * i * Math.sqrt(b / i));
        }
        
        return sum;
    }

// завдання 6
    public static double x(double t, int i) {
        switch (i) {

        case 1:
            return Math.sqrt(t);
        case 2:
            return 1 / Math.sqrt(t);
        default:
            double sum = 0;
            for (int k = 1; k <= i; k++) {
                sum += k * t;
            }
        return sum;
        }
    }

// завдання 13
    public static double sum13(double epsilon) {
    double sum = 0;
    double factorial = 1;
    int i = 1;

    while (true) {
        double term = Math.pow(-1, i) / factorial;
        sum += term;

        if (Math.abs(term) < epsilon) {
            break;
        }

        factorial *= i;
        i++;
    }

    return sum;
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