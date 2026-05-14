package questions.elevatorSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorController {
    private static volatile ElevatorController instance;
    private List<Elevator> elevators;
    private Map<Integer,Floor> floors;
    private AssignmentStrategy assignmentStrategy;
    private final ExecutorService executorService;

    private ElevatorController(int n){
        this.floors = new HashMap<>();
        this.assignmentStrategy = new RandomStrategy(elevators);
        this.executorService = Executors.newFixedThreadPool(n);
        elevators = new ArrayList<>();
        for(int i=0;i<n;i++)
            this.addElevator(ElevatorFactory.createElevator(i));
        elevators.forEach(elevator -> executorService.submit(elevator));
    }
    public static void initialize(int n){
        if(instance == null){
            synchronized(ElevatorController.class){
                if(instance == null)
                    instance = new ElevatorController(n);
            }
        }
    }

    public static ElevatorController getInstance(){
        if (instance == null) {
            throw new IllegalStateException("ElevatorController not initialized!");
        }
        return instance;
    }

    public Elevator handleHallCall(Request r){
        Elevator elevator = this.assignmentStrategy.getElevator();
        elevator.addObserver(floors.get(r.getSourceFloorId()).getDisplay());
        return elevator;
    }

    public void addElevator(Elevator elevator){
        this.elevators.add(elevator);
    }

    public void updateAssignementStrategy(AssignmentStrategy assignmentStrategy){
        this.assignmentStrategy = assignmentStrategy;
    }

    public void shutDown(){
        executorService.shutdown();
        
    }
}
