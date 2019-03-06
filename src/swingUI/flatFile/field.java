package swingUI.flatFile;

public class field {

    //vars
    public String nameOfField;
    public int startPosition;
    public int numberOfChars;
    public int endPosition;

    //constructor
    public field(String nameOfField, int startPosition, int numberOfChars){
        this.nameOfField = nameOfField;
        this.startPosition = startPosition;
        this.numberOfChars = numberOfChars;
        this.endPosition = startPosition + numberOfChars;
    }

    //methods
    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getNumberOfChars() {
        return numberOfChars;
    }

    public void setNumberOfChars(int numberOfChars) {
        this.numberOfChars = numberOfChars;
    }

    public String getNameOfField() {
        return nameOfField;
    }

    public void setNameOfField(String nameOfField) {
        this.nameOfField = nameOfField;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public void showField(){
        System.out.println("nameOfField:" + this.nameOfField + " startPosition:" + this.startPosition + " numberOfChars:" + this.numberOfChars + " endPosition:" + this.endPosition);
    }

}
