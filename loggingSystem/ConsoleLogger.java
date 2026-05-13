package questions.loggingSystem;

public class ConsoleLogger implements Logger {
    
    @Override
    public void log() {
        System.out.println("Logging to console...");
    }
}
