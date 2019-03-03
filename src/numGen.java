import java.util.Random;

public class numGen {

    //constructor
    public numGen(){}

    //method
    public int generate(){
        Random rnd = new Random();
        int rndInt = rnd.nextInt(100);      //max value of 100
        return rndInt;
    }


}
