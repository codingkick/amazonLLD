# Logging system lld

1. Asynchronous logging, multiple strategies like file based logger or console logger
2. Use of concurrent data structure to publish and consume from it.

Entites:
1. LoggingSystem (singleton)
2. LogLevel -> INFO, DEBUG, WARN, ERROR
3. FileLogger
4. ConsoleLogger
5. Log
