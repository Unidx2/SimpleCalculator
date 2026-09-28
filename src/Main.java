import java.util.Scanner;

public class Main {
    static boolean calculation(Scanner sc){
        String readLine = sc.nextLine();

        if(readLine.isEmpty()){
            return true;
        }
        if (readLine.equalsIgnoreCase("done")){
            System.out.println("Thank you for using the calculator");
            return false;
        }


        Scanner lineScanner = new Scanner(readLine);
        try{
            double calc = Double.parseDouble(lineScanner.next());

            while(lineScanner.hasNext()) {
                String symbol = lineScanner.next();

                switch (symbol.charAt(0)) {
                    case '+':
                        calc += lineScanner.nextDouble();
                        break;
                    case '-':
                        calc -= lineScanner.nextDouble();
                        break;
                    case '*':
                        calc *= lineScanner.nextDouble();
                        break;
                    case '/':
                        calc /= lineScanner.nextDouble();
                        break;
                    default:
                        System.out.println("Something is wrong with your equation");
                        return true;
                }
            }

            System.out.println("Result: " + calc);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        return true;
    }


    public static void main(String[] args) {
        String padding = "###############################################";
        String message = "Welcome to my SimpleCalculator (On Java)";
        System.out.printf("%1$s %n%2$43s %n%1$s %n", padding, message);

        try (Scanner sc = new Scanner(System.in)){
            boolean keepRunning = true;

            while(keepRunning){
                System.out.println("Enter equation you want to solve (Or write \"done\" to close the program):");

                try {
                    keepRunning = calculation(sc);
                }catch (Exception e){
                    System.out.println("Please recheck your values, make sure it is a number");
                }
            }
        }
    }
}