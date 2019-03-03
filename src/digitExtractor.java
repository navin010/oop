public class digitExtractor {

    int tNumber = 0;        //global var
    String sNumber = "";

    //Contructors
    public digitExtractor(int numberSequence){
        tNumber = numberSequence;       //assign passed in value to global var to be used elsewhere
    }

    public digitExtractor(String numberSequence){
        sNumber = numberSequence;       //assign passed in value to global var to be used elsewhere
    }

    //Methods
    public void returnInvertedOrderByMath(){

        int Integer1 = 0;
        int Integer2 = 0;
        int Integer3 = 0;
        int Integer4 = 0;
        int Integer5 = 0;

        Integer1 = (tNumber % 10);
        Integer2 = (tNumber % 100) / 10;    //division automatically removes the decimals (rounds to floor e.g. 3.67 = 3)
        Integer3 = (tNumber % 1000) / 100;
        Integer4 = (tNumber % 10000) / 1000;
        Integer5 = (tNumber % 100000) / 10000;

        System.out.println(Integer1 + "\n" + Integer2 + "\n" + Integer3 + "\n" + Integer4 + "\n" + Integer5);

    }


    public void returnInvertedOrderByString(){
        char part1;
        char part2;
        char part3;
        char part4;
        char part5;

        part1 = sNumber.charAt(4);
        part2 = sNumber.charAt(3);
        part3 = sNumber.charAt(2);
        part4 = sNumber.charAt(1);
        part5 = sNumber.charAt(0);

        System.out.println(part1 + "\n" + part2 + "\n" + part3 + "\n" + part4 + "\n" + part5);

    }


}
