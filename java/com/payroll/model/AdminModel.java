package com.payroll.model;
import java.util.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import com.payroll.connection.*;
import com.payroll.interfaces.*;
import com.payroll.dao.*;
import com.payroll.exceptions.*;
public class AdminModel extends JTextField
{
public AdminModel()
{
}

public void updatePassword(String password) throws DAOException
{
Admin admin=new Admin();
admin.updatePassword(password);
}

public void updateUsername(String username) throws DAOException
{
Admin admin=new Admin();
admin.updateUsername(username);
}



public boolean isRightAuthentication(String username,String password) throws DAOException
{
String u="",p="";
try{
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from Admin");
while(resultSet.next()==true)
{
resultSet.getInt("number");
u=resultSet.getString("username");
p=resultSet.getString("password");
resultSet.getString("lastLogin");

}
statement.close();
connection.close();
if(u.trim().equals(username)==true  && p.trim().equals(password)==true )
{
return true;
}
}catch(Exception e)
{
throw new DAOException("Invalid Username /Password !! "+e.getMessage());
}
return false;
}

public boolean checkUsername(String username) throws DAOException
{
String u="";
try{
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from Admin");
while(resultSet.next()==true)
{
resultSet.getInt("number");
u=resultSet.getString("username");
resultSet.getString("password");
resultSet.getString("lastLogin");
}
statement.close();
connection.close();
if(u.equals(username.trim())==true)
{
return true;
}
}catch(Exception e)
{
throw new DAOException("Can't Update Username  !! "+e.getMessage());
}
return false;
}


public boolean checkPassword(String password) throws DAOException
{
String u="";
try{
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from Admin");
while(resultSet.next()==true)
{
resultSet.getInt("number");
resultSet.getString("username");
u=resultSet.getString("password");
resultSet.getString("lastLogin");
}
statement.close();
connection.close();
if(u.equals(password.trim())==true)
{
return true;
}
}catch(Exception e)
{
throw new DAOException("Can't Update Password !! "+e.getMessage());
}
return false;
}

public String getLastLoginState() throws DAOException
{
String u="";
try{
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from Admin");
while(resultSet.next()==true)
{
resultSet.getInt("number");
resultSet.getString("username");
resultSet.getString("password");
u=resultSet.getString("lastLogin");
}
statement.close();
connection.close();
return u;
}catch(Exception e)
{
throw new DAOException("Can't Found Last Session Time !!");
}
}

public void setLastLoginState(String time) throws DAOException
{
try{
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
String stmt="update Admin set lastLogin='"+time+"' where number=1";
statement.executeUpdate(stmt);
statement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException("Can't Save Last Session Time !!");
}
}

}





