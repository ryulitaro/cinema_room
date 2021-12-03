import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        for (int i = 0; i < 4; i++) {
            int number = scanner.nextInt();
            System.out.print(number - 1);
            System.out.print(" ");
        }
    }
}
