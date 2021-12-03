import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    boolean hasLower(String input) {
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if (Character.isLowerCase(aChar)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        // implement this method
        while (true) {
            String input = scanner.next();
            if (hasLower(input)) {
                System.out.println(input.toUpperCase());
            } else {
                break;
            }
        }
        System.out.println("FINISHED");
    }
}