import java.lang.Math;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void calculation(char b, double firstNumber, double secondNumber){
        double sum, mul, sub, div;

        switch (b) {
            case '+':
                sum = firstNumber + secondNumber;
                System.out.println(sum);
                break;
            case '-':
                sub = firstNumber - secondNumber;
                System.out.println(sub);
                break;
            case '*':
                mul = firstNumber * secondNumber;
                System.out.println(mul);
                break;
            case '/':
                div = firstNumber / secondNumber;
                System.out.println(div);
                break;
            default:
                System.out.println("Something is wrong with your equation");
        }
    }


    public static void main(String[] args) {
        String padding = "###############################################";
        String message = "Welcome to my SimpleCalculator (On Java)";
        System.out.printf("%1$s %n%2$43s %n%1$s %n%n%nEnter the equation you want to solve:", padding, message);

        try (Scanner sc = new Scanner(System.in)) {

            while (sc.hasNext()) {
                String firstInput = sc.next();

                if (firstInput.equalsIgnoreCase("done")) {
                    System.out.println("Thank you for using the calculator");
                    break;
                }

                try {
                    double firstNumber = Double.parseDouble(firstInput);
                    char b = sc.next().charAt(0);
                    double secondNumber = sc.nextDouble();
                    calculation(b,firstNumber,secondNumber);
                    System.out.println("Enter the equation you want to solve:");

                } catch (Exception e) {
                    System.out.println("Please recheck your values, make sure it is a number");
                    System.out.println("Enter the equation you want to solve:");
                    sc.nextLine(); //To clear the input
                }
            }
        }
    }
}