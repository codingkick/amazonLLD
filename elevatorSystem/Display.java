package questions.elevatorSystem;

public class Display implements Observer {
    private int displayId;
    Display(int displayId){
        this.displayId = displayId;
    }
    public void update(){
        System.out.println("notifying observer "+ displayId);
    }
}
