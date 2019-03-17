package pl.n2god.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author n2god on 17/03/2019
 * @project JSP
 */
public class ApplicationStartListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DbUtil.getConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DbUtil.closeConnection();
    }
}
