
package datos;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;


public class UsuarioDao {
    private static final String SQL_SELECT = "SELECT * FROM usuarios";
    private static final String SQL_SELECT_BY_ID = "SELECT usuario,password FROM usuarios WHERE idUsuario = ?";
    private static final String SQL_VALIDATE = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
    private static final String SQL_INSERT = "INSERT INTO usuarios(usuario,password) "
            + "VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET usuario = ?, password = ? WHERE idUsuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE idUsuario = ?";
    
//    public List<Usuario> listar(){
//        
//    }
    
    public boolean validarUsuario(Usuario usuario) {
        boolean valido = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_VALIDATE);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            rs = stmt.executeQuery();
            rs.next();
            int row = rs.getRow();
            
            if(row == 1){
                valido = true;
            }  else {
                valido = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return valido;
    }
}
