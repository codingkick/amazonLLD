package questions.elevatorSystem;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements AssignmentStrategy {
    List<Elevator> elevators;
    RandomStrategy(List<Elevator> elevators){
        this.elevators = elevators;
    }
    public Elevator getElevator(){
        System.out.println("Handling the request came with dir "+r.getDirection().toString());
        int n = elevators.size();
        Random random = new Random();
        int val = random.nextInt(n);
        return elevators.get(val);
    }
}
