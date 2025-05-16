package ro.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

@Component
public class HikariShutdownBean implements DisposableBean {

    private final DataSource dataSource;

    public HikariShutdownBean(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void destroy() throws Exception {
        if (dataSource instanceof HikariDataSource hikariDataSource) {
            hikariDataSource.close();
            System.out.println("HikariCP connection pool shutdown completed");
        }
    }
}