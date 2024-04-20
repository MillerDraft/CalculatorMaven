// Binary calculator class. Entries and outs put are in binary numbers.

import java.util.Stack;

public class BinaryCal extends Calculator{

    public BinaryCal() {
        super();

    }

    // Method in charge of receive first number, second number, operation
    // and give result of that operation. it guided all calculation process.
    // also return result null and terminate the program,
    // if after enter the first number the operation entry is not correct.
    public void calculations(){
        System.out.println("Binary numbers only contain 0 and 1 ex.(0101), with length multiple of 4.");
        String first = promp.setFirst(); // first number entry (String)
        temp = convertBinary_int(first);  // convert(String) first number into number(int)
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
            System.out.println(" = " + convertInt_Binary(ans));
        }
    }
    public int convertBinary_int(String binary){
        int result = 0;
        for (int i = 0; i < binary.length(); i ++){
            char ch = binary.charAt(i);
            int curr = ch - '0';
            if (i == 0){
                result = curr;
            }
            else{
                result = (result * 2) + curr;
            }
        }
        return result;
    }
    public String convertInt_Binary(int num){
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        if (num == 0){ // Special case
            return "0";
        }

        while (num > 0){
            int n = num % 2;
            stack.push(n);
            num /= 2;
        }

        while (!stack.isEmpty()){
            int curr =  stack.pop();
            char ch = (char) (curr + '0');
            sb.append(ch);
        }

        while (sb.length() % 4 != 0){ // Solving the problem with leading zero.
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    // From here all arithmetic methods to ( + , -, *, / ).

    @Override
    public int addition() {
        String second = promp.setSecond();
        int num2 = convertBinary_int(second);
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
        int num2 = convertBinary_int(second);
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
        int num2 = convertBinary_int(second);
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
        int num2 = convertBinary_int(second);
        if (ans == 0){
            ans = temp / num2;
        }
        else{
            ans /= num2;
        }
        return ans;
    }
}
