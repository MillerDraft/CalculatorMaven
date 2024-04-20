import java.util.Scanner;
public class Promp {
    private String first;
    private String second;
    private String operation;

    // Constructor
    public Promp() {
        this.first = first;
        this.second = second;
        this.operation = operation;
    }

    // Method for user enter first number and store it in variable first
    public String setFirst() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number: ");
        first = in.nextLine();
        return first;
    }

    // Method for user enter one of the mathematics operations( +,-,*,/ ) and store it in variable operation
    public String setOperation() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter operation: ( + , - , * , / )");
        operation = in.nextLine();
        return operation;
    }

    // Method for user enter the second number and store it in variable second, also
    // it will be used for enter all numbers from now on;
    public String setSecond() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number: ");
        second = in.nextLine();
        return second;
    }
}
