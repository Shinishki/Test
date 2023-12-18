import javax.swing.*;
import java.sql.*;
public class sql_test_actually_its_easier_than_I_thought {
    String getSQL(String username,String sql_column_name) {
        String query = "select * from login_table where username=?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_accounts", "root", "");
            PreparedStatement ps;
            ResultSet rs = null;
            ps = con.prepareStatement(query);

            ps.setString(1, username);

            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login successfully");
                System.out.println(rs.next());

                return rs.getString(sql_column_name);
            } else {
                JOptionPane.showMessageDialog(null, "Erorr");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "Error";

    }

    int change_username(String str1, String str2) {
        String query = "update login_table set username=? where username=?";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_accounts", "root", "");
            PreparedStatement ps;
            ResultSet rs = null;
            ps = con.prepareStatement(query);
            ps.setString(1, str2);
            ps.setString(2, str1);
            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    int change_password(String str1, String str2) {
        String query = "update login_table set password=? where password=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_accounts", "root", "");
            PreparedStatement ps;
            ResultSet rs = null;
            ps = con.prepareStatement(query);
            ps.setString(1, str2);
            ps.setString(2, str1);
            ps.executeUpdate();
            return 1;
        } catch (SQLException|ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    void delete_account(String str1){
        String query = "delete from login_table where username=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_accounts", "root", "");
            PreparedStatement ps;
            ResultSet rs = null;
            ps = con.prepareStatement(query);
            ps.setString(1, str1);
            ps.executeUpdate();
        } catch (SQLException |ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
