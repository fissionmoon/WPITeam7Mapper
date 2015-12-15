package edu.wpi.off.by.one.errors.code.model;

/**
 * @author Jules Voltaire on 12/14/2015.
 * @author Nathan Beeten
 */
public class Step {
    //region attributes
    private Node starNode;
    private Node endNode;
    private String instruction;
    //endregion

    public Step(Node starNode, Node endNode){
        this.starNode = starNode;
        this.endNode = endNode;
        this.instruction = "";
    }

    @Override
    public String toString(){
        return this.instruction;
    }
}
