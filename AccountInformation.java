import java.sql.*;

public class AccountInformation {
    public static int uID;
    String uName;
    String fName;
    String lName;
    int Cash;

    public String getUName() {

        return uName;
    }
    public String getFName() {
        return  fName;
    }
    public String getLName() {
        return lName;
    }

    public int getCash() {
        try {
            PreparedStatement ps;
            String query = "SELECT u_cash FROM account WHERE u_id = ?";

            // Connect to the database
            // Connection connection = DriverManager.getConnection(url, user, password);
            ps = MyConnection.getConnection().prepareStatement(query);
      
            // Prepare the SQL statement
            ps.setInt(1, uID);
      
            // Execute the query
            ResultSet resultSet = ps.executeQuery();
      
            // Retrieve the value of u_cash
            if (resultSet.next()) {
              int uCash = resultSet.getInt("u_cash");
              System.out.println("The u_cash value for ID " + uID + " is " + uCash);
              this.Cash = uCash;
            } else {
              System.out.println("No record found for ID " + uID);
            }
      
            // Clean up resources
            resultSet.close();
            ps.close();
            // connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Cash;
    }

    public void setUName(String UserName) {
        this.uName= UserName;
    }

    public void getID(String uName) {
        try {
            PreparedStatement ps;
            String query = "SELECT u_id FROM account WHERE u_uname = ?";

            // Connect to the database
            ps = MyConnection.getConnection().prepareStatement(query);
      
            // Prepare the SQL statement
            ps.setString(1, uName);
      
            // Execute the query
            ResultSet resultSet = ps.executeQuery();
      
            // Retrieve the value of u_id
            if (resultSet.next()) {
              int userID = resultSet.getInt("u_id");
              AccountInformation.uID = userID;
              System.out.println("The received ID of "+uName+" is "+uID);
            } else {
              System.out.println("No record found for ID " + uID);
            }
      
            // Clean up resources
            resultSet.close();
            ps.close();
            // connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getuID() {
        System.out.println("The value of uID when getuID got called is "+AccountInformation.uID);
        return AccountInformation.uID;
    }

}
