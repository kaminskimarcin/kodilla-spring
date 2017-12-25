package com.kodilla.patterns.singleton;

public class Logger {
    private static Logger loggerInstance;
    private String lastLog = "";

    private Logger() {}

    public static Logger getInstance() {
        if(loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public void Log(String log) {
        lastLog = log;
        System.out.println("Log: {" + log + "]");
    }

    public String getLastLog() {
        return lastLog;
    }
}
