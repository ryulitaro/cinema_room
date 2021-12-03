import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        // write your code here
        if (val == null) {
            return 0;
        }
        if (val > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (val < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) (long) val;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long newval = Long.parseLong("4321");
        Long newval3 = new Long("3241");
        Long newval2 = 4321L;
        System.out.println(newval);
        System.out.println(newval2);
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
    }
}