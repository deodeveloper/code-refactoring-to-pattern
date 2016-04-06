package com.bijay.conditional_deferred_execution.after;

/**
 * Created by bijay.deo on 4/6/16.
 */
public class LogingApp {
    public static void main( String[] args){
        LogingApp app = new LogingApp();
        Logger logger = new Logger();

        logger.log(Logger.LogLevel.INFO, () -> app.getMessage());
    }

    public String getMessage(){
        System.out.println("Get message called");
        return "This message is to be logged";
    }
}
