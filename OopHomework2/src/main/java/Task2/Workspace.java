package Task2;

import Task1.Pen;
import Task3.Scissors;
import Task3.Size;

import java.awt.*;
import java.util.ArrayList;

public class Workspace {
    private String employeeName="";
    private ArrayList<Stationary> stationers=new ArrayList<>();

    private Workspace(){

    }

    public Workspace(String employeeName) {
        this.employeeName = employeeName;
    }

    public Workspace(String employeeName, ArrayList<Stationary> stationers) {
        this.employeeName = employeeName;
        this.stationers = (ArrayList<Stationary>) stationers.clone();
    }

    /**
     * Calculate total price of stationers on workspace
     *
     * @return integer result
     */
    public Integer calculateTotalPrice(){
        Integer result=0;
        for(Stationary stationary:stationers){
            result+=stationary.getPrice();
        }
        return result;
    }

    /**
     * Return "novice pack" of stationers for giving employee. It contains blue pen,
     * 20sm ruler and medium scissors.
     * @param employeeName name of employee
     * @return <code>Workspace</code> with "novice pack" for employee with name <code>employeeName</code>
     */
    public static Workspace getNovicePack(String employeeName){
        ArrayList<Stationary> stationaries=new ArrayList<>();
        stationaries.add(new Pen(Color.blue,20));
        stationaries.add(new Ruler(50,20));
        stationaries.add(new Scissors(100, Size.MEDIUM));
        return new Workspace(employeeName,stationaries);
    }

    public Workspace addStationary(Stationary stationary){
        stationers.add(stationary);
        return this;
    }

    public void resetStationers(){
        stationers=new ArrayList<>();
    }

    public Workspace setStationers(ArrayList<Stationary> stationers) {
        this.stationers = (ArrayList<Stationary>) stationers.clone();
        return this;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public ArrayList<Stationary> getStationers() {
        return stationers;
    }

    @Override
    public String toString() {
        return "Workspace{" +
                "employeeName='" + employeeName + '\'' +
                ", stationers=" + stationers +
                '}';
    }
}
