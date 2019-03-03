import java.util.ArrayList;
public class testObjectIntro {

    public static void main(String[] args) {
        //Water Adding and Subtracting
        String x = "Hello";
        water waterBottle = new water(0); //create type water object (same as int, string etc.) of name waterBottle, create new instance of water using non default constructor
        waterBottle.addWater(5);
        System.out.println("waterValue: " + waterBottle.getWater());
        waterBottle.drinkWater(3);
        System.out.println("waterValue: " + waterBottle.getWater());

        //Number Generator
        numGen genObject = new numGen();
        int genVal = genObject.generate();
        System.out.println("numGen: " + genVal);

        numGen genObject2 = new numGen();
        int genVal2 = genObject2.generate();
        System.out.println("numGen2: " + genVal2);

        //Arrays
        int arrInt[] = new int[5];  //new array of size 5 (0-4)
        arrInt[0] = 1;
        int i = 0;
        while (i <=4){
            arrInt[i] = i+1;
            i++;
        }
        System.out.println(arrInt[0] + " " + arrInt[1] + " " + arrInt[2] + " " + arrInt[3] + " " + arrInt[4]);

        //Digit Extractor
        userInput userInputObj = new userInput();
        String userInputVal = userInputObj.getUserInputDigits();

        System.out.println("Math extraction");
        digitExtractor extractorMathObj = new digitExtractor(Integer.parseInt(userInputVal));
        extractorMathObj.returnInvertedOrderByMath();

        System.out.println("String extraction");
        digitExtractor extractorStringObj = new digitExtractor(userInputVal);
        extractorStringObj.returnInvertedOrderByString();

        //jOption Pane
        jOptionPaneAndDoubles fing = new jOptionPaneAndDoubles();
        fing.fingers();
        fing.fingers_double();

        //Array List
        arrayListGen alg = new arrayListGen();
        alg.createList();
        alg.showList();
        alg.deleteNumber();

    }

}
