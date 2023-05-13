import java.sql.*;

public class AccountInformation {
    public static int uID;
    public static int Cash;
    public static String uName;
    public static String fName;
    public static String lName;

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
        return Cash;
    }

    public void updateCash() {
        try {
            PreparedStatement ps;
            String query = ("UPDATE account SET u_cash = "+AccountInformation.Cash+" WHERE u_id = ?");
            System.out.println(query);

            // Connect to the database
            ps = MyConnection.getConnection().prepareStatement(query);
      
            // Prepare the SQL statement
            ps.setInt(1, uID);
      
            // Execute the query
            ResultSet resultSet = ps.executeQuery();
      
            // Clean up resources
            resultSet.close();
            ps.close();
            // connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setAccInf() {
        try {
            PreparedStatement ps;
            String query = "SELECT u_fname, u_lname, u_uname, u_cash FROM account WHERE u_id = ?";

            // Connect to the database
            // Connection connection = DriverManager.getConnection(url, user, password);
            ps = MyConnection.getConnection().prepareStatement(query);
      
            // Prepare the SQL statement
            ps.setInt(1, uID);
      
            // Execute the query
            ResultSet resultSet = ps.executeQuery();
      
            // Retrieve the value of u_cash
            if (resultSet.next()) {
                AccountInformation.uName = resultSet.getString("u_uname");
                AccountInformation.fName = resultSet.getString("u_fname");
                AccountInformation.lName = resultSet.getString("u_lname");
                AccountInformation.Cash = resultSet.getInt("u_cash");
                System.out.println("Collected Information");
                System.out.println("First Name: "+fName);
                System.out.println("Last Name: "+lName);
                System.out.println("Username: "+uName);
                System.out.println("Cash: "+Cash);
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
}
