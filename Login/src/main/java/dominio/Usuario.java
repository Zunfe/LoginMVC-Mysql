
package dominio;


public class Usuario {
   
   int  idUsuario;
   String email;
   String contrasena;

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    public Usuario(int idUsuario, String email, String contrasena) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", email=" + email + ", contrasena=" + contrasena + '}';
    }
   
   
}
