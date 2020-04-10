package ru.denismoshkov.services;

import lombok.extern.slf4j.Slf4j;
import ru.denismoshkov.enums.DbProperty;
import ru.denismoshkov.exeptions.DataSourceServiceException;
import ru.denismoshkov.exeptions.PropertyReaderException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class DataSourceService {
    private Properties properties;
    private Connection connection;

    public DataSourceService() {
        try {
            properties = ReadPropertiesService.readDataSourceProperty();
        }catch (PropertyReaderException e) {
            log.error("Ошибка при получении данных для подключение к БД ", e);
        }
    }

    private Connection getConnection() throws DataSourceServiceException {
        String driverName = properties.getProperty(DbProperty.DRIVER_NAME_PROPERTY_NAME.getProperty());
        String url = properties.getProperty(DbProperty.URL_PROPERTY_NAME.getProperty());
        String user = properties.getProperty(DbProperty.USER_PROPERTY_NAME.getProperty());
        String password = properties.getProperty(DbProperty.PSSWD_PROPERTY_NAME.getProperty());
        try {
            Class.forName(driverName);
            return DriverManager.getConnection(url, user, password);
        }catch (ClassNotFoundException | SQLException e) {
            String errorMessage = String.join(" ", "Ошибка при попытке получить подключение к БД", url);
            log.error(errorMessage , e);
            throw new DataSourceServiceException(errorMessage);
        }
    }

    public PreparedStatement getPreparedStatement(String query) throws DataSourceServiceException {
        try {
            connection = getConnection();
            if (connection != null) {
                return connection.prepareStatement(query);
            } else {
                String errorMessage = String.join(" ", "Не удалось получить подключение при создании"
                        + "подготовленного выражения для запроса", query);
                log.error(errorMessage);
                throw new DataSourceServiceException(errorMessage);
            }
        } catch (SQLException e) {
            String errorMessage = String.join(" ", "Ошибка при попытке получить подготовленного " +
                    "выражения для запроса в БД", query);
            log.error(errorMessage, e);
            throw new DataSourceServiceException(errorMessage);
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Error while trying to close jdbc connection");
            }
        }
    }
}
