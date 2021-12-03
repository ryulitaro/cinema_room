import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        char[][] spaces = new char[size][size];
        int middle = size / 2;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == middle || j == middle) {
                    spaces[i][j] = '*';
                } else if (i == j) {
                    spaces[i][j] = '*';
                } else if (i + j == size - 1) {
                    spaces[i][j] = '*';
                } else {
                    spaces[i][j] = '.';
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(spaces[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
