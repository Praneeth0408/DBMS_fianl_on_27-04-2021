package net.codejava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Model.MyDb;

public class MedicineDAO 
{
	MyDb newconn = new MyDb();
    public List<Medicine> medicines() throws SQLException
    {
        List<Medicine> listCategory = new ArrayList<>();
        try (Connection connection = newconn.getCon()) 
        {
            String sql = "SELECT * FROM medicines"; 
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) 
            {
                String mname = result.getString("Mname");
                float cost = result.getFloat("Cost");
                Medicine medicine = new Medicine(mname,cost);
                     
                listCategory.add(medicine);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return listCategory;
    }
}