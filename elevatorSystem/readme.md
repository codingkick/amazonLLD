# Elevator system lld

Requirements:
1. Multiple floors.
2. Floor contains display and panel containing button to go up/down
3. Panel inside the lift to decide the floor.
4. Multiple elevator in an elevator system.
5. Considering only one building.
6. Elevator state can be IDLE, MOVING_UP, MOVING_DOWN, FAULTY

Flow:
User pushes a up/down button on a floor -> Request goes to elevator controller (singleton) -> a lift is assigned
from the list of working lifts using some strategy to fulfill this request -> Request goes to elevator ->
elevator location and movement is updated on the floor display -> user go inside the lift and pushes the destination floor button -> elevator starts moving towards it.

Learning:
Used executorservice to run multiple lifts in parallel to the main thread to handle the requests.

Elevator class is a subclass of the Runnable interface.
