package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        Logger cl;
        cl = new ConsoleLogger();
        return cl;

    }
}
