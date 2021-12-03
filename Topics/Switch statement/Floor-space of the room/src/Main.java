import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String type = scanner.next();
        double a;
        double b;
        double c;
        double r;

        switch (type) {
            case "triangle":
                a = scanner.nextFloat();
                b = scanner.nextFloat();
                c = scanner.nextFloat();
                double p = (a + b + c) / 2; // half of paramiter of triangle
                double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.println(area);
                break;
            case "rectangle":
                a = scanner.nextFloat();
                b = scanner.nextFloat();
                System.out.println(a * b);
                break;
            case "circle":
                r = scanner.nextFloat();
                double pi = 3.14;
                System.out.println(pi * r * r);
                break;
            default:
                break;
        }
    }
}
