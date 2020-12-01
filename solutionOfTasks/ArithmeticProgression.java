class ArithmeticProgression { // Вычесление арифмитической прогрессии
    Scanner scanner = new Scanner(System.in);
    int a;// начальное значение
    int b;// шаг
    int c;// количество первых членов которые нужно просуммировать
    int n; // количество тестов

    void sumOfNumbers() {
        System.out.println("Введите количество тестов:");
        n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите начальное значение:");
            a = scanner.nextInt();
            System.out.println("Введите шаг:");
            b = scanner.nextInt();
            System.out.println("Введите количество первых членов которые нужно просуммировать");
            c = scanner.nextInt();
            int sum = foo(a, b, c);
            System.out.println(sum);
        }
    }

    int foo(int a, int b, int c) {
        int result = a;
        int s = 1;
        while ((c - 1) > 0) {
            result = result + (a + (s * b));
            c--;
            s++;
        }
        return result;
    }


}

class ArithmeticProgressionTest {
    public static void main(String[] args) {
        ArithmeticProgression ap = new ArithmeticProgression();
        ap.sumOfNumbers();
    }
}
