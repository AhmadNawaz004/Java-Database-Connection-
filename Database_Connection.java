import java.sql.*;


/**
 * A Java MySQL INSERT example.
 * Demonstrates the use of a SQL INSERT statement against a
 * MySQL database, called from a Java program, using a
 * Java Statement (not a PreparedStatement).
 * 
 * Created by Alvin Alexander, http://devdaily.com
 */
public class Database_Connection
{

  public static void main(String[] args)
  {
    try
    {
      // create a mysql database connection
     // String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost/multiple attributes";
      //Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
      
      String query = "SELECT * FROM multiple_attributes";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        String PID = rs.getString("PID");
        String Gender = rs.getString("Gender");
        int  Age= rs.getInt("Age");
        String ZipCode = rs.getString("Zip Code");
        String TypeCancer = rs.getString("Type of Cancer");
        String Symptom = rs.getString("Symptom");
        String Diagnosis  = rs.getString("Cancer Treatment");
        Date DianosisDate = rs.getDate("Diagnoses Date");
        String Physicisn= rs.getString("Physician");
        String DI= rs.getString("Method of diagonises");
        
        
        // print the results
        System.out.format("%s, %s,%d, %s, %s, %s, %s,%s,%s,%s\n",PID, Gender, Age, ZipCode,TypeCancer,Symptom,Diagnosis, DianosisDate,Physicisn,DI);
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
      e.printStackTrace();
    }

  }
}
