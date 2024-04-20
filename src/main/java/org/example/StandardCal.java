// That's a regular calculator class
public class StandardCal extends Calculator{

    // Constructor
    public StandardCal() {
        super();

    }

    // Method in charge of receive first number, second number, operation
    // and give result of that operation. it guided all calculation process.
    // also return result null and terminate the program,
    // if after enter the first number the operation entry is not correct.
    public void calculations(){
        String first = promp.setFirst(); // first number entry (String)
        temp = Integer.parseInt(first);  // convert(String) first number into number(int)
        String operation = promp.setOperation(); // first operation entry(String)
        char currOpe = operation.charAt(0); // variable to store operation(String) as (char)
        if (currOpe == '+'){
            addition();   // call to add method
            calculationContinue(); // call method
        }
        else if (currOpe == '-'){
            subtraction();
            calculationContinue();
        }
        else if (currOpe == '*'){
            multiplication();
            calculationContinue();
        }
        else if (currOpe == '/'){
            division();
            calculationContinue();
        }
        else{
            System.out.println("Calculation aborted due to wrong operation. Bye.");
        }
    }

    // method to make continues entries of numbers and operation and return
    // final result after enter a non-valid operation.
    public void calculationContinue(){
        String operation = promp.setOperation();
        char currOpe = operation.charAt(0);
        if (currOpe == '+'){
            addition();
            calculationContinue();
        }
        else if (currOpe == '-'){
            subtraction();
            calculationContinue();
        }
        else if (currOpe == '*'){
            multiplication();
            calculationContinue();
        }
        else if (currOpe == '/'){
            division();
            calculationContinue();
        }
        else{
            System.out.println(" = " + ans);
        }

    }

    // From here all arithmetic methods to ( + , -, *, / ).

    @Override
    public int addition() {
        String second = promp.setSecond();
        int num2 = Integer.parseInt(second);
        if (ans == 0){
            ans = temp + num2;
        }
        else{
            ans += num2;
        }
        return ans;
    }

    @Override
    public int subtraction() {
        String second = promp.setSecond();
        int num2 = Integer.parseInt(second);
        if (ans == 0){
            ans = temp - num2;
        }
        else{
            ans -= num2;
        }
        return ans;
    }

    @Override
    public int multiplication() {
        String second = promp.setSecond();
        int num2 = Integer.parseInt(second);
        if (ans == 0){
            ans = temp * num2;
        }
        else{
            ans *= num2;
        }
        return ans;
    }

    @Override
    public int division() {
        String second = promp.setSecond();
        int num2 = Integer.parseInt(second);
        if (ans == 0){
            ans = temp / num2;
        }
        else{
            ans /= num2;
        }
        return ans;
    }

}
