package net.codejava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Model.MyDb;

public class PresDAO 
{
	MyDb newconn = new MyDb();
    public List<Pres> press() throws SQLException
    {
        List<Pres> listCategory = new ArrayList<>();
        try (Connection connection = newconn.getCon()) 
        {
            String sql = "select * from prescription"; 
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) 
            {
                int d_id = result.getInt("Doc_id");
                int p_id = result.getInt("Pat_id");
                String dat = result.getString("PDate");
                String mname = result.getString("Mname");
                int count = result.getInt("count");
                Pres pres = new Pres(d_id,p_id,dat,mname,count);
                     
                listCategory.add(pres);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return listCategory;
    }
    
    
}