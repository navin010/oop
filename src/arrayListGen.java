import java.util.ArrayList;
import java.util.Scanner;


public class arrayListGen {

    static Scanner reader = new Scanner(System.in);
    static ArrayList<Integer> array = new ArrayList<Integer>();

    //constructor
    public arrayListGen(){}

    //method
    public void createList(){
        System.out.println("enter array of int, put zero when done");
        int in = reader.nextInt();
        while (in != 0){
            array.add(in);
            in = reader.nextInt();      //ask for another int
        }
    }

    public void showList(){
        System.out.println("-------------------");
        for(int i : array){                 //loop through array
            System.out.println(i);          //print each array value
        }
    }

    public void deleteNumber(){
        System.out.println("what you want to delete");
        int del = reader.nextInt();

        for(int i = 0; i < array.size(); i++){
            if(array.get(i) == del){
                array.remove(del);
                break;
            }
        }
        //break leads here
        showList();

    }

}
