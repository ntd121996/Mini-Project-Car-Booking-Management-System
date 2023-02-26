import java.util.Scanner;
public class InputHandler {
    private final Scanner input = new Scanner(System.in);
    public int getInputNumber(){
        int number = input.nextInt();
        return number;
    }
    public double getInputFloatNumber(){
        double number = input.nextFloat();
        return number;
    }
    public String getInputString(){
        String myString = input.next();
        return myString;
    }
}