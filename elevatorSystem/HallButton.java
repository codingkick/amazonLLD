package questions.elevatorSystem;

public class HallButton implements Button {
    private HallButtonType hallButtonType;
    private int floorId;
    public enum HallButtonType{
        UP,
        DOWN;
    }
    HallButton(int floorId, HallButtonType hallButtonType){
        this.hallButtonType = hallButtonType;
        this.floorId = floorId;
    }

    public void click(){
        System.out.println(hallButtonType.toString());
        ElevatorController.getInstance().handleHallCall(new Request(1,-1,null));
    }
}
