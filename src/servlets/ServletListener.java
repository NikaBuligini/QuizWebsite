package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.DBConnection;
import model.WebVariables;

/**
 * Application Lifecycle Listener implementation class ServletListener
 * mxolod konteqstis lifecycle
 */
@WebListener
public class ServletListener implements ServletContextListener, WebVariables {

	private DBConnection db;
	
    /**
     * Default constructor. 
     */
    public ServletListener() {
        
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
    	db = new DBConnection();
    	ServletContext context = sce.getServletContext();
    	context.setAttribute(CONNECTION, db.getConnection());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
    	db.close();
    }
	
}
