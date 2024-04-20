// Parent calculator class.
public abstract class Calculator {
    protected int ans;
    protected int temp;
    Promp promp;

    // Constructor
    public Calculator(){
        temp = 0;
        ans = 0;
        promp = new Promp();
    }
    public abstract int addition();
    public abstract int subtraction();
    public abstract int multiplication();
    public abstract int division();
}


