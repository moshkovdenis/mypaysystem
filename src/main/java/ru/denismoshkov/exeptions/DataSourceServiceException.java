package ru.denismoshkov.exeptions;



public class DataSourceServiceException extends Exception {

    public DataSourceServiceException () {
        super();
    }

    public DataSourceServiceException(String message) {
        super(message);
    }
}
