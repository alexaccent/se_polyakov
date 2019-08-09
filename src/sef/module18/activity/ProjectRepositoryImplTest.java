package sef.module18.activity;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProjectRepositoryImplTest extends TestCase {
    private Connection conn;
    private String url ;
    private String username;
    private String password;
    Log logger = LogFactory.getLog(this.getClass());

    protected void setUp() throws Exception {
        super.setUp();
        username = "sa";
        password = "";
        Class.forName("org.h2.Driver");
        url = "jdbc:h2:~/test";
        conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);
        System.out.println("Connection successfully established!");
    }

    public void testFindProjectByID() {
        try {

            ProjectRepository e = new ProjectRepositoryImpl(conn);
            Project project = new ProjectImpl(9, "Online Insurance System", "A web application that automates insurance transactions.");
            assertEquals(project, e.findProjectByID(9));

        } catch (AssertionFailedError e) {
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
        } catch (HRSSystemException e) {
            fail();
        }
    }

    protected void tearDown() throws Exception {
        try{
            super.tearDown();
            conn.close();
            System.out.println("Connection closed!");
        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            logger.error(sef.module.percentage.Percentage.setFailedCount(true,4));
        }
    }
}
