package questions.elevatorSystem;

public class Request {
    private int source;
    private int destination;
    private Direction direction;
    Request(int source, int destination, Direction direction){
        this.source = source;
        this.destination = destination;
        this.direction = direction;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public int getSourceFloorId(){
        return this.source;
    }
}
