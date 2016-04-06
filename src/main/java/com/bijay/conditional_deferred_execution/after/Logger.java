package com.bijay.conditional_deferred_execution.after;

import java.util.function.Supplier;

/**
 * Created by bijay.deo on 4/6/16.
 */
public class Logger {
    public static LogLevel defaultLogLevel = LogLevel.WARN;

    public enum LogLevel {FINE, DEBUG, WARN, INFO}

    //Supplier for lazy evaluation
    public void log(LogLevel logLevel, Supplier<String> msg){
        if(defaultLogLevel.ordinal() > logLevel.ordinal())
            System.out.println(logLevel.name() + " : " + msg.get());
    }

}
