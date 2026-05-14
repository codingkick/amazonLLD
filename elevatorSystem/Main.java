package questions.elevatorSystem;

import java.util.List;

import questions.elevatorSystem.HallButton.HallButtonType;

public class Main {
    public static void main(String[] args) {
        ElevatorController elevatorController = ElevatorController.getInstance(4);
        Button hallButton = new HallButton(HallButtonType.UP);
        Floor floor1 = new Floor(new Display(1), cabinButtons);
        
    }
}
