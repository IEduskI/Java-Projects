package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Empleado;

public class EmpleadoDao {

    private static final String SQL_SELECT = "SELECT idEmpleado, Nombre, Edad, Sexo, Email FROM empleados";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM empleados WHERE idEmpleado = ?";
    private static final String SQL_INSERT = "INSERT INTO empleados(Nombre,Apellido,Edad,Sexo,Email,Activo) "
            + "VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empleados SET Nombre = ?, Apellido = ?, Edad = ?, "
            + "Sexo = ?, Email = ?, Activo = ? WHERE idEmpleado = ?";
    private static final String SQL_DELETE = "DELETE FROM empleados WHERE idEmpleado = ?";

    public List<Empleado> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Empleado> empleados = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String nombre = rs.getString("Nombre");
                int edad = rs.getInt("Edad");
                String sexo = rs.getString("Sexo");
                String email = rs.getString("Email");

                empleados.add(new Empleado(idEmpleado, nombre, edad, sexo, email));
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return empleados;
    }

    public Empleado encontrar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, empleado.getIdEmpleado());
            rs = stmt.executeQuery();
            rs.next();

            empleado.setNombre(rs.getString("Nombre"));
            empleado.setApellido(rs.getString("Apellido"));
            empleado.setEdad(rs.getInt("Edad"));
            empleado.setSexo(rs.getString("Sexo"));
            empleado.setEmail(rs.getString("Email"));
            empleado.setActivo(rs.getInt("Activo"));

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return empleado;
    }

    public int insertar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setInt(3, empleado.getEdad());
            stmt.setString(4, empleado.getSexo());
            stmt.setString(5, empleado.getEmail());
            stmt.setInt(6, empleado.getActivo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setInt(3, empleado.getEdad());
            stmt.setString(4, empleado.getSexo());
            stmt.setString(5, empleado.getEmail());
            stmt.setInt(6, empleado.getActivo());
            stmt.setInt(7, empleado.getIdEmpleado());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int eliminar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getIdEmpleado());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
}
