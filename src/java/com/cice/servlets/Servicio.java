/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cice.servlets;

import com.cice.config.MyProperties;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cice
 */
public class Servicio extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Estoy llamando al servicio....");
        String modelo=  req.getParameter("modelo");
        String color = req.getParameter("color");
        String potencia=  req.getParameter("potencia");
        
          String usuario="root";
        String pass="root";
        String driver="com.mysql.jdbc.Driver";
        String host="jdbc:mysql://localhost:8889/t119";
        
        try {
            Class.forName(driver);
            Connection con =(Connection) DriverManager.getConnection(host, usuario, pass);
            
            String insert ="insert into coches (modelo,color,potencia) VALUES ('"+modelo+"','"+color+"','"+potencia+"')";
            Statement st = con.createStatement();
            st.execute(insert);
            
       
            st.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
        } catch (SQLException ex) {
          System.out.println(ex.getLocalizedMessage());
        } catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
        resp.sendRedirect("index.jsp");
   
    }
    
     /*public void init(ServletConfig config) throws ServletException {
         super.init(config);
        try {
            MyProperties.init("properties/config.properties");
            System.out.println("Se ha cargado la configuración");
        } catch (IOException ex) {
            System.out.println("Problema carga de configuración");
        }
    }*/




}
