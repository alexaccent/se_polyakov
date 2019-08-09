package sef.module18.activity;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class EmployeeRepositoryTest extends TestCase {

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

    public void testFindEmployeeByID() {
        try {
            EmployeeRepository e = new EmployeeRepositoryImpl(conn);
            assertEquals(e.findEmployeeByID(1),"Sasha");
            
        } catch (AssertionFailedError e) {
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
        } catch (HRSSystemException e) {
            fail();
        }
    }


    public void testFindEmployeeByName() {
        try {
            EmployeeRepository e = new EmployeeRepositoryImpl(conn);

            Employee em1 = new EmployeeImpl(10, "James", "Gosling",1);
            Employee em2 = new EmployeeImpl(11, "Bjarne", "Stroustrup",2);
            Employee em3 = new EmployeeImpl(12, "Alan", "Kay",3);

            e.insertEmployee(em1);
            e.insertEmployee(em2);
            e.insertEmployee(em3);

            List<Employee> emList1 = e.findEmployeeByName("James","Gosling");
            List<Employee> emList2 = e.findEmployeeByName("Bjarne","Stroustrup");
            List<Employee> emList3 = e.findEmployeeByName("Alan","Kay");

            assertTrue(emList1.contains(em1));
            assertTrue(emList2.contains(em2));
            assertTrue(emList3.contains(em3));

        } catch (AssertionFailedError e) {
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
        } catch (HRSSystemException e) {
            fail();
        }
    }

    public void testFindEmployeeByProfLevel() {
        try{
            EmployeeRepository e = new EmployeeRepositoryImpl(conn);

            Employee em1 = new EmployeeImpl(25, "James", "Gosling",1);
            List<Employee> emList =  e.findEmployeeByProfLevel(1);

            assertTrue(emList.contains(em1));

        } catch (AssertionFailedError e) {
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
        } catch (HRSSystemException e) {
            fail();
        }
    }

    public void testUpdateEmployee() {
        try{
            EmployeeRepository e = new EmployeeRepositoryImpl(conn);

            Employee em1 = new EmployeeImpl(25, "Alan", "Gosling",1);
            boolean emList =  e.updateEmployee(em1);

            assertTrue(emList);

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
