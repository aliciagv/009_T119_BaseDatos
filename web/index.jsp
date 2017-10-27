<%-- 
    Document   : index
    Created on : 27-oct-2017, 20:47:23
    Author     : cice
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <header> <!-- cabecera --> 
            <div>
                <h1>Form JAVA</h1> <!-- Encabezado de nivel 1  span para dar énfasis-->
                <h3>by acilia</h3>
            </div>
        </header>
        <form action="./Servicio" method="POST">
            <label>Modelo: </label><input type="text" name="modelo"/></br>
            <label>Color: </label><input type="text" name="color"/></br>
            <label>Potencia: </label><input type="text" name="potencia"/></br>
            <input type="submit" value="Enviar">

        </form>
        <table>
            <thead>
                <tr> <!-- table row -->
                    <th>Id</th>
                    <th>Modelo</th>
                    <th>Color</th>
                    <th>Potencia</th>

                </tr>
            </thead>
            <tbody>

                <%

                    String usuario = "root";
                    String pass = "root";
                    String driver = "com.mysql.jdbc.Driver";
                    String host = "jdbc:mysql://localhost:8889/t119";

                    try {
                        Class.forName(driver);
                        Connection con = (Connection) DriverManager.getConnection(host, usuario, pass);
                        Statement st = con.createStatement();

                        String sql = "select * from coches";
                        ResultSet resultado = st.executeQuery(sql);
                        while (resultado.next()) {

                %>
                <tr>
                    <td><%=resultado.getString("id")%></td>
                    <td><%=resultado.getString("modelo")%></td>
                    <td><%=resultado.getString("color")%></td>
                    <td><%=resultado.getString("potencia")%></td>
                </tr>
                <%                          
                        }
                        resultado.close();
                        st.close();
                        con.close();

                    } catch (Exception ex) {
                        System.out.println(ex.getLocalizedMessage());
                    }

                %>

            </tbody>
        </table>
    </body>
</html>
