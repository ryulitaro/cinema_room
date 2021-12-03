import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int sol = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            int item = scanner.nextInt();
            if (sol > item) {
                sol = item;
            }
        }
        System.out.println(sol);
    }
}