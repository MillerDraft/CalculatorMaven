// Roman calculator class. Entries and outs put are in romans numerals.

import java.util.HashMap;
public class RomanCal extends Calculator {
    private final int DEFAUL = 0; // if operation end in negative value, this will be the result.
    HashMap<Character, Integer> map; //
    public RomanCal() {
        super();
        map = new HashMap<Character, Integer>(){
            {put('I',1); put('V', 5); put('X', 10); put('L', 50);
                put('C' , 100);put('D', 500); put('M', 1000);}
        };


    }

    // Method in charge of receive first number, second number, operation
    // and give result of that operation. it guided all calculation process.
    // also return result null and terminate the program,
    // if after enter the first number the operation entry is not correct.
    public void calculation(){
        System.out.println("Press caps lock to enter roman numerals in capital letters.");
        String first = promp.setFirst(); // first number entry(String)
        temp = convertRom_Arabic(first); // convert(String) first roman numeral to arabic
        String operation = promp.setOperation(); // first operation entry(String)
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
            System.out.println("Calculation aborted due to wrong operation. Bye.");
        }
    }
    // method to make continues entries of numbers and operation and return
    // final result after enter a non-valid operation.
    public void calculationContinue(){
        String operation = promp.setOperation();
        char currOpe = operation.charAt(0);
        if (currOpe == '+'){
            addition();              // call method
            calculationContinue();   // call method
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
            System.out.println(" = " + convertArabic_Rom(ans));
        }
    }


    // methods to convert roman numeral to arabic
    public int convertRom_Arabic(String c){
        int result = 0;
        for (int i = 0; i < c.length(); i ++){
            int curr = map.get(c.charAt(i));
            if (i + 1 < c.length() && curr < map.get(c.charAt(i + 1))){
                result += map.get(c.charAt(i + 1)) - curr;
                i++;
            }
            else{
                result += curr;
            }
        }
        return result;
    }
    // method to convert arabic number to roman numeral;
    public String convertArabic_Rom(int num){
        StringBuilder sb = new StringBuilder();
        int d = num / 1000;
        while (d--> 0){
            sb.append('M');
        }
        num %= 1000;
        if (num >= 900){
            sb.append("CM");
            num -= 900;
        }
        if (num >= 500){
            sb.append('D');
            num -= 500;
        }
        if (num >= 400){
            sb.append("CD");
            num -= 400;
        }
        d = num / 100;
        while(d-- > 0){
            sb.append('C');
        }
        num %= 100;
        if (num >= 90){
            sb.append("XC");
            num -= 90;
        }
        if (num >= 50){
            sb.append('L');
            num -= 50;
        }
        if (num >= 40){
            sb.append("XL");
            num -= 40;
        }
        d = num / 10;
        while (d--> 0){
            sb.append('X');
        }
        num %= 10;
        if (num >= 9){
            sb.append("IX");
            num -= 9;
        }
        if (num >= 5){
            sb.append('V');
            num -= 5;
        }
        if (num >= 4){
            sb.append("IV");
        }
        d = num;
        while (d--> 0){
            sb.append('I');
        }
        num = 0;
        return sb.toString();
    }

    // From here all arithmetic methods to ( + , -, *, / ).
    @Override
    public int addition() {
        String second = promp.setSecond();
        int num2 = convertRom_Arabic(second);
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
        int num2 = convertRom_Arabic(second);
        if (ans == 0){
            ans = temp - num2;
        }
        else{
            ans -= num2;
        }
        return ans > 0 ? ans : DEFAUL ; // if ans is negative set to 0.Roman numeral not
                                       // have negative nor 0 values.
    }

    @Override
    public int multiplication() {
        String second = promp.setSecond();
        int num2 = convertRom_Arabic(second);
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
        int num2 = convertRom_Arabic(second);
        if (ans == 0){
            ans = temp / num2;
        }
        else{
            ans /= num2;
        }
        return (int)ans > 0 ? ans : DEFAUL;
    }
}