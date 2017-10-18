package Task2;

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
