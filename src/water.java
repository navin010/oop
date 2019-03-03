public class water {

    int tWaterVar = 0;

    //Constructor: default
    public water(){
    }

    //Constructor: with parameter
    public water(int waterAmount){
        tWaterVar = waterAmount;
    }

    //Method: addWater
    public void addWater(int amount){
        tWaterVar = tWaterVar + amount;
    }

    //Method: drinkWater
    public void drinkWater(int amount){
        tWaterVar = tWaterVar - amount;
    }

    //Method: getWater
    public int getWater(){      //returns an int
        return tWaterVar;
    }

}
