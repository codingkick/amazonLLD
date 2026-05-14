package questions.elevatorSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Elevator implements Runnable {
    private int elevatorId;
    private LinkedBlockingQueue<Request> requests;
    private List<Observer> observers;
    private ElevatorState elevatorState;
    Elevator(int elevatorId){
        this.elevatorId = elevatorId;
        this.requests = new LinkedBlockingQueue<>();
        this.observers = new ArrayList<>();
        this.elevatorState = ElevatorState.IDLE;
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    public void notifyObservers(){
        this.observers.forEach(observer -> observer.update());
    }

    public void handleCabinCall(Request r){
        try{
            requests.put(r);
        }
        catch(Exception e){
            System.err.println("Could not add the request due to "+e.getMessage());
        }
    }

    public void run(){
        while(true){
            try{
                Request request = requests.take();
                System.out.println("handled the cabin requests with direction "+request.getDirection());
            }
            catch(Exception e){
                System.err.println("Error due to "+e.getMessage());
                break;
            }
        }
    }
}
