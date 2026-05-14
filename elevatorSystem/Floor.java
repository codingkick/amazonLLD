package questions.elevatorSystem;

import java.util.List;

import questions.elevatorSystem.HallButton.HallButtonType;

public class Floor {
    private int floorId;
    private Display display;
    private List<Button> buttons;
    Floor(int floorId, Display display){
        this.floorId = floorId;
        this.display = display;
        this.buttons = List.of(new HallButton(this.floorId, HallButtonType.UP),new HallButton(this.floorId,HallButtonType.DOWN));
    }

    public Display getDisplay(){
        return this.display;
    }
}
