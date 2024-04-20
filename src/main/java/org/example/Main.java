public class Main {
    public static void main(String[] args) {
        StandardCal stand = new StandardCal();
        stand.calculations();
        System.out.println("........................");

        RomanCal romana = new RomanCal();
        romana.calculation();
        System.out.println(".............................");

        BinaryCal bina = new BinaryCal();
        bina.calculations();
        System.out.println("End");

    }
}