package questions.loggingSystem;

public class Log {
    private String logId;
    private String message;
    private LogLevel logLevel;
    private long timestamp;

    public Log(String logId, String message, LogLevel logLevel) {
        this.logId = logId;
        this.message = message;
        this.logLevel = logLevel;
        this.timestamp = System.currentTimeMillis();
    }

    public String getLogId() {
        return logId;
    }

    public String getMessage() {
        return message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
