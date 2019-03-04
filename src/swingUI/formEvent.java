package swingUI;

import java.util.EventObject;

public class formEvent extends EventObject {            //EventObject is root of how swing uses events

    //vars
    private String input;
    private String structure;
    private String lineNumber;

    //constructor
    public formEvent(Object source) {
        super(source);                  //source The object on which the Event initially occurred.
    }

    public formEvent(Object source, String input, String structure, String lineNumber) {
        super(source);
        this.input = input;
        this.structure = structure;
        this.lineNumber = lineNumber;
    }

    //methods
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

}
