package datos;

import dominio.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;

public class UsuarioDAO {
    
    public static final String SELECT_BY_EMAIL = "SELECT * FROM usuario WHERE email = ?;";
    
    public Usuario obtenerUsuarioPorEmail(String email) {
        Usuario usuario = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_BY_EMAIL);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContrasena(rs.getString("contrasena"));
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        
        return usuario;
    }
    
    public boolean verificarContrasena(Usuario usuario, String contrasena){
        
        return usuario != null && usuario.getContrasena() .equals(contrasena);
    }
    
}
