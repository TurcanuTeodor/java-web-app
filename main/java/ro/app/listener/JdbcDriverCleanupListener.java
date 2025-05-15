package ro.app.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class JdbcDriverCleanupListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(JdbcDriverCleanupListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Deregister JDBC drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            if (driver.getClass().getClassLoader() == getClass().getClassLoader()) {
                try {
                    DriverManager.deregisterDriver(driver);
                    logger.info("Deregistered JDBC driver: {}", driver);
                } catch (SQLException e) {
                    logger.error("Error deregistering JDBC driver: {}", driver, e);
                }
            }
        }
    }
}   
