import java.util.Scanner;

public class userInput {

    //Constructor
    public userInput(){
    }

    //Methods
    public String getUserInputDigits(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 5 digits");
        String inputVal = input.nextLine();
        return inputVal;
    }

    public String getUserInputGeneral(String s){
        Scanner input = new Scanner(System.in);
        System.out.println(s);
        String inputVal = input.nextLine();
        return inputVal;
    }


}
