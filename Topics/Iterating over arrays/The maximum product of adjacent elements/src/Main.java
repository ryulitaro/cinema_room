import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pre = 1;
        int multi = 0;
        for (int i = 0; i < n; i++) {
            int item = scanner.nextInt();
            if (pre * item > multi) {
                multi = pre * item;
            }
            pre = item;
        }
        System.out.println(multi);
    }
}