package fr.lernejo.logger;

public class CompositeLogger implements Logger{

    private Logger Logger1;
    private Logger Logger2;

    public CompositeLogger(Logger firstLogger, Logger secondLogger) {
        this.Logger1 = firstLogger;
        this.Logger2 = secondLogger;
    }

    @Override
    public void log(String message) {
        Logger1.log(message);
        Logger2.log(message);
    }
}
