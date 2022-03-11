package fr.lernejo.logger;

public class CompositeLogger implements Logger{
    private Logger logger1;
    private Logger logger2;

    public CompositeLogger(Logger firstLogger, Logger secondLogger) {
        this.logger1 = firstLogger;
        this.logger2 = secondLogger;
    }

    @Override
    public void log(String message) {
        logger1.log(message);
        logger2.log(message);
    }
}
