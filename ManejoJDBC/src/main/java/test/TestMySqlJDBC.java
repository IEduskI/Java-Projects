package test;

import java.sql.*;


public class TestMySqlJDBC {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //En apliaciones web posiblemente sea requerido
            //Class.forName("com.mysql.cj.jdbc.driver");
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            Statement sentencia = conexion.createStatement();
            var sql = "SELECT id_persona,nombre,apellido,email,telefono FROM persona";
            ResultSet resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
                System.out.print("ID Persona: " + resultado.getInt("id_persona"));
                System.out.print(", Nombre: " + resultado.getString("nombre"));
                System.out.print(", Apellido: " + resultado.getString("apellido"));
                System.out.print(", Email: " + resultado.getString("email"));
                System.out.print(", Telefono: " + resultado.getString("telefono"));
                System.out.println("");
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
