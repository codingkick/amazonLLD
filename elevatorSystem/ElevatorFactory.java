package questions.elevatorSystem;

public class ElevatorFactory {
    public static Elevator createElevator(int elevatorId){
        return new Elevator(elevatorId);
    }
}
